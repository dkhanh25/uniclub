package com.cybersoft.uniclub.security;

import com.cybersoft.uniclub.filter.CustomJwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomJwtFilter customJwtFilter;

    //Khởi tạo chuẩn mã hóa sử dụng và lưu trên IOC
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Spring Security 6~
     * Thay đổi thông tin cấu hình của Security : Phân quyền, chứng thực...
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf(c -> c.disable())
//                .authorizeHttpRequests(a -> {
//                            a.requestMatchers("/role").permitAll();
//                            a.anyRequest().authenticated();
//                        }
//                );
//
//         return http.build();

        /** Cấu hình Security như bên dưới
         *  GET /admin -> Ai truy cập cũng được
         *  POST /admin -> Chỉ user truy cập được
         *  PUT /admin -> Chỉ admin vô được
         *  DELETE /admin -> admin hoặc user vô được
         */

        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/login/**").permitAll()
//                .requestMatchers(HttpMethod.POST,"/admin").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
