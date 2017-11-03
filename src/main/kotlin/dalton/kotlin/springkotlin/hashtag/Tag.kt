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
@Table(name="tag")
data class Tag(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long = 0,
        var description:String = "",
        var name:String = "",
        var status: Boolean = true,
        var creationDate : Date = Date(),
        var updateDate : Date?
)
