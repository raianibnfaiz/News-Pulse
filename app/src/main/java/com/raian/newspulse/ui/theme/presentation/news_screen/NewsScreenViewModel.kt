package com.raian.newspulse.ui.theme.presentation.news_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raian.newspulse.ui.theme.data.repository.NewsRepository
import com.raian.newspulse.ui.theme.domain.models.Article
import com.raian.newspulse.ui.theme.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "NewsScreenViewModel"
@HiltViewModel
class NewsScreenViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {
    var articles by mutableStateOf<List<Article>>(emptyList())
    init {
        getNewsArticles(category = "general")
    }

    private fun getNewsArticles(category: String){
        viewModelScope.launch {
            val result = newsRepository.getTopHeadlines(category = category)
            when(result){
                is Resource.Success ->{
                    articles = result.data?: emptyList()
                }
                is Resource.Error ->
                    Log.d(TAG, "getNewsArticles: Error")
            }
        }
    }
}