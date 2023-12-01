package es.joatzel.erosketa.dto.category;

import es.joatzel.erosketa.dto.product.ProductResponseDto;
import es.joatzel.erosketa.models.Product;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;


public record CategoryResponseDto(
        Long id,
        java.util.UUID UUID,
        String name,
        String description,
        String color,
        List<ProductResponseDto> products,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public CategoryResponseDto {}
}