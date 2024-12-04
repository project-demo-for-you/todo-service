package com.kshrd.todoservice.service.impl;

import com.kshrd.todoservice.client.CategoryClient;
import com.kshrd.todoservice.model.Todo;
import com.kshrd.todoservice.model.request.TodoRequest;
import com.kshrd.todoservice.model.response.CategoryResponse;
import com.kshrd.todoservice.model.response.TodoResponse;
import com.kshrd.todoservice.repository.TodoRepository;
import com.kshrd.todoservice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final CategoryClient categoryClient;

    @Override
    public TodoResponse createTodo(TodoRequest todoRequest) {
        CategoryResponse categoryResponse = categoryClient.getCategory(todoRequest.getCategoryId());
        return todoRepository.save(todoRequest.toEntity()).toResponse(categoryResponse);
    }

    @Override
    public TodoResponse updateTodo(Long id, TodoRequest todoRequest) {
        CategoryResponse categoryResponse = categoryClient.getCategory(todoRequest.getCategoryId());
        return todoRepository.save(todoRequest.toEntity(id)).toResponse(categoryResponse);
    }

    @Override
    public TodoResponse getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        assert todo != null;
        CategoryResponse categoryResponse = categoryClient.getCategory(todo.getCategoryId());
        return todo.toResponse(categoryResponse);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll().stream().map(todo -> {
                    CategoryResponse categoryResponse = categoryClient.getCategory(todo.getCategoryId());
                    return todo.toResponse(categoryResponse);
                }
        ).toList();
    }
}

