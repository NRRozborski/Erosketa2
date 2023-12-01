package es.joatzel.erosketa.dto.category;

import es.joatzel.erosketa.models.Product;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


public record CategoryRequestDto(
        @NotNull(message = "The name cannot be left blank")
        String name,
        String description,
        @Nullable
        String color,
        @Nullable
        List<Product> products) {

    public CategoryRequestDto {}
}