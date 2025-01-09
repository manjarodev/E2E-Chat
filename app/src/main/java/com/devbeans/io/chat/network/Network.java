package com.devbeans.io.chat.network;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.app.MainApp;
import com.devbeans.io.chat.network.serializers.response.BaseResponse;
import com.devbeans.io.chat.utils.Configurations;
import com.devbeans.io.chat.utils.Utills;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Network {
    private static final String TAG = "Network";
    public static OkHttpClient.Builder httpClient;
    private static Network object;
    private final ApiServices services;
    private Retrofit networkClient = null;


    private Network() {
        Gson gson = new GsonBuilder().create();
        Context context = MainApp.Companion.getAppContext();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.retryOnConnectionFailure(true);
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(40, TimeUnit.SECONDS);
        httpClient.writeTimeout(40, TimeUnit.SECONDS);
        httpClient.certificatePinner(Configurations.INSTANCE.getCertPinner());
        httpClient.addInterceptor(getLoggingIntercept());
        httpClient.addInterceptor(chain -> {
            PackageInfo pInfo = null;
            try {
                pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            String version = pInfo.versionName;
//            String token = User.init().getToken();
            String token = null;
            if (token != null) {
                Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(request);
            } else {
                Request request = chain.request().newBuilder()
                        .build();
                return chain.proceed(request);
            }
        });
//        OkHttpClient client = getUnsafeOkHttpClient();
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        httpClient.cookieJar(new JavaNetCookieJar(cookieManager))
                .build();

        networkClient = new Retrofit.Builder()
                .baseUrl(Configurations.INSTANCE.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getUnsafeOkHttpClient())
                .build();
        services = networkClient.create(ApiServices.class);
        Network.httpClient = httpClient;

    }

    public synchronized static Network getInstance() {
        if (object == null) {
            object = new Network();
        }
        return object;
    }

    public static void clearInstance() {
        object = null;
    }

    public static ApiServices apis() {
        return Network.getInstance().getApiServices();
    }

    public static String getBaseUrl() {
        return getNetworkClient().baseUrl().toString();
    }

    private static Retrofit getNetworkClient() {
        if (object == null)
            getInstance();
        return getInstance().networkClient;
    }

    public static BaseResponse parseErrorResponse(Response response) {
        BaseResponse errorResponse = null;
        try {
            if (ResponseCode.isBetweenSuccessRange(response.code())) {
                return (BaseResponse) response.body();
            } else {
                Converter<ResponseBody, BaseResponse> errorConverter =
                        getInstance().getNetworkClient().responseBodyConverter(BaseResponse.class, new Annotation[0]);
                errorResponse = errorConverter.convert(response.errorBody());
                errorResponse.setCode(response.code());
                if (errorResponse.getMessage() == null
                        || errorResponse.getMessage().equalsIgnoreCase("")) {
                    errorResponse.setMessage("Unable to communicate with " + Utills.INSTANCE.getString(R.string.app_name) + " server, please try again.");
                }
                return errorResponse;
            }
        } catch (Exception e) {
//            Logger.log(Logger.EXCEPTION, e);
            errorResponse = new BaseResponse();
            errorResponse.setCode(response.code());
            String errorString;
            try {
                errorString = response.errorBody().string();
            } catch (Exception ex) {
                errorString = Utills.INSTANCE.getString(R.string.exceptionInErrorResponse);
            }
            if (errorString == null || errorString.trim().equalsIgnoreCase("")) {
                errorString = "Unable to communicate with " + Utills.INSTANCE.getString(R.string.app_name) + " server, try again.";
            }
            errorResponse.setMessage(errorString);
            return errorResponse;
        }
    }

    public ApiServices getApiServices() {
        return object.services;
    }



    public static Interceptor getLoggingIntercept() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> {
//            Log.e(TAG, "getLoggingIntercept: " + message);
           /*if (Configurations.isProduction() && AppSession.getBoolean(Constants.IS_LOGGED_IN)) {
               Logger.log("OkHttp", message);
//                Log.e("OKHTTP::"," "+message);
           } else {
               Logger.log("okHttp", message);
//                Log.e("OKHTTP::"," 2 ="+message);
           }*/
        });
        return logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public static OkHttpClient getUnsafeOkHttpClient() {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.retryOnConnectionFailure(true);
            builder.connectTimeout(30, TimeUnit.SECONDS);
            builder.readTimeout(40, TimeUnit.SECONDS);
            builder.writeTimeout(40, TimeUnit.SECONDS);
            builder.certificatePinner(Configurations.INSTANCE.getCertPinner());
            builder.addInterceptor(getLoggingIntercept());

            return builder.build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static class BasicAuthInterceptor implements Interceptor {
        private final String credentials;

        public BasicAuthInterceptor(String user, String password) {
            this.credentials = Credentials.basic(user, password);
        }

        @NonNull
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request authenticatedRequest = request.newBuilder()
                    .header("Authorization", credentials).build();
            return chain.proceed(authenticatedRequest);
        }
    }
}
