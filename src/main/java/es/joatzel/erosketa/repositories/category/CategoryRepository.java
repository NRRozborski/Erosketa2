package es.joatzel.erosketa.repositories.category;

import es.joatzel.erosketa.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {//} extends JpaRepository<Category, Long> {

    List<Category> findAll();


    Optional<Category> findById(Long id);


    List<Category> findAllByName(String keywordName);


    Optional<Category> findByUuid(UUID uuid);


    Category save(Category raqueta);

    void deleteById(Long id);


}