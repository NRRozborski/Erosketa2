package es.joatzel.erosketa.services.category;

import es.joatzel.erosketa.models.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long id);

    List<Category> findAllByName(String keywordName);

    Optional<Category> findByUuid(UUID uuid);

    Category save(Category category);

    void deleteById(Long id);
}