package com.torch.cryptotracker.ui.crypto_list

import com.torch.cryptotracker.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String? = null
)
