package id.fadhelmw.games.domain.item

import id.fadhelmw.games.data.remote.model.GameModel

// Data class untuk memanggil item game dengan properti yang sesuai dengan API
data class GameItem (

    val id: Int,
    val title: String,
    val thumbnail: String,
    val publisher: String,
    val short_description: String

)
// Function untuk mengubah instance GameModel menjadi GameItem
fun GameModel.toGameItem() = GameItem(id, title, thumbnail, publisher, short_description)