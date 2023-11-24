package es.joatzel.erosketa.dto.product;

import es.joatzel.erosketa.models.Category;


public record ProductRequestDto(String name,
                                String description,
                                Long price,
                                Integer stock,
                                Category category) {
    public ProductRequestDto{}
}