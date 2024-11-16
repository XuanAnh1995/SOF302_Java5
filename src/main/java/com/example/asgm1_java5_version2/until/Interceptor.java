package com.example.asgm1_java5_version2.until;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("loggedInUser") == null){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
