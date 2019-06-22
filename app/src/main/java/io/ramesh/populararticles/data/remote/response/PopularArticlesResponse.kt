package io.ramesh.populararticles.data.remote.response

import io.ramesh.populararticles.data.model.Article


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */

data class PopularArticlesResponse(var results: MutableList<Article>) : BaseResponse() {

}