package cn.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname OrderZKController
 * @Description TODO
 * @Date 2020/7/21 18:09
 * @Created by XJC·AW
 */
@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL = "http://springcloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/testZk",String.class);
        return result;
    }
}
