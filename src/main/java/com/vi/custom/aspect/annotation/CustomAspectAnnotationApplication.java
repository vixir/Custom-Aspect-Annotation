package com.vi.custom.aspect.annotation;

import com.vi.custom.aspect.annotation.dao.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
@Slf4j
public class CustomAspectAnnotationApplication implements CommandLineRunner {

    @Autowired
    private CustomerDaoImpl customerDaoImpl;

    public static void main(String[] args) {
        SpringApplication.run(CustomAspectAnnotationApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Customer Name of id 2 is {}", customerDaoImpl.fetchCustomerName(2));
    }

}
