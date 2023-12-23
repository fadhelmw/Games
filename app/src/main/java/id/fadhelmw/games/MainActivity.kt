package id.fadhelmw.games


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import id.fadhelmw.games.ui.nav.SetupNavHost
import id.fadhelmw.games.ui.theme.GamesTheme

// Kelas MainActivity sebagai entry point aplikasi yang menggunakan AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Fungsi onCreate untuk inisialisasi aktivitas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            GamesTheme {
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    val navController = rememberNavController()
                    SetupNavHost(navController = navController, gameViewModel = viewModel())
                }

            }
        }
    }
}