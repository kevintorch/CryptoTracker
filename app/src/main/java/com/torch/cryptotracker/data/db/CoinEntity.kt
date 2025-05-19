package com.torch.cryptotracker.data.db

import androidx.room.Entity

@Entity(tableName = "coins", primaryKeys = ["id"])
data class CoinEntity(
    val id: String,
    val symbol: String,
    val name: String,
    val imageUrl: String,
    val currentPrice: Double,
    val marketCap: Long,
    val priceChangePercentage24h: Double,
    val lastUpdated: Long  // for caching
)

