package com.wq.common.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;



/**
 * 接口出参加密
 * RequestBodyAdvice可以理解为在@RequestBody之前需要进行的 操作
 * ResponseBodyAdvice可以理解为在@ResponseBody之后进行的操作>
 * 所以当接口需要加解密时，在使用@RequestBody接收前台参数之前可以先在RequestBodyAdvice的实现类中进行参数的解密
 * 当操作结束需要返回数据时，可以在@ResponseBody之后进入ResponseBodyAdvice的实现类中进行参数的加密。
 */
@RestControllerAdvice
@Slf4j
public class EncryptResponseBodyAdapter implements ResponseBodyAdvice<Object> {

    // private static final Class<? extends Annotation> ANNOTATION_TYPE = EncryptFilter.class;

    /**
     * 该方法用于判断当前请求的返回值，是否要执行beforeBodyWrite方法
     *
     * @param methodParameter handler方法的参数对象
     * @param converterType   将会使用到的Http消息转换器类类型
     * @return 返回true则会执行beforeBodyWrite
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        // Optional<EncryptFilter> encryptFilter = getEncryptFilter(methodParameter);
        // return encryptFilter.map(EncryptFilter::encryptResponse).orElse(false);
        return true;
    }

    // private Optional<EncryptFilter> getEncryptFilter(MethodParameter methodParameter) {
    //     Method method = methodParameter.getMethod();
    //     if (Objects.nonNull(method) && method.isAnnotationPresent(ANNOTATION_TYPE)) {
    //         return Optional.of(method.getAnnotation(EncryptFilter.class));
    //     }
    //     Class<?> clazz = methodParameter.getContainingClass();
    //     if (AnnotatedElementUtils.hasAnnotation(clazz, ANNOTATION_TYPE)) {
    //         return Optional.of(clazz.getAnnotation(EncryptFilter.class));
    //     }
    //     return Optional.empty();
    // }

    /**
     * 在Http消息转换器执转换，之前执行
     *
     * @param body               服务端的响应数据
     * @param methodParameter    handler方法的参数对象
     * @param mediaType          响应的ContentType
     * @param converterType      将会使用到的Http消息转换器类类型
     * @param serverHttpRequest  serverHttpRequest
     * @param serverHttpResponse serverHttpResponse
     * @return 返回 一个自定义的HttpInputMessage，可以为null，表示没有任何响应
     */
    @Override
    @Nullable
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter methodParameter, MediaType mediaType,Class<? extends HttpMessageConverter<?>> converterType,ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // Result result = new Result();
        // if (Objects.nonNull(body)) {
        //     if (body instanceof Result) {
        //         result = (Result) body;
        //     } else {
        //         result = Result.success(body);
        //     }
        // }
        // result.setRequestId(String.valueOf(ThreadLocalUtil.getMap().get("requestId")));
        // //加密
        // String returnStr = null;
        // try {
        //     returnStr = AESUtil.encrypt(JSON.toJSONString(result));
        // } catch (Exception e) {
        //     log.info("加密异常");
        //     throw new RuntimeException();
        // }
        // log.info("接口执行结果:{} ", JSON.toJSONString(result));
        // log.info("接口加密结果:{}", returnStr);
        // log.info("-------------- 接口日志记录结束 --------------");
        // return returnStr;
        return body;
    }

}
