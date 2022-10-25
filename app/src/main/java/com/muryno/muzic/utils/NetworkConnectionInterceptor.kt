package com.muryno.muzic.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(context: Context) : Interceptor {

    private val applicationContext: Context = context.applicationContext;

    @RequiresApi(Build.VERSION_CODES.M)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (isNetworkAvailable() == 0) {
            throw NoInternetException("Make sure you have an active data connection")
        } else {
            return chain.proceed(chain.request())
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isNetworkAvailable(): Int {
        var result = 0 // Returns connection type. 0: none; 1: mobile data; 2: wifi
        val cm =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        val capabilities = cm?.getNetworkCapabilities(cm.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    result = 2
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    result = 1
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> {
                    result = 3
                }
            }
        }
        return result
    }
}