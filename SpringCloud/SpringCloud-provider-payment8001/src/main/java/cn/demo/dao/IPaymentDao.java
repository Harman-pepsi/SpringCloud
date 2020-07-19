package cn.demo.dao;

import cn.demo.entry.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IPaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Integer id);
}
