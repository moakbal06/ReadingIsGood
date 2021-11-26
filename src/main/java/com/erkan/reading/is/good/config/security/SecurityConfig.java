package com.erkan.reading.is.good.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Profile("default")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
            http.authorizeRequests()
                    .antMatchers(
                            "/",
                            "/customers**",
                            "/customers/**",
                            "/orders**",
                            "/orders/**",
                            "/login**",
                            "/error**",
                            "/h2**",
                            "/h2/**",
                            "/h2-console/**",
                            "/swagger-ui/**",
                            "/swagger**",
                            "/v2/**",
                            "/v2**",
                            "/api-docs**",
                            "/swagger-resources/**",
                            "/swagger-resources**",
                            "/webjars/**"
                            )
                    .permitAll()
                    .anyRequest()
                    .authenticated();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2/**","/h2**", "/customers**",
                        "/customers/**",
                        "/orders**",
                        "/statistics**",
                        "/statistics/**",
                        "/orders/**");
    }
}
