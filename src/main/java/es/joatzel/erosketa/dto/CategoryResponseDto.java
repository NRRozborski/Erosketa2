package es.joatzel.erosketa.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public record CategoryResponseDto(Long id, java.util.UUID UUID, String denomination, String description, String color,
                                  LocalDateTime createdAt, LocalDateTime updatedAt) {

}