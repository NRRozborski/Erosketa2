package es.joatzel.erosketa.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Product {
    private final Long id;
    private final UUID uuid;
    private String name;
    private String description;
    private Long price;//In cents
    private Integer stock;
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
