package com.example.asgm1_java5_version2.until;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // Đảm bảo thêm annotation này
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){

        // Đăng ký Interceptor và chỉ áp dụng cho các URL bắt đầu bằng /kichthuoc và /mausac
        interceptorRegistry.addInterceptor(new Interceptor())
                .addPathPatterns("/kichthuoc/**", "/mausac/**", "/nhanvien/**", "/sanpham/**", "/khachhang/**", "/sanphamchitiet/**", "/banhang/**", "/hoadonchitiet/**", "/hoadon/**")
                .excludePathPatterns("/login", "/logout"); // Loại trừ các URL không cần kiểm tra đăng nhập
    }
}
