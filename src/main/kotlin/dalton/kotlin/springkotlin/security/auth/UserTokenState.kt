package dalton.kotlin.springkotlin.security.auth

/**
 * Created by dalton on 29/11/17.
 *
 * @author dalton
 * @since v1.0
 */

data class UserTokenState(
        var accessToken : String = "",
        var expiresIn: Long = 0
)