package io.ramesh.populararticles.data.remote

import io.ramesh.populararticles.util.Constants.Companion.API_KEY
import okhttp3.Interceptor
import okhttp3.Response


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */
class Requestnterceptor : Interceptor {

    //svc/mostpopular/v2/mostviewed/all-sections/7.json?api-
    //key=sample-key

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()

        val urlWithApiKey = request.url().newBuilder().addQueryParameter("api-key", API_KEY).build()


        return chain.proceed(request.newBuilder().url(urlWithApiKey).build())

    }

}