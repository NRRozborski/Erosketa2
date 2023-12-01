package es.joatzel.erosketa.mappers;

import es.joatzel.erosketa.dto.product.ProductRequestDto;
import es.joatzel.erosketa.dto.product.ProductResponseDto;
import es.joatzel.erosketa.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class ProductMapper {

    @Lazy
    @Autowired
    private CategoryMapper categoryMapper;

    public ProductResponseDto toResponse(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getUuid(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory() == null ? null : categoryMapper.toResponse(product.getCategory()),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }


    public List<ProductResponseDto> toResponse(List<Product> products) {
        return products.stream()
                .map(this::toResponse)
                .toList();
    }

    public Product toModel(ProductRequestDto dto) {
        return new Product(
                0L,
                UUID.randomUUID(),
                dto.name(),
                dto.description(),
                dto.price(),
                dto.stock(),
                dto.category(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

}