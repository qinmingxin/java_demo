package com.qmx.springboot.demo.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import com.qmx.springboot.demo.common.JWTUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException {
		// Change the req and res to HttpServletRequest and HttpServletResponse
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) res;
		String requestURI = request.getRequestURI();
		if (requestURI.contains("/login")) {
			chain.doFilter(req, res);
			return;
		}
		// Get authorization from Http request
		final String authHeader = request.getHeader("Authorization");

		// If the Http request is OPTIONS then just return the status code 200
		// which is HttpServletResponse.SC_OK in this code
		if ("OPTIONS".equals(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);

			chain.doFilter(req, res);
		}
		// Except OPTIONS, other request should be checked by JWT
		else {

			// Check the authorization, check if the token is started by "Bearer "
			if (authHeader == null ) {
				throw new ServletException("Missing or invalid Authorization header");
			}

			// Then get the JWT token from authorization
			final String token = authHeader;

			try {
				// Use JWT parser to check if the signature is valid with the Key "secretkey"
				final Claims claims = JWTUtils.parseJWT(token);

				// Add the claim to request header
				request.setAttribute("claims", claims);
			} catch (final SignatureException e) {
				throw new ServletException("Invalid token");
			}

			chain.doFilter(req, res);
		}
	}
}
