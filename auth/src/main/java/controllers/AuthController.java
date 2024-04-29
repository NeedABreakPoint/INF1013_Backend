package controllers;

import DTO.AuthDto;
import DTO.UserDetailsDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Log4j2
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @ApiOperation("login")
    @ApiResponses(value = {@ApiResponse(code=200, message = "OK", response = UserDetailsDto.class)})
    @PostMapping(value = "/login",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDetailsDto> authenticateUser(@RequestBody AuthDto loginRequestDto) {
        // Seulement l'authentification est nécessaire ici
        Authentication authentication = authenticate(loginRequestDto);
        UserDetailsDto userDetailsDto = (UserDetailsDto) authentication.getPrincipal();

        return ResponseEntity.ok(userDetailsDto);
    }

    private Authentication authenticate(AuthDto loginRequestDto) throws BadCredentialsException {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername().toLowerCase().trim(),
                        loginRequestDto.getPassword()));
    }
}

