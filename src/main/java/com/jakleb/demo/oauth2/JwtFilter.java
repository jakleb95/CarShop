package com.jakleb.demo.oauth2;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

    @Value("${jwt.key}")
    private String JWT_KEY;
    private static final String BEARER = "Bearer ";
    private static final String CLAIMS = "claims";
    private static final String AUTHORIZATION = "Authorization";


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String header = httpServletRequest.getHeader(AUTHORIZATION);

        if (header == null || !header.startsWith(BEARER)) {
            throw new ServletException("Missing or invalid Authorization header");
        } else {
            try {
                String token = header.replace(BEARER,"");
                Claims claims = Jwts.parser().setSigningKey(JWT_KEY.getBytes()).parseClaimsJws(token).getBody();
                servletRequest.setAttribute(CLAIMS, claims);

            } catch (final SignatureException e) {
                throw new ServletException("Invalid token");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
