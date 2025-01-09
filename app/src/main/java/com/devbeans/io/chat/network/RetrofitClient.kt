package com.devbeans.io.chat.network

import android.content.Context
import android.util.Log
import com.devbeans.io.chat.R
import com.devbeans.io.chat.app.MainApp
import com.devbeans.io.chat.utils.AndroidUtil
import com.devbeans.io.chat.utils.Configurations
import com.google.gson.GsonBuilder
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {
        //        var BASE_URLS ="http://192.168.101.88:3005"
        var BASE_URLS = Configurations.kDSBaseUrl


        fun createRetroCLient(): Retrofit {

            val gson = GsonBuilder().create()
            val context: Context = MainApp.appContext!!.getAppContext()!!
            val httpClient = OkHttpClient.Builder()
            httpClient.retryOnConnectionFailure(true)
            httpClient.connectTimeout(30, TimeUnit.SECONDS)
            httpClient.readTimeout(40, TimeUnit.SECONDS)
            httpClient.writeTimeout(40, TimeUnit.SECONDS)
            httpClient.certificatePinner(Configurations.certPinner)
            httpClient.addInterceptor(getLoggingIntercept()!!)
//        OkHttpClient client = getUnsafeOkHttpClient();
            //        OkHttpClient client = getUnsafeOkHttpClient();
            val cookieManager = CookieManager()
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
            httpClient.cookieJar(JavaNetCookieJar(cookieManager))
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URLS!!)
                .client(getUnsafeOkHttpClient()!!)
                .build()

            return retrofit
        }

        private fun getLoggingIntercept(): Interceptor? {
            val logging = HttpLoggingInterceptor { message: String ->
                Log.e(
                    " Network.TAG",
                    "getLoggingIntercept: $message"
                )
            }
            return logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        fun getUnsafeOkHttpClient(): OkHttpClient? {
            return try {

                val builder = OkHttpClient.Builder()
                builder.retryOnConnectionFailure(true)
                builder.connectTimeout(30, TimeUnit.SECONDS)
                builder.readTimeout(40, TimeUnit.SECONDS)
                builder.writeTimeout(40, TimeUnit.SECONDS)
                builder.addInterceptor(Network.getLoggingIntercept())
                builder.certificatePinner(Configurations.certPinner)
                builder.build()
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }

    }


}