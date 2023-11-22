package es.joatzel.erosketa.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HexFormat;
import java.util.UUID;


@Data
@AllArgsConstructor
public class Category {
    private final Long id;
    private final UUID UUID;
    private String denomination;
    private String description;
    private String color;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
