package cn.demo;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @Classname TestMethod
 * @Description TODO
 * @Date 2020/7/24 3:52
 * @Created by XJC·AW
 */
public class TestMethod {

    @Test
    public void testGetTime(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime); //2020-07-24T03:53:31.674+08:00[Asia/Shanghai]
    }
}
