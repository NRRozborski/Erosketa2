package es.joatzel.erosketa.repositories.category;

import es.joatzel.erosketa.data.Factory;
import es.joatzel.erosketa.models.Category;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final Map<Long, Category> categories = Factory.getCategoryDemoData();

    @Override
    public List<Category> findAll() {
        return List.copyOf(categories.values());
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(categories.get(id));
    }

    @Override
    public List<Category> findAllByName(String keywordName) {
        return categories.values()
                .stream()
                .filter(category -> category.getName()
                        .toLowerCase()
                        .contains(keywordName.toLowerCase()))
                .toList();
    }

    @Override
    public Optional<Category> findByUuid(UUID uuid) {
        return categories.values()
                .stream()
                .filter(category -> category.getUuid()
                        .equals(uuid))
                .findFirst();
    }

    @Override
    public Category save(Category category) {
        if (categories.containsValue(category)) {
            return update(category);
        } else {
            return create(category);
        }
    }

    public Category create(Category category) {
        Long lastId = categories.keySet().stream().max(Long::compareTo).orElse(0L);
        lastId++;

        LocalDateTime now = LocalDateTime.now();

        Category newCategory = new Category(
                lastId,
                UUID.randomUUID(),
                category.getName(),
                category.getDescription(),
                category.getColor(),
                now,
                now
        );

        categories.put(lastId, newCategory);

        return newCategory;
    }


    public Category update(Category category) {
        LocalDateTime now = LocalDateTime.now();

        Category categoryToUpdate = categories.get(category.getId());
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setDescription(category.getDescription());
        categoryToUpdate.setColor(category.getColor());
        categoryToUpdate.setUpdatedAt(now);
        //el categories.put(category.id, categoryToUpdate); es innecesario porque categoryToUpdate
        //es una referencia al objeto guardado en el map, no un objeto nuevo

        return categoryToUpdate;
    }

    @Override
    public void deleteById(Long id) {
        categories.remove(id);
    }
}
