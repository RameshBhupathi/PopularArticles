package io.ramesh.populararticles.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.ramesh.populararticles.MyApplication
import io.ramesh.populararticles.di.modules.ActivityModule
import io.ramesh.populararticles.di.modules.AppModule
import io.ramesh.populararticles.di.modules.NetWorkModule
import javax.inject.Singleton


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */

@Singleton
@Component(
    modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetWorkModule::class,
        ActivityModule::class
    )
)
internal interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): AppComponent.Builder

        fun build(): AppComponent
    }


}