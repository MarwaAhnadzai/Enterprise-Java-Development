package ca.sheridancollege.ahmamarw.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

public class WebSecurityConfigurerAdapter {

    public void configure(WebSecurity web) throws Exception {
        // Your custom configuration for WebSecurity
    }

    protected void configure(HttpSecurity http) throws Exception {
        // Your custom configuration for HttpSecurity
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Your custom configuration for AuthenticationManagerBuilder
    }

}
