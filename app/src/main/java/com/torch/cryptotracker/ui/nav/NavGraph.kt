package com.torch.cryptotracker.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.torch.cryptotracker.ui.crypto_detail.CoinDetail
import com.torch.cryptotracker.ui.crypto_list.CoinListScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = CoinList
    ) {
        composable<CoinList> {
            CoinListScreen()
        }

        composable<CoinDetail> {
            CoinDetail()
        }
    }
}