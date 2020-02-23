package org.lanqiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.lanqiao")
public class LocalConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(LocalConfigClientApplication.class,args);
    }
}
