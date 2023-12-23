package id.fadhelmw.games.domain

import id.fadhelmw.games.domain.item.GroupGameItem
import id.fadhelmw.games.repository.GameRepository
import javax.inject.Inject

// Kelas yang mengimplementasikan untuk mendapatkan informasi game berdasarkan ID
class GetGameById @Inject constructor(private val gameRepository: GameRepository) {
    suspend operator fun invoke(id: Int): GroupGameItem {
        return gameRepository.getGameById(id)

    }

}