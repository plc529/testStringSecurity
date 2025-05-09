package com.plctest.securitydemo.config;

import com.plctest.securitydemo.filter.SecurityFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class SecurityConfig {


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http , SecurityFilter securityFilter) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/login", "/cpmmon/captcha").permitAll()//不登录也能访问的路径
//                        .anyRequest().authenticated() //需要拦截没指定的uri登录认证
//                )
//                //在密码校验前进行拦截
//                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
//                .formLogin(form ->
//                                form.loginProcessingUrl("/user/login")
//                                    .loginPage("/login")  // 指定自定义登录页路径
//                                    .successForwardUrl("/welcome2") //登录后指定跳到的访问路径
//
//                );
////                .logout(logout -> logout
////                        .permitAll()
////                );
//        return http.build();
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 推荐 BCrypt
    }

}
