package com.dragon.spring.security;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by huangzhibo on 27/03/2017.
 */
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{ //继承AbstractSecurityInterceptor、实现Filter是必须的。
    //配置文件注入
    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    //登陆后，每次访问资源都通过这个拦截器拦截
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }

    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return this.securityMetadataSource;
    }

    @Override
    public Class<? extends Object> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    public void invoke(FilterInvocation fi) throws IOException, ServletException {
        //fi里面有一个被拦截的url
        //里面调用MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取fi对应的所有权限
        //再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
        /**
         * beforeInvocation这个方法，
         * 它首先会调用MyInvocationSecurityMetadataSource类的getAttributes方法获取被拦截url所需的权限，
         * 再调用MyAccessDecisionManager类decide方法判断用户是否够权限.
         * 最后，就会执行下一个拦截器.
         */
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            //执行下一个拦截器
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }
    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }
    public void setSecurityMetadataSource(
            FilterInvocationSecurityMetadataSource newSource)
    {
        this.securityMetadataSource = newSource;
    }
    @Override
    public void destroy() {

    }
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
