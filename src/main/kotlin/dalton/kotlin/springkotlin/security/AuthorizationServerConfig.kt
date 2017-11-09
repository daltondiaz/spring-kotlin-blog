package dalton.kotlin.springkotlin.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.provider.token.TokenEnhancer
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import java.util.*


/**
 * Our authorization server configuration class extends AuthorizationServerConfigurerAdapter
 * which in turn is an implementation of
 * AuthorizationServerConfigurer. The presence of a bean of
 * type AuthorizationServerConfigurer simply tells Spring Boot to switch
 * off auto-configuration and use the custom configuration.
 * Also the AuthorizationServerConfig like any other configuration
 * class has its definition automatically scanned,wired and applied by
 * Spring Boot because of the @Configuration annotation.
 *
 * Created by dalton on 07/11/17.
 *
 * @author dalton
 * @since v1.0
 *
 */

@Configuration
@EnableAuthorizationServer
@EnableResourceServer
class AuthorizationServerConfig : AuthorizationServerConfigurerAdapter() {

    @Value("\${security.jwt.client-id}")
    private val clientId: String? = null

    @Value("\${security.jwt.client-secret}")
    private val clientSecret: String? = null

    @Value("\${security.jwt.grant-type}")
    private val grantType: String? = null

    @Value("\${security.jwt.scope-read}")
    private val scopeRead: String? = null

    @Value("\${security.jwt.scope-write}")
    private val scopeWrite: String = "write"

    @Value("\${security.jwt.resource-ids}")
    private val resourceIds: String? =null

    @Autowired
    private val tokenStore: TokenStore? =null

    @Autowired
    private val accessTokenConverter : JwtAccessTokenConverter? = null

    @Autowired
    private val authenticationManeger: AuthenticationManager? =null

    @Throws(Exception::class)
    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients
                .inMemory()
                .withClient(clientId)
                .secret(clientSecret)
                .authorizedGrantTypes(grantType)
                .scopes(scopeRead,scopeWrite)
                .resourceIds(resourceIds)
    }

    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer?) {

        // define a token enhancer that enables chaining multiple types of claims containing different information
        val enhancerChain = TokenEnhancerChain()
        val array = Arrays.asList(accessTokenConverter)
        enhancerChain.setTokenEnhancers(array as List<TokenEnhancer>?)

        endpoints!!.tokenStore(tokenStore)
                .accessTokenConverter(accessTokenConverter)
                .tokenEnhancer(enhancerChain)
                .authenticationManager(authenticationManeger)
    }


}