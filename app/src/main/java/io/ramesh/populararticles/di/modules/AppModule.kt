package io.ramesh.populararticles.di.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import io.ramesh.populararticles.MyApplication
import javax.inject.Singleton


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */

@Module(includes = [ViewModelModule::class])
abstract class AppModule {
    @Binds
    @Singleton
    internal abstract fun bindContext(application: MyApplication): Context
}