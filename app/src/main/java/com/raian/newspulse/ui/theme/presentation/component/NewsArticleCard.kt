package com.raian.newspulse.ui.theme.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.raian.newspulse.ui.theme.domain.models.Article

@Composable
fun NewsArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onCardClicked: (Article) -> Unit
) {
    Card(
        modifier = modifier
            .clickable { onCardClicked(article) }
            .padding(12.dp)
            .clipToBounds()
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            ImageHolder(imageUrl = article?.urlToImage?:"")
            Spacer(modifier = modifier.height(3.dp))
            Text(
                text = article.title!!,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
                )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )

            {
                Text(  text = article.source?.name?:"",
                    style = MaterialTheme.typography.bodySmall)


                Text(  text = article.publishedAt?:"",
                    style = MaterialTheme.typography.bodySmall)

            }
        }
    }
}