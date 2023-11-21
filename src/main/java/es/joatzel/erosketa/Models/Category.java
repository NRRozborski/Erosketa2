package es.joatzel.erosketa.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
public class Category {
    private @Id @GeneratedValue Long id;
    private String denomination;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
