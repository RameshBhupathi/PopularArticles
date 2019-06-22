package io.ramesh.populararticles.data.remote

import io.ramesh.populararticles.data.remote.response.PopularArticlesResponse
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */

interface ApiService {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json")
    fun getPopularArticles() : Call<PopularArticlesResponse>
   // http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=07G0hgyLw8uBdLpoJGG1DimAzlYhvSsu

}