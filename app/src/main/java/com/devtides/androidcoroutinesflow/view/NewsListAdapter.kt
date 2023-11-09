package com.devtides.coroutinesretrofit.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devtides.androidcoroutinesflow.databinding.ItemNewsArticleBinding
import com.devtides.androidcoroutinesflow.model.NewsArticle

class NewsListAdapter: RecyclerView.Adapter<NewsListAdapter.NewsItemViewHolder>() {

    private val newsItems = arrayListOf<NewsArticle>()

    fun onAddNewsItem(item: NewsArticle) {
        newsItems.add(0, item)
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
        NewsItemViewHolder(
            ItemNewsArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = newsItems.size

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(newsItems[position])
    }

    class NewsItemViewHolder(view: ItemNewsArticleBinding): RecyclerView.ViewHolder(view.root) {

        private val imageView = view.newsImage
        private val author = view.newsAuthor
        private val title = view.newsTitle
        private val publishedAt = view.newsPublishedAt

        fun bind(newsItem: NewsArticle) {
            imageView.loadImage(newsItem.urlToImage)
            author.text = newsItem.author
            title.text = newsItem.title
            publishedAt.text = newsItem.publishedAt
        }
    }
}