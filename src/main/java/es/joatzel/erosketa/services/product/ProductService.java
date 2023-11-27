package es.joatzel.erosketa.services.product;

import es.joatzel.erosketa.models.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findAllByName(String keywordName);

    Optional<Product> findByUuid(UUID uuid);

    Product save(Product product);

    void deleteById(Long id);
    
}