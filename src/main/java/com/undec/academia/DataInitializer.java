package com.undec.academia;

import com.undec.academia.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.undec.academia.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    static final Logger LOGGER = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    UserRepository users;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

//        String pass = this.passwordEncoder.encode("admin");
//        System.out.println("pass = " + pass);
//
//        this.users.save(User.builder()
//                .username("user")
//                .password(this.passwordEncoder.encode("password"))
//                .roles(Arrays.asList("ROLE_USER"))
//                .build()
//        );
//
//        this.users.save(User.builder()
//                .username("admin")
//                .password(this.passwordEncoder.encode("password"))
//                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
//                .build()
//        );
//
//        LOGGER.debug("printing all users...");
//        this.users.findAll().forEach(v -> LOGGER.debug(" User :" + v.toString()));
    }
}
