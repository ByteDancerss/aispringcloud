package org.lanqiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "org.lanqiao")
@EnableEurekaClient
public class FileUpDownApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileUpDownApplication.class,args);
    }
}
