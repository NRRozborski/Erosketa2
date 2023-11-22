package es.joatzel.erosketa.data.category;

import es.joatzel.erosketa.models.Category;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class CategoryFactory {
    public static Map<Long, Category> getCategoryDemoData(){
        log.info("Loading category demo data...");

        Map<Long, Category> map = new HashMap<>();
        map.put(1L,
                new Category(1L, UUID.randomUUID(), "Plants", "Vegetables, fruits, nuts, etc.", "#000000", LocalDateTime.now(), LocalDateTime.now()));
        map.put(2L,
                new Category(2L, UUID.randomUUID(), "Meats", "Chicken, pork, lamb, etc.", "#000000", LocalDateTime.now(), LocalDateTime.now()));
        map.put(3L,
                new Category(3L, UUID.randomUUID(), "Drinks", "Beer, juice, milk, etc.", "#000000", LocalDateTime.now(), LocalDateTime.now()));

        log.info("Category demo data loaded!");

        return map;
    }
}
