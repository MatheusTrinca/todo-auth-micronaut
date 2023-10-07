package com.example.controller

import com.example.model.Todo
import com.example.repository.TodoRepository
import io.micronaut.core.annotation.Introspected
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/todos")
class TodoController(
    private val todoRepository: TodoRepository
) {
    @Get
    fun getTodos(): List<Todo> {
        return todoRepository.findAll()
    }

    @Post
    fun create(@Body todo: Todo): HttpResponse<Todo> {
        return HttpResponse.created(todoRepository.save(todo))
    }
}