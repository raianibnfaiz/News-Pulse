package com.raian.newspulse.ui.theme.data.repository

import com.raian.newspulse.ui.theme.domain.models.Article
import com.raian.newspulse.ui.theme.domain.util.Resource

interface NewsRepository {

    suspend fun getTopHeadlines(
        category:String
    ):Resource<List<Article>>
}