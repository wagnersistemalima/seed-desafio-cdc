package com.sistemalima.casadocodigodeveficiente.adapters.controller.category.service;

import com.sistemalima.casadocodigodeveficiente.application.ports.input.CategoryService;
import com.sistemalima.casadocodigodeveficiente.domain.Category;
import com.sistemalima.casadocodigodeveficiente.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public Category create(Category category) {
        return categoryRepository.save(category.toEntity()).toDomain();
    }
}
