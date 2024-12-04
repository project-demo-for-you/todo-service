package com.kshrd.todoservice.model;

import com.kshrd.todoservice.model.response.CategoryResponse;
import com.kshrd.todoservice.model.response.TodoResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "todos")
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long categoryId;

    public TodoResponse toResponse(CategoryResponse categoryResponse){
        return new TodoResponse(this.id, this.title, this.description, categoryResponse);
    }
}
