package com.mohamedhashim.verycreatives_task.network

import com.mohamedhashim.verycreatives_task.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val url = originalUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}