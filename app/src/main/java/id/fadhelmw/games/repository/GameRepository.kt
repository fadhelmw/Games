package id.fadhelmw.games.repository

import id.fadhelmw.games.data.remote.GamesService
import id.fadhelmw.games.domain.item.GameItem
import id.fadhelmw.games.domain.item.toGameItem
import javax.inject.Inject


class GameRepository @Inject constructor(private val gamesService : GamesService){

    suspend fun getGames(): List<GameItem> {
        return gamesService.getGames().map {
            it.toGameItem()

        }
    }
}