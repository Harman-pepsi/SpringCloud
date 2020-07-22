package cn.demo.controller;

import cn.demo.entry.CommonResult;
import cn.demo.entry.Payment;
import cn.demo.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
