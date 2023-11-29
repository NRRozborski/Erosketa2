package es.joatzel.erosketa.dto.category;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


public record CategoryRequestDto(
        @NotNull(message = "The name cannot be left blank")
        String name,
        String description,
        @Nullable
        String color) {

    public CategoryRequestDto {}
}