package org.lanqiao.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "org.lanqiao")
@EnableEurekaClient
public class RibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class,args);
    }

    //使用RestTemaplate进行服务调用，实现负载均衡
    @Bean
    @LoadBalanced           //使用此注解实现启用Ribbon
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //open fegin = ribbon + restTemplate;
}
