package com.torch.cryptotracker.di

import android.content.Context
import androidx.room.Room
import com.torch.cryptotracker.data.db.CoinDao
import com.torch.cryptotracker.data.db.CoinDatabase
import com.torch.cryptotracker.data.repository.CoinRepositoryImpl
import com.torch.cryptotracker.domain.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CoinDatabase {
        return Room.databaseBuilder(
            context,
            CoinDatabase::class.java,
            "coin_database"
        ).build()
    }

    @Provides
    fun provideCoinDao(database: CoinDatabase): CoinDao = database.coinDao()
}

