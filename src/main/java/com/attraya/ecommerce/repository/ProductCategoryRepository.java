package com.attraya.ecommerce.repository;

import com.attraya.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
