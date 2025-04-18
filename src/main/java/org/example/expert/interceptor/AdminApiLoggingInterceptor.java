package org.example.expert.interceptor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AdminApiLoggingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String requestURI = request.getRequestURI();
		if (requestURI.contains("/api/admin")) {
			String method = request.getMethod();
			LocalDateTime requestTime = LocalDateTime.now();

			log.info("[ADMIN API 접근] 요청 시각: {}, 요청 URL: {} {}",
				requestTime, method, requestURI);
		}
		return true;
	}
}
