package es.joatzel.erosketa.dto.product;

import es.joatzel.erosketa.models.Category;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductResponseDto(   Long id,
                                    UUID uuid,
                                    String name,
                                    String description,
                                    Long price,
                                    Integer stock,
                                    Category category,
                                    LocalDateTime createdAt,
                                    LocalDateTime updatedAt) {
    public ProductResponseDto{}
}
