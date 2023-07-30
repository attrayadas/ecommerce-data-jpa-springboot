package com.attraya.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String categoryName;
    private String categoryDescription;
    @OneToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY,
    mappedBy = "category") // ProductCategory is the owning entity
    private List<Product> products = new ArrayList<>();
}
