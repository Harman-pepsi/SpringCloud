package cn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname FeignMainOrder80
 * @Description TODO
 * @Date 2020/7/23 13:16
 * @Created by XJC·AW
 */
@SpringBootApplication
@EnableFeignClients
public class FeignMainOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignMainOrder80.class,args);
    }
}
