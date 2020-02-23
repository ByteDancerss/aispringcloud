package org.lanqiao.zuul;

/*
* zull:服务网关，使用zull可以不用知道服务提供者的端口号，进行动态代理，并且可以进行负载均衡，
* 但是负载均衡的功能相对来说比较弱
* */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy            //使用zull网关的动态代理
@EnableAutoConfiguration
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
