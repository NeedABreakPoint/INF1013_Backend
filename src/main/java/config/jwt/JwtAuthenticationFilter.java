package config.jwt;

import DTO.AuthDto;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    private final String secret = "secretsecretsecretsecretsecret";


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            AuthDto authenticationRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), AuthDto.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );

            Authentication authenticate = authenticationManager.authenticate(authentication);

            return authenticate;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        try{
            Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
            String token = JWT.create()
                    .withIssuer("Admin")
                    .withIssuedAt(new Date())
                    .withSubject(((AuthDto) authResult.getPrincipal()).getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                    .sign(algorithm);

            response.addHeader("Authorization", "Bearer " + token);

        }catch (JWTCreationException e){
            throw new RuntimeException(e);
        }

        super.successfulAuthentication(request, response, chain, authResult);
    }
}
