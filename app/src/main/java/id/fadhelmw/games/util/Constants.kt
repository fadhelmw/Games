package id.fadhelmw.games.util

// Kelas Constants berisi nilai-nilai tetap yang digunakan dalam aplikasi.
class Constants {
    companion object {
        // Base URL untuk API game
        const val BASE_URL = "https://www.freetogame.com/api/"
        // Endpoint untuk mendapatkan daftar game yang diinginkan
        const val GAMES_ENDPOINT = "games?category=shooter"
        // Endpoint untuk mendapatkan informasi game berdasarkan ID
        const val GAMES_ID_ENDPOINT = "game?id="
        // Untuk mengirimkan ID game sebagai argumen navigasi
        const val KEY_GAME_ID = "id.fadhelmw.games.id"
    }
    // Objek nested Screens berisi rute untuk navigasi antar layar
    object Screens {

        const val HOME_SCREEN = "home_screen"
        const val DETAIL_SCREEN = "detail_screen"

    }

}