package com.gorajski.broccoliblogjavaspring;

import com.gorajski.broccoliblogjavaspring.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BroccoliBlogJavaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BroccoliBlogJavaSpringApplication.class, args);
    }

}
