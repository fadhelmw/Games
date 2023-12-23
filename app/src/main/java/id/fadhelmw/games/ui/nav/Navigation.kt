package id.fadhelmw.games.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.fadhelmw.games.ui.GameViewModel
import id.fadhelmw.games.ui.screen.DetailScreen
import id.fadhelmw.games.ui.screen.HomeScreen
import id.fadhelmw.games.util.Constants.Companion.KEY_GAME_ID
import id.fadhelmw.games.util.Constants.Screens.DETAIL_SCREEN
import id.fadhelmw.games.util.Constants.Screens.HOME_SCREEN

// Sealed class yang merepresentasikan layar dalam aplikasi dengan rute navigasi
sealed class Screens (val route: String){

    object Home: Screens(route = HOME_SCREEN)
    object Detail: Screens(route = DETAIL_SCREEN)

}
// Fungsi untuk mengatur NavHost dengan daftar composable screens
@Composable
fun SetupNavHost(navController: NavHostController, gameViewModel: GameViewModel) {

    NavHost(navController = navController, startDestination = Screens.Home.route) {

        // composable screen untuk tampilan beranda (home)
        composable(route = Screens.Home.route) {
            HomeScreen(gameViewModel = gameViewModel, navController = navController)
        }
        // composable screen untuk tampilan detail dengan parameter ID
        composable(route = Screens.Detail.route + "/{$KEY_GAME_ID}") { backStackEntry ->
            DetailScreen(id = backStackEntry.arguments?.getString(KEY_GAME_ID)?: "1", gameViewModel = gameViewModel, navController = navController)
        }

    }

}