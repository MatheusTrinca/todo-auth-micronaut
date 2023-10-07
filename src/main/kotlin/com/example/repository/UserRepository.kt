package com.example.repository

import com.example.model.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
abstract class UserRepository: JpaRepository<User, Long> {
}