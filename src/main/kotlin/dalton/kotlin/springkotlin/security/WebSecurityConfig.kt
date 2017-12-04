package dalton.kotlin.springkotlin.security

import dalton.kotlin.springkotlin.security.auth.RestAuthenticationEntryPoint
import dalton.kotlin.springkotlin.security.auth.TokenAuthenticationFilter
import dalton.kotlin.springkotlin.security.auth.TokenHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.security.web.util.matcher.RequestMatcher
import java.util.*


/**
 * Created by dalton on 02/12/17.
 *
 *  @author dalton
 *  @since v1.0
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig(val jwtUserDetailsService: UserDetailsService,
                        val restAuthenticationEntryPoint: RestAuthenticationEntryPoint,
                        val tokenHelper: TokenHelper): WebSecurityConfigurerAdapter() {

    @Bean
    fun passwordEncoder(): PasswordEncoder{
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    @Bean
    override fun authenticationManager(): AuthenticationManager {
        return super.authenticationManager()
    }

    @Throws(Exception::class)
    @Autowired
    fun configurationGlobal(auth: AuthenticationManagerBuilder){
        auth.userDetailsService(jwtUserDetailsService)
                .passwordEncoder(passwordEncoder())
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        val csrfMethods: ArrayList<RequestMatcher> = ArrayList()
        Arrays.asList("POST", "PUT", "PATCH", "DELETE")
                .forEach { method -> csrfMethods.add(AntPathRequestMatcher("/**", method)) }

        val addFilterBefore = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated().and()
                .addFilterBefore(TokenAuthenticationFilter(tokenHelper, jwtUserDetailsService), BasicAuthenticationFilter::class.java)

        http.csrf().disable()

    }

    @Throws(exceptionClasses = Exception::class)
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(HttpMethod.POST,"/auth/login")
    }



}