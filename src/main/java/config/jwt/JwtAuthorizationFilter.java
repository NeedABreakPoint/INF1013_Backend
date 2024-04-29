package config.jwt;

import DTO.UserDetailsDto;
import config.beans.JwtConfigBean;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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

@Slf4j
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtConfigBean configBean;
    private final UserDetailsService userDetailsService;

    public JwtAuthorizationFilter(JwtConfigBean configBean,
                                  UserDetailsService userDetailsService) {

        this.configBean = configBean;
        this.userDetailsService = userDetailsService;
    }

    private String extractJwtToken(HttpServletRequest request) {
        String headerAuth = request.getHeader(configBean.getTokenHeader());
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(configBean.getTokenPrefix())) {
            return headerAuth.replace(configBean.getTokenPrefix(), "").trim();
        }
        return null;
    }

    public DecodedJWT decodeJwtToken(String token) {
        Algorithm algorithm = Algorithm.
                HMAC256(configBean.getSecret());
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(configBean.getTokenIssuer())
                .build();
        return verifier.verify(token);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Step1");
        String jwt = extractJwtToken((HttpServletRequest) request);
        if(jwt != null) {
            DecodedJWT decoded = decodeJwtToken(jwt);
            if (decoded != null) {
                String username = decoded.getSubject();
                UserDetailsDto userDetails = (UserDetailsDto) userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails,
                                userDetails.getCredentials(),
                                userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource()
                        .buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        log.info("Step2");
        filterChain.doFilter(request, response);
    }
}
