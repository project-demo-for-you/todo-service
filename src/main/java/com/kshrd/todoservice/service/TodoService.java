package com.kshrd.todoservice.service;

import com.kshrd.todoservice.model.Todo;
import com.kshrd.todoservice.model.request.TodoRequest;
import com.kshrd.todoservice.model.response.TodoResponse;

import java.util.List;

public interface TodoService {
    TodoResponse createTodo(TodoRequest todoRequest);

    TodoResponse updateTodo(Long id, TodoRequest todoRequest);

    TodoResponse getTodo(Long id);

    void deleteTodo(Long id);

    List<TodoResponse> getAllTodos();
}
