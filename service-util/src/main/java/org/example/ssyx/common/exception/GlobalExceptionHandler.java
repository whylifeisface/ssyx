package org.example.ssyx.common.exception;


import org.example.ssyx.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//Aop  全局异常处理
@ControllerAdvice
public class GlobalExceptionHandler {
    // 结果转换为json 异常处理器
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail(null);
    }


    /**自定义异常处理*/
    /*

     */
    @ExceptionHandler(SsymException.class)
    @ResponseBody
    public Result error(SsymException exception){
        return Result.fail(null);
    }

}
