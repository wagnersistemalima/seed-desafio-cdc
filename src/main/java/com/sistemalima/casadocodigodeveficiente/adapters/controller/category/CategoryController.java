package com.sistemalima.casadocodigodeveficiente.adapters.controller.category;

import com.sistemalima.casadocodigodeveficiente.adapters.controller.category.entity.CategoryRequest;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.category.entity.CategoryResponse;
import com.sistemalima.casadocodigodeveficiente.adapters.controller.entity.DefaultResponse;
import com.sistemalima.casadocodigodeveficiente.application.ports.input.CategoryService;
import com.sistemalima.casadocodigodeveficiente.domain.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<DefaultResponse<CategoryResponse>> create(
            @Valid @RequestBody CategoryRequest categoryRequest
    ) {

        Category category = categoryService.create(categoryRequest.toDomain());

        return ResponseEntity.ok(new DefaultResponse<>(category.toResponse()));
    }
}
