package com.cidenet.devis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
public class CidenetApplication {

    public static void main(String[] args) {
        SpringApplication.run(CidenetApplication.class, args);
    }

}
