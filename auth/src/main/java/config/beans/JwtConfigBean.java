package config.beans;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConfigurationProperties(prefix = "config.jwt")
@Getter
@Setter
@NoArgsConstructor
@Primary
public class JwtConfigBean {
    private String secret;
    private String tokenPrefix;
    private String tokenHeader;
    private int tokenExpiration;
    private String tokenIssuer;
}
