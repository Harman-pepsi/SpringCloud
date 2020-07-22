package cn.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/7/21 17:17
 * @Created by XJC·AW
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/testZk")
    public String testZk(){
        return "Spring Cloud with zookeeper:ServerPort:"+ serverPort + "UUID:" + UUID.randomUUID().toString().replace("-","");
    }
}
