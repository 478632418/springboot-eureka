package com.dx.test.web.converter;

import com.dx.test.module.Article;
import com.dx.test.web.annonations.HeaderTestArgument;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestHeaderMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class HandlerHeaderMethodArgumentResolver extends RequestHeaderMethodArgumentResolver {
    /**
     * Create a new {@link RequestHeaderMethodArgumentResolver} instance.
     *
     * @param beanFactory a bean factory to use for resolving  ${...}
     *                    placeholder and #{...} SpEL expressions in default values;
     *                    or {@code null} if default values are not expected to have expressions
     */
    public HandlerHeaderMethodArgumentResolver(ConfigurableBeanFactory beanFactory) {
        super(beanFactory);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean result= super.supportsParameter(parameter);
        return result;
    }

    @Override
    protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
        return super.resolveName(name, parameter, request);
    }

    //    @Override
//    public boolean supportsParameter(MethodParameter parameter) {
//        //return parameter.getParameterType().isAssignableFrom(Article.class);
//        Class<?> parameterType = parameter.getParameterType();
//        Annotation[] annotations = parameterType.getAnnotations();
//
//        Field[] fields = parameterType.getFields();
//
//        return true;
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        String username = webRequest.getParameter("username");
//
//        return username == null ? parameter : username;
//    }
}
