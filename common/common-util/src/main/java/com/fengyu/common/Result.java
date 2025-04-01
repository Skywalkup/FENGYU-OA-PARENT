package com.fengyu.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    // 私有化
    private Result(){}

    // 封装返回数据
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum){
        Result<T> result = new Result<>();
        // 放数据进去
        if (body != null){
            result.setData(body);
        }
        // 状态码
        result.setCode(resultCodeEnum.getCode());
        // 返回信息
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    // 返回成功的
    public static<T> Result<T> ok(){
        return build(null, ResultCodeEnum.SUCCESS);
    }

    public static<T> Result<T> ok(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    // 返回失败的
    public static<T> Result<T> fail(){
        return build(null, ResultCodeEnum.FAIL);
    }

    public static<T> Result<T> fail(T data) {
        return build(data, ResultCodeEnum.FAIL);
    }

    // 如果需要修改返回的状态码和信息
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
