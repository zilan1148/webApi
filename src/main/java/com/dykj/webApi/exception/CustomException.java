package com.dykj.webApi.exception;


import com.dykj.webApi.enums.ResultEnum;
import lombok.Data;

/**
 * Author: 张景川
 * Date: 2021/5/10 11:30
 * FileName: CustomException
 * Description: 自定义异常
 */
@Data
public class CustomException extends RuntimeException {
    /**
     * 错误码
     */
    protected int errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public CustomException() {
        super();
    }

    public CustomException(ResultEnum resultEnum) {
        super(String.valueOf(resultEnum.getCode()));
        this.errorCode = resultEnum.getCode();
        this.errorMsg = resultEnum.getMessage();
    }

    public CustomException(ResultEnum resultEnum, Throwable cause) {
        super(String.valueOf(resultEnum.getCode()), cause);
        this.errorCode = resultEnum.getCode();
        this.errorMsg = resultEnum.getMessage();
    }

    public CustomException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public CustomException(int errorCode, String errorMsg) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CustomException(int errorCode, String errorMsg, Throwable cause) {
        super(String.valueOf(errorCode), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
