# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class * extends com.stfalcon.chatkit.messages.MessageHolders$OutcomingTextMessageViewHolder {
     public <init>(android.view.View, java.lang.Object);
     public <init>(android.view.View);
 }
-keep class * extends com.stfalcon.chatkit.messages.MessageHolders$IncomingTextMessageViewHolder {
     public <init>(android.view.View, java.lang.Object);
     public <init>(android.view.View);
 }
-keep class * extends com.stfalcon.chatkit.messages.MessageHolders$IncomingImageMessageViewHolder {
     public <init>(android.view.View, java.lang.Object);
     public <init>(android.view.View);
 }
-keep class * extends com.stfalcon.chatkit.messages.MessageHolders$OutcomingImageMessageViewHolder {
     public <init>(android.view.View, java.lang.Object);
     public <init>(android.view.View);
 }

-keep class androidx.appcompat.widget.** { *; }

# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html
#
# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:



# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# some built in classes
-keep class io.codetail.animation.arcanimator.** { *; }
-keep class android.support.v7.widget.SearchView { *; }
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep class android.support.v7.app.** { *; }
-keep interface android.support.v7.app.** { *; }
-keep public class * extends android.app.Application
-keep class androidx.renderscript.**{*;}
-keep class com.synnapps.carouselview.** { *; }

#-dontoptimize
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
-android
-dontpreverify
-allowaccessmodification
-optimizations !code/simplification/arithmetic
-keepattributes *Annotation*


#-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider





#all view classes
-keepattributes *Annotation*
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * extends android.content.Context {
   public void *(android.view.View);
   public void *(android.view.MenuItem);
}
-keepclassmembers class * implements android.os.Parcelable {
    static ** CREATOR;
}
-keepclassmembers class **.R$* {
    public static <fields>;
}
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}
-keep class org.apache.commons.logging.**
-dontwarn javax.xml.stream.events.**
-dontwarn org.codehaus.jackson.**
-dontwarn org.apache.commons.logging.impl.**
-dontwarn org.apache.http.conn.scheme.**
-keep class com.google.gson.stream.** { *; }
-keep public class org.apache.commons.io.**
-keep public class com.google.gson.**
-keep public class com.google.gson.** {public private protected *;}
-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-dontnote okhttp3.**


# Okio
-keep class sun.misc.Unsafe { *; }
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-keep public class com.google.android.vending.licensing.ILicensingService
-dontnote com.android.vending.licensing.ILicensingService
-dontnote com.google.vending.licensing.ILicensingService
-dontnote com.google.android.vending.licensing.ILicensingService
-keepclassmembers enum * { *; }


# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
-keepclasseswithmembernames class * {
    native <methods>;
}


# Preserve some attributes that may be required for reflection.
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod
# Keep setters in Views so that animations can still work.
-keepclassmembers public class * extends android.view.View {
    void set*(***);
    *** get*();
}



# We want to keep methods in Activity that could be used in the XML attribute onClick.
-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}
# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
-keepclassmembers class **.R$* {
      public static <fields>;
   }

   # Preserve annotated Javascript interface methods.
   -keepclassmembers class * {
       @android.webkit.JavascriptInterface <methods>;
   }



   # The support libraries contains references to newer platform versions.
   # Don't warn about those in case this app is linking against an older
   # platform version. We know about them, and they are safe.

   -dontnote android.support.**
   -dontnote androidx.**
   -dontwarn android.support.**
   -dontwarn androidx.**




   # This class is deprecated, but remains for backward compatibility.

   -dontwarn android.util.FloatMath


   # Understand the @Keep support annotation.

   -keep class android.support.annotation.Keep
   -keep class androidx.annotation.Keep
   -keep @android.support.annotation.Keep class * {*;}
   -keep @androidx.annotation.Keep class * {*;}
   -keepclasseswithmembers class * {
       @android.support.annotation.Keep <methods>;
   }
   -keepclasseswithmembers class * {
       @androidx.annotation.Keep <methods>;
   }
   -keepclasseswithmembers class * {
       @android.support.annotation.Keep <fields>;
   }
   -keepclasseswithmembers class * {
       @androidx.annotation.Keep <fields>;
   }
   -keepclasseswithmembers class * {
       @android.support.annotation.Keep <init>(...);
   }
   -keepclasseswithmembers class * {
       @androidx.annotation.Keep <init>(...);
   }



   # These classes are duplicated between android.jar and org.apache.http.legacy.jar.
   -keep class com.google.ads.**
   -dontnote org.apache.http.**
   -dontnote android.net.http.**
   -optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
   -optimizationpasses 5
   -allowaccessmodification



   # The following are referenced but aren't required to run
   -keep class **.R
   -dontwarn org.apache.commons.logging.**


   # Gson uses generic type information stored in a class file when working with fields. Proguard
   # removes such information by default, so configure it to keep all of it.
   -keepattributes Signature



   # GSON
   -keepattributes *Annotation*
   -keepattributes Signature

   # Prevent R8 from leaving Data object members always null
   -keepclassmembers,allowobfuscation class * {
     @com.google.gson.annotations.SerializedName <fields>;
   }
   -keep public class com.google.gson.**
   -keep public class com.google.gson.** {public private protected *;}
   -keep class com.google.gson.stream.** { *; }

   -keep,allowobfuscation,allowshrinking class com.google.gson.reflect.TypeToken
   -keep,allowobfuscation,allowshrinking class * extends com.google.gson.reflect.TypeToken


# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }


-keep class com.devbeans.io.chat.receiver.ExpiryReceiver {*;}
-keep class com.devbeans.io.chat.models.** {*;}


# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
  *** rewind();
}


## For Database

-keep class net.sqlcipher.** { *; }
-keep class net.sqlcipher.database.** { *; }

-keep class com.sun.jna.** { *; }


## For Key Store and App session
-keep class javax.crypto.**


-keepattributes *Annotation*,EnclosingMethod,Signature
-keep class com.fasterxml.jackson.** {
*;
}
-keep interface com.fasterxml.jackson.** {
    *;
}
-dontwarn com.fasterxml.jackson.databind.**
-keep class org.codehaus.** { *; }
-dontwarn ezvcard.io.html.HCardPage


# Uncomment for DexGuard only
#-keepresourcexmlelements manifest/application/meta-data@value=GlideModule
#helpful links
#https://www.zacsweers.dev/android-proguard-rules/
#https://guides.codepath.com/android/Configuring-ProGuard
#https://stackoverflow.com/questions/15543607/assertionerror-in-gson-enumtypeadapter-when-using-proguard-obfuscation


