package com.eshop.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by User on 06.10.2016.
 * It's prototype, next step need auth with userDb.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource jdbc;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication().dataSource(jdbc)
                    .usersByUsernameQuery("Select user_name j_username, password j_password, enable from user_login where user_name = ?")
                    .authoritiesByUsernameQuery("Select user_name j_username, role from user_role where user_name = ?");
//                .inMemoryAuthentication().withUser("vasia").password("vasia123").roles("SELLER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/","/home").permitAll()
                .antMatchers("/basket/**").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/errors/AccessDenied").permitAll()
                .anyRequest().authenticated()
//                .anyRequest().permitAll()
                .and();

        http.formLogin().loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll();

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .and()
                    .exceptionHandling().accessDeniedPage("/errors/AccessDenied");

    }
}
