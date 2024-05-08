package com.wq.common.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author 王骞
 * @Date 2023/7/12 22:45
 * @Version 1.0
 */
@WebFilter(urlPatterns = "/*")
@Slf4j
public class WebFilterImpl implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 过滤器初始化
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if (request instanceof HttpServletRequest) {
            try {
                requestWrapper = new RequestReaderHttpServletRequestWrapper((HttpServletRequest) request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //获取请求中的流如何，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
        // 在chain.doFiler方法中传递新的request对象
        if (requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }
    @Override
    public void destroy() {
        // 过滤器销毁
    }
}
