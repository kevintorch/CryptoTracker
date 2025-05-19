package com.torch.cryptotracker.domain.repository

import kotlinx.coroutines.flow.Flow

sealed class Resource {
    data class Success<T>(val data: T) : Resource()
    data class Error(val message: String) : Resource()
    object Loading : Resource()
}

interface CoinRepository {
    fun getCoins(): Flow<Resource>
}