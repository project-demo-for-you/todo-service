package com.kshrd.todoservice.model.request;

import com.kshrd.todoservice.model.Todo;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {
    private String title;
    private String description;
    private Long categoryId;

    public Todo toEntity(){
        return new Todo(null, this.title, this.description, this.categoryId);
    }

    public Todo toEntity(Long id){
        return new Todo(id, this.title, this.description, this.categoryId);
    }

}
