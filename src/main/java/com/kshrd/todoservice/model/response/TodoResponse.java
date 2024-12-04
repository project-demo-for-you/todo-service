package com.kshrd.todoservice.model.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private String description;
    private CategoryResponse categoryResponse;
}
