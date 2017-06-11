package dalton.kotlin.springkotlin.dalton.kotlin.springkotlin.post


import javax.persistence.*

/**
 * Created by dalton on 08/06/17.
 */
@Entity
@Table(name = "post")
data class Post (
        var description: String,
        var title: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long,
        var status: Boolean = true
){

        constructor(): this("","",0)
}