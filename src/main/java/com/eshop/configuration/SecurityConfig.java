package com.eshop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by User on 06.10.2016.
 * It's prototype, next step need auth with userDb.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication().withUser("vasia").password("vasia123").roles("ADMIN","SUPERADMIN","BUYER").and();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/**").permitAll()
                .antMatchers("/basket").permitAll()
                .antMatchers("/deletebasket").permitAll()
                .anyRequest().authenticated()
                .and();

        http.formLogin().loginPage("/login")
                        .failureUrl("/login?error")
                        .usernameParameter("j_username")
                        .passwordParameter("j_password")
                        .permitAll();

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);
    }
}
