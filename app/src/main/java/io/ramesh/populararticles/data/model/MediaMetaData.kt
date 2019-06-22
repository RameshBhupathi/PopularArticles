package io.ramesh.populararticles.data.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */
data class MediaMetaData(
    @SerializedName("url") var url: String,
    @SerializedName("format") var format: String,
    @SerializedName("height") var height: Int,
    @SerializedName("width") var width: Int
) {

}