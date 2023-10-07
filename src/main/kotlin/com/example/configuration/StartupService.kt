package com.example.configuration

import com.example.model.User
import com.example.repository.UserRepository
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class StartupService (
    private val userRepository: UserRepository
) {

    private val log = LoggerFactory.getLogger(StartupService::class.java)

    @EventListener
    fun onStartup(event: StartupEvent) {
        val user = userRepository.save(
            User(
                191,
                "123456"
            )
        )
        log.info("Usuário adicionado com sucesso {}", user)
    }
}