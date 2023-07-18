package org.example.ssyx.common.result;

import lombok.Setter;

@Setter
public class Result<T> {
    //    状态码
    private Integer code;
    //    消息
    private String message;
    //数据
    private T data;

    //    私有化构造方法
    private Result() {
    }

    public static <T> Result<T> build(T data, ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        result.setMessage(resultCodeEnum.getMessage());
        result.setCode(resultCodeEnum.getCode());
        return result;
    }

    //成功
    public static <T> Result<T> ok(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }
    //error
    public static <T> Result<T> fail(T data) {
        return build(data, ResultCodeEnum.FAIL);
    }
}
