package cn.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //注释掉，使用自定义负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
