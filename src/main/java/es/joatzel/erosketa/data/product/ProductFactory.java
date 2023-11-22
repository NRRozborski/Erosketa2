package es.joatzel.erosketa.data.product;

import es.joatzel.erosketa.models.Category;
import es.joatzel.erosketa.models.Product;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class ProductFactory {

    public static Map<Long, Product> getCategoryDemoData(){
        log.info("Loading product demo data...");

        Map<Long, Product> map = new HashMap<>();
        map.put(1L,
                new Product(1L, UUID.randomUUID(), "Tomatoes", 1L, "Mercadona", false, false, LocalDateTime.now(),  LocalDateTime.now()));
        map.put(2L,
                new Product(1L, UUID.randomUUID(), "Oranges", 1L, "Mercadona", false, false, LocalDateTime.now(),  LocalDateTime.now()));
        map.put(3L,
                new Product(2L, UUID.randomUUID(), "Bacon", 2L, "AhorraMás", false, false, LocalDateTime.now(),  LocalDateTime.now()));
        map.put(4L,
                new Product(3L, UUID.randomUUID(), "Milk", 3L, "Lidl", false, false, LocalDateTime.now(),  LocalDateTime.now()));

        log.info("Product demo data loaded!");

        return map;
    }

}
