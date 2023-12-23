package id.fadhelmw.games.repository

import id.fadhelmw.games.data.remote.GamesService
import id.fadhelmw.games.domain.item.GameItem
import id.fadhelmw.games.domain.item.GroupGameItem
import id.fadhelmw.games.domain.item.toGameItem
import id.fadhelmw.games.domain.item.toGroupGameItem
import javax.inject.Inject

// Kelas repository untuk berinteraksi dengan layanan game (GamesService)
class GameRepository @Inject constructor(private val gamesService : GamesService){

    // mendapatkan daftar game dan mengonversinya ke dalam bentuk GameItem
    suspend fun getGames(): List<GameItem> {
        return gamesService.getGames().map {
            it.toGameItem()

        }
    }

    // mendapatkan informasi game berdasarkan ID dan merubah ke bentuk GroupGameItem
    suspend fun getGameById(id: Int): GroupGameItem {
        return gamesService.getGameById(id).toGroupGameItem()
    }
}