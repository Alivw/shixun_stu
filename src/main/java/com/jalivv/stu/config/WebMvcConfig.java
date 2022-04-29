package com.jalivv.stu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private static final List<String> EXCLUDE_PATH = Arrays.asList(
            "/back/statics/**",
            "/back/login.jsp",
            "/back/register.jsp",
            "/user/image",
            "/user/login"
    );

    @Bean
    public HandlerInterceptor handlerInterceptor() {
        HandlerInterceptor in = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (request.getSession().getAttribute("user") == null) {
                    // response.sendRedirect(request.getContextPath()+"/back/login.jsp");
                    request.getRequestDispatcher("/back/login.jsp").forward(request, response);
                    return false;
                }
                return true;
            }
        };
        return in;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor()).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATH);

    }
}
