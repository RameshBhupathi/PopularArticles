package io.ramesh.populararticles.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */
class Utils {
    companion object {

        fun isNetworkAvailable(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var activeNetworkInfo: NetworkInfo? = null
            activeNetworkInfo = cm.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
        }
    }
}