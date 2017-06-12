package dalton.kotlin.springkotlin.author

import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by dalton on 11/06/17.
 */

interface AuthorRepository: JpaRepository<Author,Long>