package io.ramesh.populararticles.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.ramesh.populararticles.ui.articles.ArticlesActivity


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */


@Module
abstract class ActivityModule {


    @ContributesAndroidInjector
    internal abstract fun contributeArticlesActivity(): ArticlesActivity

}