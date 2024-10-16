package com.sk.testmvc.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
////        httpSecurity
////                .securityMatcher("/secure/**")
////                .authorizeHttpRequests().anyRequest().fullyAuthenticated()
////                .and()
////                .httpBasic();
//
////        httpSecurity
////                .csrf().disable()
////                .authorizeRequests()
////                .anyRequest().authenticated()
////                .and()
////                .httpBasic();
//        httpSecurity.httpBasic(Customizer.withDefaults())
//                .authorizeHttpRequests(auth -> auth. anyRequest().permitAll() );
//
//       return httpSecurity.build();
//    }
//
//    @Bean
//    UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user1 = User.withDefaultPasswordEncoder().username("user").password("password").authorities("USER").build();
//        UserDetails user2 = User.withDefaultPasswordEncoder().username("admin").password("password").authorities("ADMIN").build();
//                inMemoryUserDetailsManager.createUser(user1);
//                inMemoryUserDetailsManager.createUser(user2);
//        return inMemoryUserDetailsManager;
//    }
//
}
