package es.joatzel.erosketa.data;

import es.joatzel.erosketa.models.Category;
import es.joatzel.erosketa.models.Product;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class Factory {
    private static final Map<Long, Category> mapCat = new HashMap<>();
    private static final Map<Long, Product> mapPro = new HashMap<>();


//    public static Map<Long, Category> getCategoryDemoData(){
//        log.info("Loading category demo data...");
//
//        mapCat.put(1L,
//                new Category(1L, UUID.randomUUID(), "Plants", "Vegetables, fruits, nuts, etc.", "#000000", LocalDateTime.now(), LocalDateTime.now()));
//        mapCat.put(2L,
//                new Category(2L, UUID.randomUUID(), "Meats", "Chicken, pork, lamb, etc.", "#000000", LocalDateTime.now(), LocalDateTime.now()));
//        mapCat.put(3L,
//                new Category(3L, UUID.randomUUID(), "Drinks", "Beer, juice, milk, etc.", "#000000", LocalDateTime.now(), LocalDateTime.now()));
//
//        log.info("Category demo data loaded!");
//
//        return mapCat;
//    }
//
//    public static Map<Long, Product> getProductDemoData(){
//        log.info("Loading product demo data...");
//
//        mapPro.put(1L, new Product(1L, UUID.randomUUID(), "Tomatoes", "Red vegetable", 400L, 2,
//                mapCat.get(1L), LocalDateTime.now(),  LocalDateTime.now()));
//        mapPro.put(2L, new Product(1L, UUID.randomUUID(), "Oranges", "orange fruit", 800L, 1,
//                mapCat.get(1L), LocalDateTime.now(),  LocalDateTime.now()));
//        mapPro.put(3L, new Product(2L, UUID.randomUUID(), "Bacon", "Best price", 900L, 1,
//                mapCat.get(2L), LocalDateTime.now(),  LocalDateTime.now()));
//        mapPro.put(4L, new Product(3L, UUID.randomUUID(), "Milk", "Whole", 120L, 4,
//                mapCat.get(3L), LocalDateTime.now(),  LocalDateTime.now()));
//
//        log.info("Product demo data loaded!");
//
//        return mapPro;
//    }
}
