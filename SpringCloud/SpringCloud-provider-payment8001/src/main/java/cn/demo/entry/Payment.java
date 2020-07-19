package cn.demo.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname Payment
 * @Description
 * @Created by XJC·AW
 * @Date 2020/7/17 1:37
 * @Version V1.0.0
 * @Since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable
{
    private Integer id;
    private String serial;
}
