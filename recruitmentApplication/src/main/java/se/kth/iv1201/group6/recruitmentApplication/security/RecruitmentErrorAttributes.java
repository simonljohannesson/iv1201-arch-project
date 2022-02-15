package se.kth.iv1201.group6.recruitmentApplication.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;


public class RecruitmentErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        final var defaultAttr = super.getErrorAttributes(webRequest, options);
//        Error e = new Error();
//        if(defaultAttr.getOrDefault("status", 500) instanceof Integer status) e.status = status;
//        if(defaultAttr.getOrDefault("error", "not specified") instanceof String error) e.error = error;
//        if(defaultAttr.getOrDefault("message", "not specified") instanceof String message) e.message = message;
//        if(defaultAttr.getOrDefault("path", "not specified") instanceof String path) e.path = path;
        defaultAttr.put("clowning", 666);
        return defaultAttr;
    }
}
