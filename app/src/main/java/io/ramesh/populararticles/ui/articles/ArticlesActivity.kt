package io.ramesh.populararticles.ui.articles

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import io.ramesh.populararticles.R
import io.ramesh.populararticles.data.model.Article
import io.ramesh.populararticles.databinding.ActivityArticlesBinding
import io.ramesh.populararticles.ui.articles_details.ArticleDetailsActivity
import io.ramesh.populararticles.util.AppViewModelFactory
import io.ramesh.populararticles.util.Constants.Companion.ARTICLE_ADX_KEYWORD
import io.ramesh.populararticles.util.Constants.Companion.ARTICLE_DETAILS_URL
import io.ramesh.populararticles.util.Utils
import io.ramesh.timesapidemo.view.articles.ArticleItemCallback
import javax.inject.Inject

class ArticlesActivity : DaggerAppCompatActivity(), LifecycleOwner, ArticleItemCallback {


    @Inject
    lateinit var viewmodelFactory: AppViewModelFactory
    private lateinit var dataBinding: ActivityArticlesBinding
    private lateinit var articlesViewModel: ArticlesViewModel
    private lateinit var articlesAdapter: ArticlesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_articles)
        articlesViewModel = ViewModelProviders.of(this, viewmodelFactory).get(ArticlesViewModel::class.java)

        if (Utils.isNetworkAvailable(this))
            getArticles()
    }

    private fun getArticles() {
        dataBinding.pbArticles.visibility = VISIBLE
        articlesViewModel.articlesResponse.observe(this, Observer {

            val articlesList: MutableList<Article> = it.data as MutableList<Article>
            if (it.status) {
                dataBinding.pbArticles.visibility = GONE
                articlesAdapter = ArticlesAdapter(this, articlesList, this)
                dataBinding.rvArticles.adapter = articlesAdapter

            } else {
                dataBinding.pbArticles.visibility = GONE
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun showArticleDetails(url: String?, keyword: String) {
        val articleDetailsIntent = Intent(this, ArticleDetailsActivity::class.java)
        articleDetailsIntent.putExtra(ARTICLE_DETAILS_URL, url)
        articleDetailsIntent.putExtra(ARTICLE_ADX_KEYWORD, keyword)
        startActivity(articleDetailsIntent)
    }


}
