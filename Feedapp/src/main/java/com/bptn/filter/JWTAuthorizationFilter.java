package com.bptn.filter;

import com.bptn.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class JWTAuthorizationFilter implements Filter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JwtService jwtService;

    @Value("${feed.app.excludeURLFilters}")
    private String excludedUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("Request intercepted by JWTAuthorizationFilter");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String url = req.getRequestURI();
        if(!req.getMethod().equals("OPTIONS")) {
            if (isAuthenticationRequired(url)) {
                String token = req.getHeader(AUTHORIZATION_HEADER);
                if (token == null || !token.startsWith(TOKEN_PREFIX) || !jwtService.validateJwtToken(token)) {
                    res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
            }
        }
        filterChain.doFilter(req, res);
    }

    private boolean isAuthenticationRequired(String url) {
        String[] excludedUrlList = excludedUrls.split(",");
        for (String excludedUrl : excludedUrlList){
            if (excludedUrl.equals(url)) {
                LOGGER.info("Authentication is not required");
                return false;
            }
        }
        return true;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
