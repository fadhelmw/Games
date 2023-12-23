package id.fadhelmw.games.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.fadhelmw.games.domain.GetGameById
import id.fadhelmw.games.domain.GetGamesUseCase
import id.fadhelmw.games.domain.item.GameItem
import id.fadhelmw.games.domain.item.GroupGameItem
import kotlinx.coroutines.launch
import javax.inject.Inject

// ViewModel yang menggunakan Hilt untuk penyediaan dependensi

@HiltViewModel
class GameViewModel @Inject constructor(

    private val getGamesUseCase: GetGamesUseCase,
    private val getGameByIdUseCase: GetGameById

) : ViewModel() {
    // LiveData untuk menyimpan daftar game
    private val _games = MutableLiveData<List<GameItem>>()
    val games: LiveData<List<GameItem>> get() = _games
    // LiveData untuk menyimpan informasi game
    private val _game = MutableLiveData<GroupGameItem>()
    val game: LiveData<GroupGameItem> get() = _game

    init {
        getGames()
    }
    // Fungsi untuk mendapatkan daftar game dan mengupdate LiveData _games
    private fun getGames() {

        viewModelScope.launch {

            try {

                val games = getGamesUseCase()
                _games.value = games

            } catch (_: Exception) {}

        }

    }

    fun getGameById(id: Int) {

        viewModelScope.launch {

            try {

                val game = getGameByIdUseCase(id)
                _game.value = game

            } catch (_: Exception) {}

        }

    }

}