//package com.example.dabbaWalaWebsite.security;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//
//import java.io.IOException;
//import java.util.Set;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig{
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Bean
//    public AuthenticationProvider authProvider(){
//        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(new BCryptPasswordEncoder());
//        return provider;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests(
//                authorizeRequests ->
////                authorizeRequests.requestMatchers(HttpMethod.GET,"/customer/**").authenticated()
////                        .requestMatchers(HttpMethod.GET,"/restaurant/**").authenticated()
////                        .anyRequest().permitAll()
//                        authorizeRequests
//                                .requestMatchers("/customer/**").hasRole("CUSTOMER")
//                                .requestMatchers("/restaurant/**").hasRole("RESTAURANT_OWNER")
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                                .anyRequest().permitAll()
//        );
//
////        http.formLogin(formLoginConfigurer ->
////                formLoginConfigurer
////                        .loginPage("/login") // Set custom login page URL
////                        .defaultSuccessUrl("/")
////                        .failureUrl("/login?error")
////        );
//        http.formLogin(formLoginConfigurer ->
//                formLoginConfigurer
//                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
//                        .defaultSuccessUrl("/dashboard")
//                        .failureUrl("/login?error")
//        );
//
//        http.httpBasic(Customizer.withDefaults());
//
//        //disable cross Site request Forgery(CSRF)
//        http.csrf(AbstractHttpConfigurer::disable);
//
//        return http.build();
//    }
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(authProvider());
////    }
////
////    @Bean
////    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
////        return new MyAuthenticationSuccessHandler();
////    }
////
////    public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
////        @Override
////        public void onAuthenticationSuccess(
////                HttpServletRequest request,
////                HttpServletResponse response,
////                Authentication authentication
////        ) throws IOException, ServletException {
////            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
////
////            if (roles.contains("CUSTOMER")) {
////                setDefaultTargetUrl("/customer/dashboard"); // Change to the appropriate URL
////            } else if (roles.contains("RESTAURANT_OWNER")) {
////                setDefaultTargetUrl("/restaurant-owner/dashboard"); // Change to the appropriate URL
////            } else if (roles.contains("ADMIN")) {
////                setDefaultTargetUrl("/admin/dashboard"); // Change to the appropriate URL
////            }
////
////            super.onAuthenticationSuccess(request, response, authentication);
////        }
////    }
//}
