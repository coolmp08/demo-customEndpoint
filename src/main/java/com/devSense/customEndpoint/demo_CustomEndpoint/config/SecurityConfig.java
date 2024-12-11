package com.devSense.customEndpoint.demo_CustomEndpoint.config;


import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(authorizeRequests->
                            authorizeRequests.requestMatchers("/actuator/**").hasRole("ACTUATOR")
                    .anyRequest().authenticated())
                    .httpBasic(withDefaults())
                    .csrf(AbstractHttpConfigurer::disable);

            return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService(){
            UserDetails userDetails = User.builder()
                    .username("user")
                    .password("{noop}password")
                    .roles("ACTUATOR")
                    .build();
            return new InMemoryUserDetailsManager(userDetails);
        }
    }
