package com.gorajski.broccoliblogjavaspring.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(CustomWebSecurityConfigurerAdapter.class);

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {

        try {
            log.info("Auth has not been configured. See? " + auth.isConfigured());
            auth
                    .inMemoryAuthentication()
                    .withUser("u").password(passwordEncoder().encode("p"))
                    .authorities("ROLE_USER");
            log.info("Auth has been configured. See? " + auth.isConfigured());
        } catch (Exception e) {
            log.info("Something went wrong: " + e);
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
