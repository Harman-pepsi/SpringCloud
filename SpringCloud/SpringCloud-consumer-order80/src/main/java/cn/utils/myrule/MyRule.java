package cn.utils.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MyRule
 * @Description TODO
 * @Date 2020/7/22 14:09
 * @Created by XJC·AW
 */
//@Configuration
public class MyRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
