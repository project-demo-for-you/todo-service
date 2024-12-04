package com.kshrd.todoservice.client;

import com.kshrd.todoservice.model.response.CategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-service", url = "http://localhost:8081/api/v1/categories")
public interface CategoryClient {

    @GetMapping("/{id}")
    CategoryResponse getCategory(@PathVariable("id") Long id);

}
