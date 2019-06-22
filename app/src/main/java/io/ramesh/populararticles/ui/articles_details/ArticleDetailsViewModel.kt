package io.ramesh.populararticles.ui.articles_details

import androidx.lifecycle.ViewModel
import io.ramesh.populararticles.data.repository.ProjectRepository
import javax.inject.Inject


/**
 * Created by Ramesh Bhupathi on 2019-06-22..
 */
class ArticleDetailsViewModel @Inject constructor(private val repository: ProjectRepository) : ViewModel() {
    var articleUrl: String? = null
    var title: String? = null
}