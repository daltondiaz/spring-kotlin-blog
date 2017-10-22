package dalton.kotlin.springkotlin.author

import javax.persistence.*

/**
 * Created by dalton on 11/06/17.
 */

@Entity
@Table(name = "author")
data class Author(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int=0,
        var name: String = "",
        var email: String = "",
        var password: String = "",
        var status: Boolean = false
)
