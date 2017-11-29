package dalton.kotlin.springkotlin.security.auth

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by dalton on 07/11/17.
 *
 * @author dalton
 * @since v1.0
 */

class TokenAuthenticationFilter(val tokenHelper: TokenHelper,
                                val userDetailsService: UserDetailsService) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  filterChain: FilterChain) {

        val authToken = tokenHelper.getToken(request)
        if(authToken != null){
            val username = tokenHelper.getUsernameFromToken(authToken)
            if(username != null){
                val userDetails = userDetailsService.loadUserByUsername(username)
                if(tokenHelper.validateToken(authToken, userDetails)){
                    // create authentication
                    val authentication = TokenBasedAuthentication(userDetails)
                    authentication.token = authToken
                    SecurityContextHolder.getContext().authentication = authentication

                }
            }
        }
        filterChain.doFilter(request, response)

    }
}