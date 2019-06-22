package io.ramesh.populararticles.data.repository

import androidx.lifecycle.MutableLiveData
import io.ramesh.populararticles.data.remote.ApiService
import io.ramesh.populararticles.data.remote.Response
import io.ramesh.populararticles.data.remote.response.PopularArticlesResponse
import retrofit2.Call
import javax.inject.Inject


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */

class ProjectRepository @Inject constructor(apiService: ApiService) {

    private lateinit var apiService: ApiService

    init {
        this.apiService = apiService
    }

    fun getPopularArticles(): MutableLiveData<Response<*>> {
        val data = MutableLiveData<Response<*>>()
        apiService.getPopularArticles().enqueue(object : retrofit2.Callback<PopularArticlesResponse> {
            override fun onFailure(call: Call<PopularArticlesResponse>, t: Throwable) {

                data.value = Response(false, null, t.localizedMessage)
            }
            override fun onResponse(
                call: Call<PopularArticlesResponse>,
                response: retrofit2.Response<PopularArticlesResponse>
            ) {
                data.value = Response(true, response.body()?.results, response.message())
            }
        })

        return data
    }
}