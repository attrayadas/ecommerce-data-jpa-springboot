package com.attraya.ecommerce.repository;

import com.attraya.ecommerce.entity.Role;
import com.attraya.ecommerce.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyUnidirectionalTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser(){
        User user = new User();
        user.setFirstName("Ramesh");
        user.setLastName("Fadatare");
        user.setEmail("ramesh@gmail.com");
        user.setPassword("secret");

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        Role customer = new Role();
        customer.setName("ROLE_CUSTOMER");

        user.getRoles().add(admin);
        user.getRoles().add(customer);

        userRepository.save(user);
    }

    @Test
    public void updateUser(){
        User user = userRepository.findById(1L).get();
        user.setFirstName("Ram");
        user.setEmail("ram@gmail.com");

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");

        user.getRoles().add(roleUser);

        userRepository.save(user);
    }

    @Test
    public void fetchUser(){
        User user = userRepository.findById(1L).get();
        System.out.println(user.getEmail());
        user.getRoles().forEach((r) -> {
            System.out.println(r.getName());
        });
    }

    @Test
    public void deleteUser(){
        userRepository.deleteById(1L);
    }
}
