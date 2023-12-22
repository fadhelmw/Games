package id.fadhelmw.games.domain.item

import id.fadhelmw.games.data.remote.model.GameModel

data class GameItem (

    val id: Int,
    val title: String,
    val thumbnail: String,
    val publisher: String,
    val short_description: String

)

fun GameModel.toGameItem() = GameItem(id, title, thumbnail, publisher, short_description)