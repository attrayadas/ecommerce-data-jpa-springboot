package com.attraya.ecommerce.repository;

import com.attraya.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void pagination(){
        int pageNo = 0;
        int pageSize = 7;

        // create pageable object
        PageRequest pageable = PageRequest.of(pageNo, pageSize);

        // findAll method and pass pageable instance
        Page<Product> page = productRepository.findAll(pageable);
        List<Product> products = page.getContent();
        products.forEach((p) -> {
            System.out.println(p);
        });

        // total pages
        int totalPages = page.getTotalPages();

        // total elements
        long totalElements = page.getTotalElements();

        // number of elements
        int numberOfElements = page.getNumberOfElements();

        // size
        int size = page.getSize();

        // last
        boolean isLast = page.isLast();

        // first
        boolean isFirst = page.isFirst();

        System.out.println("Total page :: "+totalPages);
        System.out.println("Total elements :: "+totalElements);
        System.out.println("Number of elements :: "+numberOfElements);
        System.out.println("Page size :: "+size);
        System.out.println("Is last page? :: "+isLast);
        System.out.println("Is first page? :: "+isFirst  );
    }

    @Test
    void sorting(){
        String sortBy = "price";
        String sortDir = "desc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

        List<Product> products = productRepository.findAll(sort);
        products.forEach((p) -> {
            System.out.println(p);
        });
    }

    @Test
    void sortingByMultipleFields(){
        String sortBy = "name";
        String sortByDesc = "description";
        String sortDir = "desc";

        Sort sortByName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

        Sort sortByDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortByDesc).ascending(): Sort.by(sortByDesc).descending();

        Sort groupBySort = sortByName.and(sortByDescription);

        List<Product> products = productRepository.findAll(groupBySort);
        products.forEach((p) -> {
            System.out.println(p);
        });
    }

    @Test
    void paginationAndSortingTogether(){
        int pageNo = 0;
        int pageSize = 4;
        String sortBy = "price";
        String sortDir = "desc";

        // Sort object
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

        // Pageable object
        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach((p) -> {
            System.out.println(p);
        });

        // total pages
        int totalPages = page.getTotalPages();

        // total elements
        long totalElements = page.getTotalElements();

        // number of elements
        int numberOfElements = page.getNumberOfElements();

        // size
        int size = page.getSize();

        // last
        boolean isLast = page.isLast();

        // first
        boolean isFirst = page.isFirst();

        System.out.println("Total page :: "+totalPages);
        System.out.println("Total elements :: "+totalElements);
        System.out.println("Number of elements :: "+numberOfElements);
        System.out.println("Page size :: "+size);
        System.out.println("Is last page? :: "+isLast);
        System.out.println("Is first page? :: "+isFirst  );

    }
}
