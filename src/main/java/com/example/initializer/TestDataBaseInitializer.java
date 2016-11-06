package com.example.initializer;

import com.example.entity.Address;
import com.example.entity.Users;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TestDataBaseInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (!userRepository.findAll().isEmpty()) {
            return;
        }
        initializeUsers();
    }

    private void initializeUsers() {
        Users users = new Users();
        Address address = new Address().setCity("Lublin").setHomeNumber("22").setPostalCode("23-500").setStreet("Jaspisowa");
        users.setEmail("test@example.com").setLastName("Zberaz").setName("Szymon").setPhone("532544462").setAddress(address).setPesel("323232323232");
        userRepository.save(users);
    }
}
