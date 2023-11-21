package es.joatzel.erosketa.Repositories;

import es.joatzel.erosketa.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
