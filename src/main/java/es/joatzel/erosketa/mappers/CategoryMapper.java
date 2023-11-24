package es.joatzel.erosketa.mappers;

import es.joatzel.erosketa.dto.category.CategoryResponseDto;
import es.joatzel.erosketa.dto.category.CategoryRequestDto;
import es.joatzel.erosketa.models.Category;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class CategoryMapper {

    public CategoryResponseDto toResponse(Category category) {
        return new CategoryResponseDto (
                category.getId(),
                category.getUuid(),
                category.getName(),
                category.getDescription(),
                category.getColor(),
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
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}