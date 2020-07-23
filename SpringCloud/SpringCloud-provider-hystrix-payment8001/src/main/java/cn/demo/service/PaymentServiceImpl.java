package cn.demo.service;

import cn.demo.entry.CommonResult;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Classname IPaymentService
 * @Description TODO
 * @Date 2020/7/23 14:42
 * @Created by XJC·AW
 */
@Service
public class PaymentServiceImpl {

    public String paymentInfo_OK(Integer id){
        return "线程池:" + Thread.currentThread().getName() + "\tpaymentInfo_OK,id:" + id + "成功！";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentTimeOut(Integer id){
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int i = 10 / 0;
        return "线程池:" + Thread.currentThread().getName() + "\tpaymentTimeOut,id:" + id + "成功！耗时(秒):" + time ;
    }


    public String paymentTimeOutHandler(Integer id){
        return "线程池:" + Thread.currentThread().getName() + "\t系统繁忙或者运行报错，请稍后重试!,id:" + id + ",(灬ꈍ ꈍ灬)";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("******id 不能为负数");
        }
        String serialName = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t调用成功，流水号:" + serialName;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后重试，(灬ꈍ ꈍ灬) id:" + id;
    }
}
