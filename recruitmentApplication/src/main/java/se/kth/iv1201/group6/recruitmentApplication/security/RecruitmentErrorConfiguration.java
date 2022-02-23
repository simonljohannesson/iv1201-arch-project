package se.kth.iv1201.group6.recruitmentApplication.security;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.kth.iv1201.group6.recruitmentApplication.filter.ErrorAttributesFilter;

@Configuration
public class RecruitmentErrorConfiguration {
    /**
     * Override default error attribute with this bean.
     */
    @Bean
    public ErrorAttributes errorAttributes(){
        return new ErrorAttributesFilter();
    }
}
