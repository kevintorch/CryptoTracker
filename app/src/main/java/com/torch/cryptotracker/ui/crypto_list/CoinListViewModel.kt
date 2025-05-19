package com.torch.cryptotracker.ui.crypto_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.torch.cryptotracker.domain.model.Coin
import com.torch.cryptotracker.domain.repository.CoinRepository
import com.torch.cryptotracker.domain.repository.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinRepository: CoinRepository
) : ViewModel() {

    private val _coins = MutableStateFlow(CoinListState())
    val coins: StateFlow<CoinListState> = _coins

    init {
        fetchCoins()
    }

    @Suppress("UNCHECKED_CAST")
    private fun fetchCoins() {
        coinRepository.getCoins().onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    _coins.update { it.copy(isLoading = true) }
                }

                is Resource.Error -> {
                    _coins.update { it.copy(error = resource.message) }
                }

                is Resource.Success<*> -> {
                    _coins.update { it.copy(coins = resource.data as? List<Coin> ?: emptyList()) }
                }
            }
        }.launchIn(viewModelScope)
    }
}