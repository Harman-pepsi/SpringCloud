package cn.demo.service;

import cn.demo.entry.Payment;
import org.apache.ibatis.annotations.Param;

public interface IPaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Integer id);
}
