package com.example.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable.Serializable
import io.micronaut.serde.annotation.Serdeable.Deserializable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
@Introspected
@Serializable
@Deserializable
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val description: String,

    @Column
    val done: Boolean

)