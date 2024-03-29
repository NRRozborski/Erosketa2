package es.joatzel.erosketa.repositories.product;

import es.joatzel.erosketa.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();


    Optional<Product> findById(Long id);


    List<Product> findAllByNameContainsIgnoreCase(String keywordName);


    Optional<Product> findByUuid(UUID uuid);


    Product save(Product product);

    void deleteById(Long id);
}