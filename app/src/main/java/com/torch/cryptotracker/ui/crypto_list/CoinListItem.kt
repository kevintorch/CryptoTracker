package com.torch.cryptotracker.ui.crypto_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.torch.cryptotracker.domain.model.Coin

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CoinListItem(modifier: Modifier = Modifier, coin: Coin) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                GlideImage(
                    model = coin.imageUrl,
                    contentDescription = coin.name,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    coin.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    coin.symbol,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}