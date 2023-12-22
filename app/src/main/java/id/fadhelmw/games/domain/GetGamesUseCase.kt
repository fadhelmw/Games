package id.fadhelmw.games.domain

import javax.inject.Inject
import id.fadhelmw.games.domain.item.GameItem
import id.fadhelmw.games.repository.GameRepository

class GetGamesUseCase @Inject constructor(private val gameRepository: GameRepository) {

    suspend operator fun invoke(): List<GameItem> {

        return gameRepository.getGames().shuffled()

    }

}