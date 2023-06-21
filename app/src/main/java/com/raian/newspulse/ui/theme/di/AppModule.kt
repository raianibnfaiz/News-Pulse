package com.raian.newspulse.ui.theme.di

import com.raian.newspulse.ui.theme.data.remote.NewsApi
import com.raian.newspulse.ui.theme.data.remote.NewsApi.Companion.BASE_URL
import com.raian.newspulse.ui.theme.data.repository.NewsRepository
import com.raian.newspulse.ui.theme.domain.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi():NewsApi{
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi):NewsRepository
    {
        return NewsRepositoryImpl(newsApi)
    }
}