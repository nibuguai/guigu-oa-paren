package com.wq.common.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wq.common.exception.CustomException;
import com.wq.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
/**
 * @Author 王骞
 * @Date 2023/7/12 22:05
 * @Version 1.0
 */
@Slf4j
@ControllerAdvice
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body!=null) {
            log.info(body.toString());
        }
        Result result = new Result().ok().data(body);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String writeValueAsString = objectMapper.writeValueAsString(result);
            log.info("前端出参：{}", writeValueAsString);
        } catch (Exception e) {
            log.error("转换返回值为JSON失败", e);
            log.info("前端出参：{}", result);
        }
        return result;
    }

    @ExceptionHandler(CustomException.class)
        public Result handleCustomException(CustomException ex) {
            Result result = new Result(ex.getErrorCode(), ex.getMessage());
            return result;
    }


}
