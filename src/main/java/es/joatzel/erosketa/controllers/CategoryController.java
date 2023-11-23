package es.joatzel.erosketa.controllers;

import es.joatzel.erosketa.dto.CategoryResponseDto;
import es.joatzel.erosketa.dto.CategoryRequestDto;
import es.joatzel.erosketa.mappers.CategoryMapper;
import es.joatzel.erosketa.services.category.CategoryService;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryController(CategoryService categoryService,  CategoryMapper categoryMapper){
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(
            @RequestParam @Nullable String keywordName
    ){
        log.info("getAllCategories");

        if (keywordName == null || keywordName.isEmpty())
            return ResponseEntity.ok(
                    categoryMapper.toResponse(categoryService.findAll())
            );

        return ResponseEntity.ok(
                categoryMapper.toResponse(categoryService.findAllByName(keywordName))
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(
            @PathVariable Long id
    ) {
        log.info("getCategoryById");

        var category = categoryService.findById(id);

        return category.map(value -> ResponseEntity.ok(
                categoryMapper.toResponse(value)
        )).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/find/{uuid}")
    public ResponseEntity<CategoryResponseDto> getCategoryByUuid(
            @PathVariable UUID uuid
    ) {
        log.info("getCategoryByUuid");

        var category = categoryService.findByUuid(uuid);

        return category.map(value -> ResponseEntity.ok(
                categoryMapper.toResponse(value)
        )).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> postCategory(
            @RequestBody CategoryRequestDto category
    ) {
        log.info("addCategory");

        var categorySaved = categoryService.save(categoryMapper.toModel(category));

        return ResponseEntity.created(null).body(
                categoryMapper.toResponse(categorySaved)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> putCategory(
            @PathVariable Long id,
            @RequestBody CategoryRequestDto categoryRequestDto
    ) {
        log.info("putCategory");

        var categoryDB = categoryService.findById(id);

        if (categoryDB.isEmpty()) {
            log.warn("Category not found, id:" + id);
            return ResponseEntity.notFound().build();
        }

        categoryDB.get().setName(categoryRequestDto.name());
        categoryDB.get().setDescription(categoryRequestDto.description());
        categoryDB.get().setColor(categoryRequestDto.color());

        categoryService.save(categoryDB.get());

        return ResponseEntity.ok(
                categoryMapper.toResponse(categoryDB.get())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> deleteCategory(
            @PathVariable Long id
    ) {
        log.info("deleteCategory");

        var categoryDB = categoryService.findById(id);

        if (categoryDB.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteById(categoryDB.get().getId());

        return ResponseEntity.noContent().build();
    }
}