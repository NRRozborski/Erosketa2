package es.joatzel.erosketa.mappers;

import es.joatzel.erosketa.dto.category.CategoryResponseDto;
import es.joatzel.erosketa.dto.category.CategoryRequestDto;
import es.joatzel.erosketa.models.Category;
import es.joatzel.erosketa.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Component
public class CategoryMapper {

    private final ProductMapper productMapper;

    public CategoryMapper(ProductMapper productMapper){
        this.productMapper = productMapper;
    }

    public CategoryResponseDto toResponse(Category category) {
        return new CategoryResponseDto (
                category.getId(),
                category.getUuid(),
                category.getName(),
                category.getDescription(),
                category.getColor(),
                category.getProducts() == null ? new LinkedList<>() : productMapper.toResponse(category.getProducts()),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }


    public List<CategoryResponseDto> toResponse(List<Category> raquetas) {
        return raquetas.stream()
                .map(this::toResponse)
                .toList();
    }

    public Category toModel(CategoryRequestDto dto) {
        return new Category(
                0L,
                UUID.randomUUID(),
                dto.name(),
                dto.description(),
                dto.color(),
                dto.products()==null ? new LinkedList<Product>() : dto.products(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}