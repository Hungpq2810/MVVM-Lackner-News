package com.androiddevs.mvvmnewsapp.repository

import androidx.lifecycle.LiveData
import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.models.Article
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, searchNewsPage: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, searchNewsPage)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews(): LiveData<List<Article>> = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}