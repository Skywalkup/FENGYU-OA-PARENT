package com.fengyu.common.config.exception;

import com.fengyu.common.ResultCodeEnum;
import lombok.Data;

@Data
public class FengyuException extends RuntimeException{

    // 异常状态码
    private Integer code;
    // 异常描述信息
    private String msg;

    public FengyuException(Integer code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public FengyuException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    @Override
    public String toString(){
        return "FengyuException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                "}";
    }
}
