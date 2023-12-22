package id.fadhelmw.games.data.remote;

import id.fadhelmw.games.data.remote.model.GameModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
class GamesService @Inject constructor(private val gamesApi: GamesApi){

        suspend fun getGames(): List<GameModel> {
            return withContext(Dispatchers.IO) {
                val games = gamesApi.getGames()
                        games.body() ?: emptyList()
        }
    }
}
