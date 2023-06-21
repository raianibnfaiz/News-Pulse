package com.raian.newspulse.ui.theme.presentation.news_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.raian.newspulse.ui.theme.presentation.component.NewsArticleCard
import com.raian.newspulse.ui.theme.presentation.component.NewsScreenTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(viewModel: NewsScreenViewModel = hiltViewModel()) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar =
            {
                NewsScreenTopBar(
                    scrollBehavior = scrollBehavior,
                    onSearchIconClicked = {})

            }

    ) {padding->
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            contentPadding = PaddingValues(15.dp),
            modifier = Modifier.padding(padding)
        ){
            items(viewModel.articles){articles->
                NewsArticleCard(article = articles, onCardClicked ={} )
            }
        }
    }

}