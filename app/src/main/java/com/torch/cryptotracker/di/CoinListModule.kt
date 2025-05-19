package com.torch.cryptotracker.di

import com.torch.cryptotracker.data.repository.CoinRepositoryImpl
import com.torch.cryptotracker.domain.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoinListModule {

    @Binds
    abstract fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository
}