package com.attraya.ecommerce.repository;

import com.attraya.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/* Important Spring Data JPA Repository Methods */
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("Product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // save product
        Product savedObject = productRepository.save(product);

        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod(){

        // find or retrieve an entity by id
        Long id=1L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 desc");

        //save updated entity
        productRepository.save(product);

    }

    @Test
    void findByIdMethod(){
        Long id=1L;
        Product product = productRepository.findById(id).get();
        System.out.println(product);
    }

    @Test
    void saveAllMethod(){
        // create product
        Product product = new Product();
        product.setName("product 2");
        product.setDescription("Product 2 description");
        product.setSku("100ABCDEF");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product2.png");

        // create product
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("Product 3 description");
        product3.setSku("100ABCDEFG");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        List<Product> products = productRepository.saveAll(List.of(product, product3));
        System.out.println(products);

    }

    @Test
    void findAllMethod(){
        productRepository.findAll().forEach((p)-> System.out.println(p.getName()));
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1L;
        productRepository.deleteById(id);
    }
    @Test
    void deleteMethod(){
        // find an entity by id
        Long id=2L;
        Product product = productRepository.findById(id).get();

        // delete (entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
        // productRepository.deleteAll();

        Product product = productRepository.findById(5L).get();
        Product product1 = productRepository.findById(6L).get();
        productRepository.deleteAll(List.of(product, product1));
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){
        Long id=9L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }

}