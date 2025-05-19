package com.torch.cryptotracker.ui.crypto_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val coins = viewModel.coins.map { it.coins }.collectAsStateWithLifecycle(emptyList())

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Cryptocurrency Tracker") }
            )
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(coins.value) { coin ->
                CoinListItem(coin = coin)
            }
        }
    }
}
