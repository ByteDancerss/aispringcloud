package org.lanqiao.zuul.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.lanqiao")
public class ClientApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication2.class,args);
    }
}
