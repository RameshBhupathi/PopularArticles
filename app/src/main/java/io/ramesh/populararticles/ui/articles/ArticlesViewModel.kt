package io.ramesh.populararticles.ui.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.ramesh.populararticles.data.remote.Response
import io.ramesh.populararticles.data.repository.ProjectRepository
import javax.inject.Inject


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */

class ArticlesViewModel @Inject constructor(var repository: ProjectRepository) : ViewModel() {

    private var _articlesResponse = MutableLiveData<Response<*>>()

    val articlesResponse: LiveData<Response<*>>
        get() {
            return _articlesResponse
        }

    init {
        getArticles()
    }

    fun getArticles() {

        _articlesResponse = repository.getPopularArticles()
    }


}