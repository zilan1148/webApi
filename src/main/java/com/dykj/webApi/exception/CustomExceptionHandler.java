package com.dykj.webApi.exception;


import com.alibaba.fastjson.JSON;

import com.dykj.webApi.bean.Result;
import com.dykj.webApi.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

/**
 * Description: 统一异常处理类
 */
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    /**
     * 自定义异常捕获
     * @param e
     * @return
     */
    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public Result customExceptionHandler(CustomException e) {
        log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return Result.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理其他异常
     * @param e 异常
     * @return 封装的Result
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        e.printStackTrace();
        log.error("未知异常！原因是:{}", e.getMessage());
        return Result.error(ResultEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * DTO 抛出异常处理
     * Validated 验证
     * @param ex 异常
     * @return Result
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result exceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        return Result.error(503, defaultMessage);
    }

    /**
     * 约束违反例外
     * @param e
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public Result constraintViolationExceptionHandler(ConstraintViolationException e) {
        log.error("数据已存在:{}", e.getMessage());
        return Result.error(e.getErrorCode(), e.getMessage());
    }

    /**
     * 处理空指针的异常
     * @param e 异常
     * @return 封装的Result
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result nllPointerExceptionHandler(NullPointerException e) {
        log.error("发生空指针异常！原因是:{}", e.getMessage());
        e.printStackTrace();
        return Result.error(ResultEnum.BODY_NOT_MATCH);
    }

    /**
     * Http请求方法不支持异常
     * @param e 异常
     * @return 封装的Result
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public void httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e,HttpServletResponse response) {
        try {
            //跨域配置
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_OK);
            Result result = Result.error(ResultEnum.HTTP_REQUEST_METHOD);
            String jsonString = JSON.toJSONString(result);
            response.getWriter().write(jsonString);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * AccessDeniedException: 不允许访问
     * 没有访问权限
     * @param e 异常
     * @return 封装的Result
     */
    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseBody
    public Result accessDeniedExceptionHandler(AccessDeniedException e) {
        //e.printStackTrace();
        return Result.error(ResultEnum.USER_NO_HAVE_PERMISSION);
    }
}
