package dev.brunofelix.pmovie.core.data.remote

import dev.brunofelix.pmovie.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class MovieInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val url = request.url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .addQueryParameter("language", BuildConfig.LANGUAGE)
            .build()

        val newRequest = request.newBuilder()
            .url(url)
            .build()

        return chain.proceed(newRequest)
    }
}