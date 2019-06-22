package io.ramesh.populararticles.data.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */
data class Media(
    var article_id: Long,
    var type: String,
    var subtype: String,
    var caption: String,
    var copyright: String,
    @SerializedName("media-metadata")
    var mediaMetadata: List<MediaMetaData>
) {

}