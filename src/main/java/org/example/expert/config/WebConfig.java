package org.example.expert.config;

import lombok.RequiredArgsConstructor;

import org.example.expert.interceptor.AdminApiLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AdminApiLoggingInterceptor adminApiLoggingInterceptor;

    @Autowired
    public WebConfig(AdminApiLoggingInterceptor adminApiLoggingInterceptor) {
        this.adminApiLoggingInterceptor = adminApiLoggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminApiLoggingInterceptor)
            .addPathPatterns("/api/admin/comments/**", "/api/admin/users/**");
    }

    // ArgumentResolver 등록
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new AuthUserArgumentResolver());
    }
}
