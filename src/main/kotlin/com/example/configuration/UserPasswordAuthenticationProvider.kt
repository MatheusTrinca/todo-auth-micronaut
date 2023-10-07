package com.example.configuration

import com.example.repository.UserRepository
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationException
import io.micronaut.security.authentication.AuthenticationFailed
import io.micronaut.security.authentication.AuthenticationFailureReason
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import jakarta.inject.Singleton
import io.reactivex.rxjava3.core.Flowable
import org.reactivestreams.Publisher

@Singleton
class UserPasswordAuthenticationProvider(
    private val userRepository: UserRepository
): AuthenticationProvider<HttpRequest<*>> {
    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {
        val user = userRepository.findById((authenticationRequest?.identity as String).toLong())

        if (user.isPresent) {
            if(user.get().password == authenticationRequest.secret)
                return Flowable.just(AuthenticationResponse.success(user.get().toString()))
            return Flowable.error(AuthenticationException(AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)))
        } else {
            return Flowable.error(AuthenticationException(AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)))
        }
    }

}