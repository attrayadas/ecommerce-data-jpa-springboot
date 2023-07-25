package com.attraya.ecommerce.repository;

import com.attraya.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(1L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> products = productRepository.findByNameOrDescription("product 1",
                "product 1 description");
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });

    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> products = productRepository.findByNameAndDescription("product 1",
                "product 1 description");
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findDistinctByNameMethod(){
        Product product = productRepository.findDistinctByName("product 1");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameContainingMethod(){
        List<Product> products = productRepository.findByNameContaining("duct");
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameLikeMethod(){
        List<Product> products = productRepository.findByNameLike("product 1");
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(100),
                new BigDecimal( 300));
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        LocalDateTime startDate = LocalDateTime.of(2023, 07, 25, 00, 41, 03);
        LocalDateTime endDate = LocalDateTime.of(2023, 07, 25, 00, 54, 56);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDateCreated());
        });
    }

    @Test
    void findByNameInMethod(){
        List<Product> products = productRepository.findByNameIn(List.of("product 1", "product 2"));
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findTop2ByOrderByPriceDescMethod(){
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();
        products.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
}
