package io.ramesh.populararticles.ui.articles

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import io.ramesh.populararticles.R
import io.ramesh.populararticles.data.model.Article
import io.ramesh.populararticles.databinding.ArticlesItemBinding
import io.ramesh.populararticles.util.GlideApp
import io.ramesh.timesapidemo.view.articles.ArticleItemCallback


/**
 * Created by Ramesh Bhupathi on 2019-06-22.
 */
class ArticlesAdapter(var context: Context, var articles: MutableList<Article>?, var callback: ArticleItemCallback) :
    RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var articlesBinding = DataBindingUtil.inflate<ArticlesItemBinding>(
            layoutInflater, R.layout.articles_item,
            parent, false
        )
        return ArticlesViewHolder(articlesBinding)
    }

    override fun getItemCount(): Int {

        return articles?.size ?: 0
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {

        val article = articles?.get(position)
        holder.binding.article = article


        holder.binding.root.setOnClickListener {
            callback.showArticleDetails(article?.url, article?.adx_keywords!!.split(";")[0])
        }

        GlideApp.with(context).load(
            article?.media?.get(0)?.mediaMetadata?.get(0)?.url
        ).placeholder(R.drawable.ic_newspaper)
            .error(R.drawable.ic_newspaper)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(holder.binding.ivArticle)

    }

    class ArticlesViewHolder(articlesBinding: ArticlesItemBinding) : RecyclerView.ViewHolder(articlesBinding.root) {
        var binding: ArticlesItemBinding = articlesBinding
    }

}