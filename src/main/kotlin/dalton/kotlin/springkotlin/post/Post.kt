package dalton.kotlin.springkotlin.post


import dalton.kotlin.springkotlin.author.Author
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
        var status: Boolean = true,
        @ManyToOne
        var author:Author
){
        constructor(): this("","",0,true,Author())
}