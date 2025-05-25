package com.torch.cryptotracker.ui.crypto_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.torch.cryptotracker.domain.model.Coin
import kotlinx.coroutines.flow.map


@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    viewModel: CoinListViewModel = hiltViewModel()
) {

    val coinList by viewModel.uiState.map { it.coins }.collectAsStateWithLifecycle(emptyList())
    val isLoading by viewModel.uiState.map { it.isLoading }.collectAsStateWithLifecycle(false)

    CoinList(
        modifier,
        coinList,
        isLoading
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun CoinList(
    modifier: Modifier = Modifier,
    coins: List<Coin> = emptyList(),
    isLoading: Boolean = false
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Cryptocurrency Tracker") }
            )
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            if (isLoading) {
                item {
                    Box(modifier = Modifier.fillParentMaxSize()) {
                        CircularProgressIndicator()
                    }
                }
            }
            items(coins) { coin ->
                CoinListItem(coin = coin)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoinListPreview() {
    CoinList(
        coins = listOf(
            Coin(
                id = "bitcoin",
                name = "Bitcoin",
                symbol = "BTC",
                imageUrl = "https://picsum.photos/200",
                currentPrice = 105108.0,
                priceChangePercentage24h = 1.0
            ),
        )
    )
}