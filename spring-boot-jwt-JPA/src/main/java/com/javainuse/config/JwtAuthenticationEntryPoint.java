package com.javainuse.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

<<<<<<< HEAD
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "you are not authorized to access the page");
=======
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
>>>>>>> 4e0dd176dad142470418a74c5aab2404ec9b9154
	}
}