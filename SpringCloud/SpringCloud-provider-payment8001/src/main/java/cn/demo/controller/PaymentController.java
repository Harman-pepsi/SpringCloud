package cn.demo.controller;

import cn.demo.entry.CommonResult;
import cn.demo.entry.Payment;
import cn.demo.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname PaymentController
 * @Description
 * @Created by XJC·AW
 * @Date 2020/7/17 2:09
 * @Version V1.0.0
 * @Since 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int iResult = paymentService.create(payment);
        log.info("插入结果--->" + iResult);
        return iResult > 0 ? new CommonResult<>(200,"插入成功!,ServerPort:" + serverPort,iResult) : new CommonResult<>(500,"插入失败!",null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果--->" + payment);
        return payment != null ? new CommonResult(200,"查询成功!,ServerPort:" + serverPort,payment) : new CommonResult(500,"无对应id记录，查询失败!",null);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("DiscoveryClient services -->" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance -->id:" + instance.getServiceId() + "\tport:" + instance.getPort() + "\turi:" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
