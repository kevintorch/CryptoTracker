package com.torch.cryptotracker.di

import com.torch.cryptotracker.domain.model.sampleData
import com.torch.cryptotracker.domain.repository.CoinRepository
import com.torch.cryptotracker.domain.repository.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeCoinRepository : CoinRepository {
    override fun getCoins(): Flow<Resource> = flow {
        emit(Resource.Success(sampleData))
    }
}
