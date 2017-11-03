package dalton.kotlin.springkotlin.author

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by dalton on 11/06/17.
 *
 * @author dalton
 * @since v1.0
 */

interface AuthorRepository: JpaRepository<Author,Long>