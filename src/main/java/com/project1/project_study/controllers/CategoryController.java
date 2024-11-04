package com.project1.project_study.controllers;

import com.project1.project_study.DTOs.CategoryDTO;
import com.project1.project_study.core.utils.ApiObjectMapper;
import com.project1.project_study.models.Category;
import com.project1.project_study.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Category>  listarTodos() {
        return categoryService.findAll();
    }



}
