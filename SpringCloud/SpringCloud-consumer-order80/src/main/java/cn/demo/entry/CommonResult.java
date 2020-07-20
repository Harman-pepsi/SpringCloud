package cn.demo.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname CommonResult
 * @Description
 * @Created by XJC·AW
 * @Date 2020/7/17 1:45
 * @Version V1.0.0
 * @Since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T>
{
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
