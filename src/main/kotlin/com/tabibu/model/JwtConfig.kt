package com.tabibu.model

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*

class JwtConfig(jwtSecret: String) {

    companion object Constants {
        // jwt config
        private const val audience = "http://0.0.0.0:8080/hellp"
        private const val jwtIssuer = "http://0.0.0.0:8080/"
        private const val jwtRealm = "Access to 'hello'"

        // claims
        private const val CLAIM_USERID = "userId"
        private const val CLAIM_USERNAME = "userName"
    }

    private val jwtAlgorithm = Algorithm.HMAC512(jwtSecret)
    private val jwtVerifier: JWTVerifier = JWT
        .require(jwtAlgorithm)
        .withIssuer(jwtIssuer)
        .build()

    /**
     * Token for authenticated user
     */
    fun generateToken(user: JwtUser): String = JWT.create()
        .withAudience(audience)
        .withSubject("Authentication")
        .withIssuer(jwtIssuer)
        .withClaim(CLAIM_USERID, user.userId)
        .withClaim(CLAIM_USERNAME, user.userName)
        .sign(jwtAlgorithm)

    /**
     * Configure the jwt ktor authentication feature
     */
    fun configureKtorFeature(config: JWTAuthenticationProvider.Config) = with(config) {
        verifier(jwtVerifier)
        realm = jwtRealm
        validate {
            val userId = it.payload.getClaim(CLAIM_USERID).asInt()
            val userName = it.payload.getClaim(CLAIM_USERNAME).asString()

            if (userId != null && userName != null) {
                JwtUser(userId, userName)
            } else {
                null
            }
        }

    }

    /**
     * POKO, that contains information of an authenticated user that is authenticated via jwt
     */
    data class JwtUser(val userId: Int, val userName: String): Principal


}