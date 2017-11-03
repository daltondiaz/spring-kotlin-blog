package dalton.kotlin.springkotlin.hashtag

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by dalton on 15/06/17.
 *
 * @author dalton
 * @since v1.0
 */

interface TagRepostiory : JpaRepository<Tag,Long>