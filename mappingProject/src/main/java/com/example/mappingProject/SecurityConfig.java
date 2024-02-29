//package com.example.mappingProject;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SecurityConfig {
//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.csrf(AbstractHttpConfigurer::disable)
////                .authorizeHttpRequests((authorize) -> {
////                    authorize.anyRequest().authenticated();
////                }).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
//
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((authorize) -> {
//                    authorize.anyRequest().authenticated();
//                }).formLogin(Customizer.withDefaults());
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails admin = User.builder()
//                .username("Deepthi")
//                .password(passwordEncoder().encode("Deepthi"))
//                .roles("ADMIN")
//                .build();
//
//
//        UserDetails deepthi = User.builder()
//                .username("Deepthi")
//                .password(passwordEncoder().encode("deepthi"))
//                .roles("USER")
//                .build();
//
//        UserDetails shreshti = User.builder()
//                .username("Shreshti")
//                .password(passwordEncoder().encode("shreshti"))
//                .roles("USER")
//                .build();
//
//        UserDetails prasanna = User.builder()
//                .username("Prasanna")
//                .password(passwordEncoder().encode("prasanna"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(admin,deepthi);
//    }
//}
