package com.raian.newspulse.ui.theme.domain.models

data class NewsSource(
    val articles: List<Article>?,
    val status: String?,
    val totalResults: Int?
)