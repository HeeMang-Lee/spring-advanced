package org.example.expert.interceptor;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
public class AdminApiLoggingInterceptor implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(AdminApiLoggingInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String requestURI = request.getRequestURI();
		if (requestURI.contains("/admin")) {
			String method = request.getMethod();
			LocalDateTime requestTime = LocalDateTime.now();

			log.info("[ADMIN API 접근] 요청 시각: {}, 요청 URL: {} {}",
				requestTime, method, requestURI);
		}
		return true;
	}

}
