package es.joatzel.erosketa.services.category;

import es.joatzel.erosketa.models.Category;
import es.joatzel.erosketa.repositories.category.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@CacheConfig(cacheNames = {"Category"})
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        log.info("Find all");

        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        log.info("Find by id");

        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAllByName(String keywordName) {
        log.info("Find all by name or part of it");

        return categoryRepository.findAllByNameContainsIgnoreCase(keywordName);
    }

    @Override
    public Optional<Category> findByUuid(UUID uuid) {
        log.info("Find by UUID");

        return categoryRepository.findByUuid(uuid);
    }

    @Override
    public Category save(Category raqueta) {
        return categoryRepository.save(raqueta);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}