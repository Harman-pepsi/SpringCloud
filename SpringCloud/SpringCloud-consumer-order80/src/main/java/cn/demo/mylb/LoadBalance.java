package cn.demo.mylb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Classname LoadBalance
 * @Description TODO
 * @Date 2020/7/22 19:13
 * @Created by XJC·AW
 */
public interface LoadBalance {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
