package com.raian.newspulse.ui.theme.domain.repository



import android.util.Log
import com.raian.newspulse.ui.theme.data.remote.NewsApi
import com.raian.newspulse.ui.theme.data.repository.NewsRepository
import com.raian.newspulse.ui.theme.domain.models.Article
import com.raian.newspulse.ui.theme.domain.util.Resource
import java.lang.Exception

private const val TAG = "NewsRepositoryImpl"
class NewsRepositoryImpl(private val newsApi: NewsApi):NewsRepository {
    override suspend fun getTopHeadlines(category: String): Resource<List<Article>> {
        return try{
            val response = newsApi.getBreakingNews(category = category)
            Log.d(TAG, "getTopHeadlines: ${response.articles}")
            Resource.Success(data = response.articles)

        }catch (e:Exception){
            Log.d(TAG, "getTopHeadlines: ${e.message}")
            Resource.Error(message = "Failed to fetch news ${e.message}")

        }
    }
}