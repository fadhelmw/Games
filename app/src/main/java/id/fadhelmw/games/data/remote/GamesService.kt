package id.fadhelmw.games.data.remote;

import id.fadhelmw.games.data.remote.model.GameModel
import id.fadhelmw.games.data.remote.model.GroupGameModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
//kelas yang menyediakan layanan untuk mendapatkan informasi game melalui GamesApi
class GamesService @Inject constructor(private val gamesApi: GamesApi){
    //mendapatkan daftar game dari API
        suspend fun getGames(): List<GameModel> {
            return withContext(Dispatchers.IO) {
                val games = gamesApi.getGames()
                        games.body() ?: emptyList()
        }
    }
    //mendapatkan informasi game berdasarkan ID dari API
        suspend fun getGameById (id: Int): GroupGameModel {
            return withContext(Dispatchers.IO){
                val game = gamesApi.getGameById(id)
                game.body()!! //respons tidak akan null
            }
        }
}
