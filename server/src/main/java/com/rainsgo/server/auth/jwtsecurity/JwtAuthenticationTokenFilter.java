package com.rainsgo.server.auth.jwtsecurity;

import com.rainsgo.server.api.ApiException;
import com.rainsgo.server.auth.api.AuthException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT认证令牌过滤器
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Log4j2
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        String authToken;

        if (!StringUtils.isEmpty(authHeader) && authHeader.startsWith(tokenHead)) {
            authToken = authHeader.substring(tokenHead.length());
        } else {
            // 不按规范,不允许通过验证
            authToken = null;
        }

        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        log.info("authHeader: " + authHeader);
        log.info("authToken: " + authToken);
        log.info("username: " + username);

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            // 如果我们足够相信token中的数据，也就是我们足够相信签名token的secret的机制足够好
            // 这种情况下，我们可以不用再查询数据库，而直接采用token中的数据
            // 本例中，我们还是通过Spring Security的 @UserDetailsService 进行了数据查询
            // 但简单验证的话，你可以采用直接验证token是否合法来避免昂贵的数据查询
            //UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            UserDetails userDetails = jwtTokenUtil.getUserFromToken(authToken);

            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request));
                log.info("authenticated user " + username + ", setting auth context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
