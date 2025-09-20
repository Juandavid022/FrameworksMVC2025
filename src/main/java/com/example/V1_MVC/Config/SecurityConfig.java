package com.example.V1_MVC.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, UserDetailsService userDetailsService)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // para Postman; en producción habilitar y usar token CSRF
                .authorizeHttpRequests(authz -> authz
                        // recursos públicos y registro
                        .requestMatchers("/login", "/", "/mision", "/servicios", "/vision", "/valores", "/students/register","/students/save", "/css/**", "/js/**",
                                "/images/**")
                        .permitAll()

                        // rutas de coach: permiten COACH y ADMIN
                        .requestMatchers("/coach/**").hasAnyRole("COACH", "ADMIN")

                        // rutas de student: permiten STUDENT y ADMIN
                        .requestMatchers("/students/**").hasAnyRole("STUDENT", "ADMIN")

                        // rutas de admin: solo ADMIN
                        .requestMatchers("/users/**", "/admin/**").hasRole("ADMIN")

                        // cualquier otra petición requiere autenticación
                        .anyRequest().authenticated())

                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll())
                .httpBasic(); // permite usar Basic Auth desde Postman

        return http.build();
    }

}
