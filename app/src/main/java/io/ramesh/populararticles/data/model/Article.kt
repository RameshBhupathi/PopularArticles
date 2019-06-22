package io.ramesh.populararticles.data.model


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */

data class Article(
    var id: Long, var title: String, var byline: String,
    var published_date: String, var url: String, var adx_keywords: String,
    var media: List<Media>
) {

}