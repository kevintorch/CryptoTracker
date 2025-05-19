package com.torch.cryptotracker.data.repository

import com.torch.cryptotracker.data.api.CryptoService
import com.torch.cryptotracker.data.db.CoinDao
import com.torch.cryptotracker.data.mapper.toDomain
import com.torch.cryptotracker.data.mapper.toEntity
import com.torch.cryptotracker.domain.repository.CoinRepository
import com.torch.cryptotracker.domain.repository.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CryptoService,
    private val dao: CoinDao
) : CoinRepository {

    override fun getCoins(): Flow<Resource> = flow {
        emit(Resource.Loading)
        try {
            val coins = api.getCryptoList().map { it.toEntity() }
            dao.clearAll()
            dao.insertAll(coins)
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown error"))
        }

        emitAll(dao.getAll().map { coins ->
            Resource.Success(coins.map { it.toDomain() })
        })
    }
}