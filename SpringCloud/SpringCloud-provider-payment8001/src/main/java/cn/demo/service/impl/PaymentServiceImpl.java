package cn.demo.service.impl;

import cn.demo.dao.IPaymentDao;
import cn.demo.entry.Payment;
import cn.demo.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname PaymentServiceImpl
 * @Description
 * @Created by XJC·AW
 * @Date 2020/7/17 2:04
 * @Version V1.0.0
 * @Since 1.0
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private IPaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }
}
