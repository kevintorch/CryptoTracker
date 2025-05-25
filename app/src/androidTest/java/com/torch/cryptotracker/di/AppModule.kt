package com.torch.cryptotracker.di

import android.content.Context
import androidx.room.Room
import com.torch.cryptotracker.data.db.CoinDao
import com.torch.cryptotracker.data.db.CoinDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
object TestAppModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CoinDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            CoinDatabase::class.java,
        ).build()
    }

    @Provides
    fun provideCoinDao(database: CoinDatabase): CoinDao = database.coinDao()
}

