package com.raian.newspulse.ui.theme.data.remote

import com.raian.newspulse.ui.theme.domain.models.NewsSource
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=2e28207b12314046a20174f3ddcad03a

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("category") category:String,
        @Query("country") country:String= "us",
        @Query("apiKey") apiKey:String = API_KEY
    ): NewsSource


    companion object{
        const val API_KEY="2e28207b12314046a20174f3ddcad03a"
        const val BASE_URL="https://newsapi.org/v2/"
    }
}