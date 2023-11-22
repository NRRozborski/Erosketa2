package es.joatzel.erosketa.controllers;

import es.joatzel.erosketa.dto.CategoryResponseDto;
import es.joatzel.erosketa.services.category.CategoryService;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(
            @RequestParam @Nullable String keywordName
    ){
        if (keywordName == null || keywordName.isEmpty())
            return ResponseEntity.ok();
    }
}
