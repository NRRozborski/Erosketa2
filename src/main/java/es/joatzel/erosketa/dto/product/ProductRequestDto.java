package es.joatzel.erosketa.dto.product;

import es.joatzel.erosketa.models.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record ProductRequestDto(
        @NotNull(message = "The name cannot be left blank")
        String name,
        String description,
        @Min(value = 0, message = "The price cannot be negative.")
        Long price,
        @Min(value = 0, message = "The stock cannot be negative.")
        Integer stock,
        Category category) {
    public ProductRequestDto{}
}