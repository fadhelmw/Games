package id.fadhelmw.games.data.remote

import id.fadhelmw.games.data.remote.model.GameModel
import id.fadhelmw.games.data.remote.model.GroupGameModel
import id.fadhelmw.games.util.Constants.Companion.GAMES_ENDPOINT
import id.fadhelmw.games.util.Constants.Companion.GAMES_ID_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface GamesApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>
    @GET(GAMES_ID_ENDPOINT)
    suspend fun getGameById(@Query(value = "id") id: Int): Response<GroupGameModel>
}