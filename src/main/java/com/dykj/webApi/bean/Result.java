package com.dykj.webApi.bean;



import com.dykj.webApi.enums.ResultEnum;
import com.dykj.webApi.exception.CustomException;
import lombok.Builder;
import lombok.Data;

/**
 * Author: 张景川
 * Date: 2021/5/10 10:59
 * FileName: Result
 * Description: 返回结果参数封装
 */
@Data
@Builder
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public static Result success(Object data) {
        return Result.builder().code(ResultEnum.SUCCESS.getCode()).message(ResultEnum.SUCCESS.getMessage()).data(data).build();
    }
    public static Result success(String message) {
        return Result.builder().code(ResultEnum.SUCCESS.getCode()).message(message).data(null).build();
    }

    public static Result success() {
        return Result.builder()
                .code(ResultEnum.SUCCESS.getCode())
                .message(ResultEnum.SUCCESS.getMessage())
                .data(null)
                .build();
    }
    public static Result success(ResultEnum resultEnum,Object data) {
        return Result.builder()
                .code(resultEnum.getCode())
                .message(resultEnum.getMessage())
                .data(data)
                .build();
    }

    public static Result successEnum(ResultEnum resultEnum) {
        return Result.builder()
                .code(resultEnum.getCode())
                .message(resultEnum.getMessage())
                .data(null)
                .build();
    }

    public static Result successEnum(ResultEnum resultEnum, Object data) {
        return Result.builder()
                .code(resultEnum.getCode())
                .message(resultEnum.getMessage())
                .data(data)
                .build();
    }

    public static Result error(Integer errorCode, String errorMsg) {
        return Result.builder().code(errorCode).message(errorMsg).build();
    }

    public static Result error(ResultEnum resultEnum) {
        return Result.builder().code(resultEnum.getCode()).message(resultEnum.getMessage()).build();
    }

    public static Result error(CustomException e) {
        return Result.builder().code(e.getErrorCode()).message(e.getErrorMsg()).build();
    }

    public static Result infor(Integer inforCode, String inforMsg) {
        return Result.builder().code(inforCode).message(inforMsg).build();
    }

    public static Result success(Integer inforCode, String inforMsg) {
        return Result.builder().code(inforCode).message(inforMsg).build();
    }

    public static Result infor(ResultEnum resultEnum) {
        return Result.builder().code(resultEnum.getCode()).message(resultEnum.getMessage()).build();
    }
}
