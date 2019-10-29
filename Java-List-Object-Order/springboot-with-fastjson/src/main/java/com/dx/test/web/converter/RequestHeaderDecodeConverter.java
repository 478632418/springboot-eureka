package com.dx.test.web.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

public class RequestHeaderDecodeConverter implements GenericConverter {
    private static final String ENCODE = "utf-8";
    private String encoder = null;

    public RequestHeaderDecodeConverter(@Nullable String encoder) {
        if (encoder == null) {
            this.encoder = ENCODE;
        } else {
            this.encoder = encoder;
        }
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> pairs = new HashSet<ConvertiblePair>();
        pairs.add(new ConvertiblePair(String.class, String.class));
        return pairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null || sourceType == null || targetType == null) {
            return null;
        }

        Object userName = source;
        if (targetType.hasAnnotation(RequestHeader.class) && targetType.getType().equals(String.class)) {
            try {
                System.out.println(source.toString());
                userName = (source != null ? URLDecoder.decode(source.toString(), ENCODE) : null);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return userName;
    }
}
