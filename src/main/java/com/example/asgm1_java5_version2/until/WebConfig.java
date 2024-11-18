package com.example.asgm1_java5_version2.until;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(new Interceptor())
                .addPathPatterns("/kichthuoc/**", "/mausac/**", "/nhanvien/**",
                        "/sanpham/**", "/khachhang/**", "/sanphamchitiet/**",
                        "/banhang/**", "/hoadonchitiet/**", "/hoadon/**", "/main/**")
                .excludePathPatterns("/login", "/logout", "/css/**", "/js/**"); // Ensure static resources are accessible
    }
}
