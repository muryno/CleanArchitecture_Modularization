package com.muryno.muzic.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor that checks if the device has an active internet connection.
 *
 * @property applicationContext the application context
 */
class NetworkConnectionInterceptor(private val applicationContext: Context) : Interceptor {

    /**
     * Intercepts the [chain] and throws a [NoInternetException] if there is no active internet connection.
     *
     * @param chain the chain of interceptors
     * @return the response
     * @throws NoInternetException if there is no active internet connection
     */
    @RequiresApi(Build.VERSION_CODES.M)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isNetworkAvailable()) {
            throw NoInternetException("Ensure you have an active internet connection")
        } else {
            return chain.proceed(chain.request())
        }
    }

    /**
     * Checks if the device has an active internet connection.
     *
     * @return true if the device has an active internet connection, false otherwise
     */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun isNetworkAvailable(): Boolean {
        val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = cm.activeNetwork?.let { cm.getNetworkCapabilities(it) }
        return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }
}
