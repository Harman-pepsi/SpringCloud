package cn.demo.controller;

import cn.demo.entry.CommonResult;
import cn.demo.service.IPaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname PaymentFeignController
 * @Description TODO
 * @Date 2020/7/23 13:20
 * @Created by XJC·AW
 */
@RestController
@Slf4j
public class PaymentFeignController {

    @Resource
    private IPaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        return paymentFeignService.getPaymentById(id);
    }
}
