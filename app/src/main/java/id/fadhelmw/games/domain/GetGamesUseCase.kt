package id.fadhelmw.games.domain

import id.fadhelmw.games.domain.item.GameItem
import id.fadhelmw.games.repository.GameRepository
import javax.inject.Inject

// Kelas use case yang mengimplementasikan operasi untuk mendapatkan daftar game secara acak
class GetGamesUseCase @Inject constructor(private val gameRepository: GameRepository) {

    suspend operator fun invoke(): List<GameItem> {

        return gameRepository.getGames().shuffled()

    }

}