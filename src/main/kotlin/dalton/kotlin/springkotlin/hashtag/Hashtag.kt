package dalton.kotlin.springkotlin.hashtag

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by dalton on 15/06/17.
 */

@Entity
@Table(name="hashtag")
data class Hashtag(
        @Id
        var id:Long = 0,
        var description:String = "",
        var name:String = "",
        var status: Boolean = true
)
