package es.joatzel.erosketa.repositories.product;

import es.joatzel.erosketa.data.Factory;
import es.joatzel.erosketa.models.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private final Map<Long, Product> products = Factory.getProductDemoData();


    @Override
    public List<Product> findAll() {
        return List.copyOf(products.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public List<Product> findAllByName(String keywordName) {
        return products.values()
                .stream()
                .filter(product -> product.getName()
                        .toLowerCase()
                        .contains(keywordName.toLowerCase()))
                .toList();
    }

    @Override
    public Optional<Product> findByUuid(UUID uuid) {
        return products.values()
                .stream()
                .filter(product -> product.getUuid()
                        .equals(uuid))
                .findFirst();
    }

    @Override
    public Product save(Product product) {
        if (products.containsValue(product)) {
            return update(product);
        } else {
            return create(product);
        }
    }

    public Product create(Product product) {
        Long lastId = products.keySet().stream().max(Long::compareTo).orElse(0L);
        lastId++;

        LocalDateTime now = LocalDateTime.now();

        Product newproduct = new Product(
                lastId,
                UUID.randomUUID(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory(),
                now,
                now
        );

        products.put(lastId, newproduct);

        return newproduct;
    }


    public Product update(Product product) {
        LocalDateTime now = LocalDateTime.now();

        Product productToUpdate = products.get(product.getId());
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());
        productToUpdate.setUpdatedAt(now);
        //el products.put(product.id, productToUpdate); es innecesario porque productToUpdate
        //es una referencia al objeto guardado en el map, no un objeto nuevo

        return productToUpdate;
    }

    @Override
    public void deleteById(Long id) {
        products.remove(id);
    }
}
