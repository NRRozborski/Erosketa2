package es.joatzel.erosketa.services.product;

import es.joatzel.erosketa.models.Product;
import es.joatzel.erosketa.repositories.product.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@CacheConfig(cacheNames = {"Product"})
public class ProductServiceImpl implements ProductService{

    private final ProductRepository ProductRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository ProductRepository){
        this.ProductRepository = ProductRepository;
    }

    @Override
    public List<Product> findAll() {
        log.info("Find all");

        return ProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        log.info("Find by id");

        return ProductRepository.findById(id);
    }

    @Override
    public List<Product> findAllByName(String keywordName) {
        log.info("Find all by name or part of it");

        return ProductRepository.findAllByName(keywordName);
    }

    @Override
    public Optional<Product> findByUuid(UUID uuid) {
        log.info("Find by UUID");

        return ProductRepository.findByUuid(uuid);
    }

    @Override
    public Product save(Product raqueta) {
        return ProductRepository.save(raqueta);
    }

    @Override
    public void deleteById(Long id) {
        ProductRepository.deleteById(id);
    }
}