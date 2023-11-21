package es.joatzel.erosketa.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Product {
    private @Id @GeneratedValue Long id;
    private UUID uuid;
    private String name;
//    private Category category;
    private String company;
    private Boolean wanted;
    private Boolean finished;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
