package com.torch.cryptotracker.di

import com.torch.cryptotracker.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CoinListModule::class]
)
object FakeCoinListModule {

    @Provides
    fun provideFakeCoinRepository(): CoinRepository {
        return FakeCoinRepository()
    }
}
