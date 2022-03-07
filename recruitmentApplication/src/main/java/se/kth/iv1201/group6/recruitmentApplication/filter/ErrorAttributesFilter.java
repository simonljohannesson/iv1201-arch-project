package se.kth.iv1201.group6.recruitmentApplication.filter;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * Class used to filter internal server exceptions caught by Spring.
 */
public class ErrorAttributesFilter extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        final var defaultAttr = super.getErrorAttributes(webRequest, options);
        defaultAttr.remove("timestamp");
        defaultAttr.remove("path");
        defaultAttr.replace("message", "No message available");
        return defaultAttr;
    }
}
