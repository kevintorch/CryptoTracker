package com.torch.cryptotracker.data.mapper

import com.torch.cryptotracker.data.db.CoinEntity
import com.torch.cryptotracker.data.model.CoinDto
import com.torch.cryptotracker.domain.model.Coin

fun CoinDto.toEntity(): CoinEntity = CoinEntity(
    id = id,
    symbol = symbol,
    name = name,
    imageUrl = image,
    currentPrice = currentPrice,
    marketCap = marketCap,
    priceChangePercentage24h = priceChangePercentage24h,
    lastUpdated = System.currentTimeMillis()
)

fun CoinEntity.toDomain(): Coin {
    return Coin(
        id = id,
        name = name,
        symbol = symbol,
        imageUrl = imageUrl,
        currentPrice = currentPrice,
        priceChangePercentage24h = priceChangePercentage24h
    )
}