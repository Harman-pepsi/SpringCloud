package cn.demo.service;

import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallbackService
 * @Description TODO
 * @Date 2020/7/23 18:24
 * @Created by XJC·AW
 */
@Component
public class PaymentFallbackService implements PaymenthystrixService
{
    @Override
    public String paymentInfo_OK(Integer id) {
        return ">>>>>PaymentFallbackService fallback paymentInfo_OK,(灬ꈍ ꈍ灬)";
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return ">>>>>PaymentFallbackService fallback paymentTimeOut,(灬ꈍ ꈍ灬)";
    }
}
