package com.dx.test.web.config;

import com.dx.test.web.converter.HandlerHeaderMethodArgumentResolver;
import com.dx.test.web.converter.RequestHeaderDecodeConverter;
import com.dx.test.web.converter.StringToDateConverter;
import com.dx.test.web.converter.StringToEnumConverterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * WebMvcConfigurerAdapter 这个类在SpringBoot2.0已过时，官方推荐直接实现 WebMvcConfigurer 这个接口
 */
@Configuration
@Import({WebMvcAutoConfiguration.class})
@ComponentScan(
        value = "com.dx.test.web",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
        })
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public RequestHeaderDecodeConverter requestHeaderDecodeConverter() {
        return new RequestHeaderDecodeConverter(null);
    }

    @Bean
    public StringToDateConverter stringToDateConverter() {
        return new StringToDateConverter();
    }

    /**
     * 使用 fastjson 代替 jackson
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        /*
         先把JackSon的消息转换器删除.
         备注:(1)源码分析可知，返回json的过程为:
                 Controller调用结束后返回一个数据对象，for循环遍历conventers，找到支持application/json的HttpMessageConverter，然后将返回的数据序列化成json。
                 具体参考org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor的writeWithMessageConverters方法
             (2)由于是list结构，我们添加的fastjson在最后。因此必须要将jackson的转换器删除，不然会先匹配上jackson，导致没使用 fastjson
        */
//        for (int i = converters.size() - 1; i >= 0; i--) {
//            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
//                converters.remove(i);
//            }
//        }
//
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        //自定义fastjson配置
//        FastJsonConfig config = new FastJsonConfig();
//        config.setSerializerFeatures(
//                SerializerFeature.WriteMapNullValue,        // 是否输出值为null的字段,默认为false,我们将它打开
//                SerializerFeature.WriteNullListAsEmpty,     // 将Collection类型字段的字段空值输出为[]
//                SerializerFeature.WriteNullStringAsEmpty,   // 将字符串类型字段的空值输出为空字符串
//                SerializerFeature.WriteNullNumberAsZero,    // 将数值类型字段的空值输出为0
//                SerializerFeature.WriteDateUseDateFormat,
//                SerializerFeature.DisableCircularReferenceDetect    // 禁用循环引用
//        );
//        fastJsonHttpMessageConverter.setFastJsonConfig(config);
//
//        // 添加支持的MediaTypes;不添加时默认为*/*,也就是默认支持全部
//        // 但是MappingJackson2HttpMessageConverter里面支持的MediaTypes为application/json
//        // 参考它的做法, fastjson也只添加application/json的MediaType
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
//        converters.add(fastJsonHttpMessageConverter);
    }

    /**
     * +支持fastjson的HttpMessageConverter
     *
     * @return HttpMessageConverters
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        AbstractHttpMessageConverter abstractHttpMessageConverter = null;
        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        //2:添加fastJson的配置信息;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect);
        fastJsonConfig.setCharset(Charset.forName("utf-8"));

        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;

        return new HttpMessageConverters(converter);
    }

}
