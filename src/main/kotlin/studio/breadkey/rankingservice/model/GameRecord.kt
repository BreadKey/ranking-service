package studio.breadkey.rankingservice.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class GameRecord(
    val game: String,
    val score: Int,
    val userId: String,
    @Id
    @GeneratedValue
    var id: Long? = null
)