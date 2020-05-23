package com.sulin.springsecurity.conf.filter;

import com.sulin.springsecurity.utils.Api;
import com.sulin.springsecurity.utils.ResJsonUtil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sulin
 */
@Component
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String token = request.getHeader("token");
        if (Strings.isBlank(token)) {
            final Api<Object> no_token = Api.builder().code(401).message("no token").build();
            ResJsonUtil.write(response, no_token);
            return;
        }

        if (token.equals("admin")) {


            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken("admin", null, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin"));
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } else if (token.equals("user")) {

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken("user", null, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_user"));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else if (token.equals("operator")) {

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken("operator", null, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_operator"));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            final Api<Object> no_token = Api.builder().code(401).message("token invalid").build();
            ResJsonUtil.write(response, no_token);
            return;
        }
        filterChain.doFilter(request, response);
    }

}
