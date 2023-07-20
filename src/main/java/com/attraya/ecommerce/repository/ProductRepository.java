package com.attraya.ecommerce.repository;

import com.attraya.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// we don't need to annotate with @Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
