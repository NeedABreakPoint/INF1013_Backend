package config;
import config.beans.JwtConfigBean;
import config.jwt.JwtAuthenticationEntryPoint;
import config.jwt.JwtAuthorizationFilter;
import config.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;


public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;
    private JwtConfigBean configBean;
    private JwtAuthenticationEntryPoint jwtEntryPoint;
    public SecurityConfig(@Qualifier("authenticator") UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder,
                          JwtConfigBean configBean,
                          JwtAuthenticationEntryPoint jwtEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.configBean = configBean;
        this.jwtEntryPoint = jwtEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .addFilterAfter(new JwtAuthorizationFilter(configBean, userDetailsService), JwtAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/users/add")
                .permitAll()
                .anyRequest().authenticated();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
