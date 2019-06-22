package io.ramesh.populararticles.data.remote


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */
data class Response<out T>(val status: Boolean, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Response<T> {
            return Response(true , data, null)
        }

        fun <T> error(msg: String, data: T?): Response<T> {
            return Response(false, data, msg)
        }

    }
}
