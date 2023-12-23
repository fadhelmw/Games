package id.fadhelmw.games.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import id.fadhelmw.games.domain.item.GameItem
import id.fadhelmw.games.ui.GameViewModel
import id.fadhelmw.games.ui.nav.Screens

// composable screen untuk tampilan beranda (home) aplikasi - scrollable list
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(gameViewModel: GameViewModel, navController: NavController) {
    // Mengambil daftar game dari ViewModel
    val games = gameViewModel.games.observeAsState(listOf()).value
    // Scaffold sebagai struktur dasar tampilan dengan TopAppBar dan konten utama
    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(text = "Games FPS", fontWeight = FontWeight.Bold)

                }

            )

        }

    ) {

        LazyColumn {

            items(games) { game ->
                // Menampilkan setiap game menggunakan GameCard
                GameCard(game = game, navController = navController)

            }

        }

    }

}
// Komposable untuk menampilkan detail setiap game dalam bentuk kartu (Card)
@Composable
fun GameCard(game: GameItem, navController: NavController) {

    Card(

        elevation = 7.dp,
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 7.dp, bottom = 7.dp, start = 14.dp, end = 14.dp)
            .clickable {
                // Menavigasi ke tampilan detail game saat kartu diklik
                navController.navigate(Screens.Detail.route + "/${game.id}")
            }

    ) {

        Row {
            // Gambar game menggunakan Coil untuk memuat gambar dari URL
            Image(
                painter = rememberImagePainter(game.thumbnail),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(175.dp).height(115.dp)
            )

            Column(modifier = Modifier.padding(10.dp).align(Alignment.CenterVertically)) {

                Text(text = game.title, fontWeight = FontWeight.Bold)
                Text(text = game.publisher, fontWeight = FontWeight.SemiBold)
                Text(text = game.short_description, maxLines = 2, overflow = TextOverflow.Ellipsis)

            }

        }

    }

}