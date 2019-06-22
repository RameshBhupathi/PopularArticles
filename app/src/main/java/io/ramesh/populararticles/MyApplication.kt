package io.ramesh.populararticles

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.ramesh.populararticles.di.components.DaggerAppComponent


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */


class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerAppComponent.builder().application(this).build()
    }

}
