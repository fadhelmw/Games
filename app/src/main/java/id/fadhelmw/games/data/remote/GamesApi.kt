package id.fadhelmw.games.data.remote

import id.fadhelmw.games.data.remote.model.GameModel
import id.fadhelmw.games.util.Constants.Companion.GAMES_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET


interface GamesApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>
}