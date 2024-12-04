package com.kshrd.todoservice.controller;

import com.kshrd.todoservice.model.Todo;
import com.kshrd.todoservice.model.request.TodoRequest;
import com.kshrd.todoservice.model.response.TodoResponse;
import com.kshrd.todoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoRequest todoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(todoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.updateTodo(id, todoRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodo(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodo(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Todo Successfully");
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodos());
    }

}
