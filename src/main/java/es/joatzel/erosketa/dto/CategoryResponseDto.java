package es.joatzel.erosketa.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;



public record CategoryResponseDto(Long id,
                                  java.util.UUID UUID,
                                  String name,
                                  String description,
                                  String color,
                                  LocalDateTime createdAt,
                                  LocalDateTime updatedAt) {
    public CategoryResponseDto {}
}