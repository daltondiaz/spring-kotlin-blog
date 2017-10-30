package dalton.kotlin.springkotlin.hashtag

import java.util.*
import javax.persistence.*

/**
 * Created by dalton on 15/06/17.
 *
 *
 * @author dalton
 * @since v1.0
 */

@Entity
@Table(name="hashtag")
data class Hashtag(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long = 0,
        var description:String = "",
        var name:String = "",
        var status: Boolean = true,
        var creationDate : Date = Date(),
        var updateDate : Date


)
