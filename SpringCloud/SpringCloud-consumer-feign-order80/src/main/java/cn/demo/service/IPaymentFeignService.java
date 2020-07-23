package cn.demo.service;

import cn.demo.entry.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname PaymentFeignService
 * @Description TODO
 * @Date 2020/7/23 13:17
 * @Created by XJC·AW
 */
@FeignClient(value = "SPRINGCLOUD-PAYMENT-SERVICE")
public interface IPaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id);
}
