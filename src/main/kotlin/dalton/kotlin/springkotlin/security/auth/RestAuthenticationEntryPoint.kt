package dalton.kotlin.springkotlin.security.auth

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by dalton on 07/11/17.
 *
 * @author dalton
 * @since v1.0
 */

class RestAuthenticationEntryPoint : AuthenticationEntryPoint {

    override fun commence(request: HttpServletRequest?,
                          response: HttpServletResponse?,
                          authException: AuthenticationException?) {
        response?.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException!!.message)
    }
}