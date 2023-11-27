package es.joatzel.erosketa.controllers;

import es.joatzel.erosketa.dto.product.ProductRequestDto;
import es.joatzel.erosketa.dto.product.ProductResponseDto;
import es.joatzel.erosketa.mappers.ProductMapper;
import es.joatzel.erosketa.services.product.ProductService;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    private final ProductService ProductService;
    private final ProductMapper ProductMapper;

    @Autowired
    public ProductController(ProductService ProductService,  ProductMapper ProductMapper){
        this.ProductService = ProductService;
        this.ProductMapper = ProductMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductResponseDto>> getAllCategories(
            @RequestParam @Nullable String keywordName
    ){
        log.info("getAllCategories");

        if (keywordName == null || keywordName.isEmpty())
            return ResponseEntity.ok(
                    ProductMapper.toResponse(ProductService.findAll())
            );

        return ResponseEntity.ok(
                ProductMapper.toResponse(ProductService.findAllByName(keywordName))
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(
            @PathVariable Long id
    ) {
        log.info("getProductById");

        var Product = ProductService.findById(id);

        return Product.map(value -> ResponseEntity.ok(
                ProductMapper.toResponse(value)
        )).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/find/{uuid}")
    public ResponseEntity<ProductResponseDto> getProductByUuid(
            @PathVariable UUID uuid
    ) {
        log.info("getProductByUuid");

        var Product = ProductService.findByUuid(uuid);

        return Product.map(value -> ResponseEntity.ok(
                ProductMapper.toResponse(value)
        )).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> postProduct(
            @RequestBody ProductRequestDto product
    ) {
        log.info("addProduct");

        var ProductSaved = ProductService.save(ProductMapper.toModel(product));

        return ResponseEntity.created(null).body(
                ProductMapper.toResponse(ProductSaved)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> putProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDto productRequestDto
    ) {
        log.info("putProduct");

        var ProductDB = ProductService.findById(id);

        if (ProductDB.isEmpty()) {
            log.warn("Product not found, id:" + id);
            return ResponseEntity.notFound().build();
        }

        ProductDB.get().setName(productRequestDto.name());
        ProductDB.get().setDescription(productRequestDto.description());
        ProductDB.get().setPrice(productRequestDto.price());
        ProductDB.get().setStock(productRequestDto.stock());
        ProductDB.get().setCategory(productRequestDto.category());

        ProductService.save(ProductDB.get());

        return ResponseEntity.ok(
                ProductMapper.toResponse(ProductDB.get())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(
            @PathVariable Long id
    ) {
        log.info("deleteProduct");

        var ProductDB = ProductService.findById(id);

        if (ProductDB.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ProductService.deleteById(ProductDB.get().getId());

        return ResponseEntity.noContent().build();
    }
}