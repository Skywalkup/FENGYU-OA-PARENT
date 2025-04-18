package com.fengyu.common.config.exception;

import com.fengyu.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常执行的方法
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail().message("执行全局异常处理");
    }

    // 特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        e.printStackTrace();
        return Result.fail().message("执行特定异常处理");
    }

    // 自定义异常处理
    @ExceptionHandler(FengyuException.class)
    @ResponseBody
    public Result error(FengyuException e){
        e.printStackTrace();;
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }
}
