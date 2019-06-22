package io.ramesh.populararticles.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.ramesh.populararticles.di.ViewModelKey
import io.ramesh.populararticles.ui.articles.ArticlesViewModel
import io.ramesh.populararticles.ui.articles_details.ArticleDetailsViewModel
import io.ramesh.populararticles.util.AppViewModelFactory


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ArticlesViewModel::class)
    internal abstract fun bindArticlesViewModel(articlesViewModel: ArticlesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArticleDetailsViewModel::class)
    internal abstract fun bindArticleDetailsViewModel(articleDetailsViewModel: ArticleDetailsViewModel): ViewModel



    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory


}