package id.fadhelmw.games.domain.item

import id.fadhelmw.games.data.remote.model.GroupGameModel

// Data class untuk memanggil item game dengan properti yang sesuai dengan API
data class GroupGameItem(

    val id: Int,
    val title: String,
    val thumbnail: String,
    val publisher: String,
    val description: String

)
// Function untuk mengubah instance GameModel menjadi GameItem
fun GroupGameModel.toGroupGameItem() = GroupGameItem(id, title, thumbnail, publisher, description)