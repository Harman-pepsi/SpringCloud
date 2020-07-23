package cn.demo.controller;

import cn.demo.service.PaymenthystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname OrderHystrixController
 * @Description TODO
 * @Date 2020/7/23 16:36
 * @Created by XJC·AW
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    public PaymenthystrixService paymenthystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymenthystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //@HystrixCommand(fallbackMethod = "paymentTimeOutHandler",commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    //})
    @HystrixCommand
    public String paymentTimeOut(@PathVariable("id") Integer id){
        //int i = 10 / 0;
        return paymenthystrixService.paymentTimeOut(id);
    }

    public String paymentTimeOutHandler(Integer id){
        return "我是消费者80:" + Thread.currentThread().getName() + "\t系统繁忙或者运行报错，请稍后重试!,id:" + id + ",(灬ꈍ ꈍ灬)";
    }

    //下面是全局fallback
    public String payment_Global_FallbackMethod(){
        return "全局异常处理信息，请稍后重试，谢谢!";
    }
}
