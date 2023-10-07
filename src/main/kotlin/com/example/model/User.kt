package com.example.model

import io.micronaut.core.annotation.Introspected
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
@Introspected
data class User(

    @Id
    val cpf: Long,

    @Column
    val password: String
)
