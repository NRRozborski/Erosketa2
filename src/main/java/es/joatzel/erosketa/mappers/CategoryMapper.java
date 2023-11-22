package es.joatzel.erosketa.mappers;

import es.joatzel.erosketa.dto.CategoryResponseDto;
import es.joatzel.erosketa.models.Category;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class CategoryMapper {

    public CategoryResponseDto toResponse(Category category) {
        return new CategoryResponseDto (
                category.getId(),
                category.getUUID(),
                category.getDenomination(),
                category.getDescription(),
                category.getColor(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }


    public List<RaquetaResponseDto> toResponse(List<Raqueta> raquetas) {
        return raquetas.stream()
                .map(this::toResponse)
                .toList();
    }

    public Raqueta toModel(RaquetaRequestDto dto) {
        return new Raqueta(
                0L,
                UUID.randomUUID(),
                dto.getMarca(),
                dto.getModelo(),
                dto.getPrecio(),
                dto.getImagen(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                false
        );
    }
}
