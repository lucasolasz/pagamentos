package com.ltech.pagamentos.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    // private final MyUserDetailsService myUserDetailsService;
    // private final PasswordEncoder passwordEncoder;

    // public SecurityConfig(MyUserDetailsService myUserDetailsService,
    // PasswordEncoder passwordEncoder) {
    // this.myUserDetailsService = myUserDetailsService;
    // this.passwordEncoder = passwordEncoder;
    // }

    // @Bean
    // public AuthenticationManager authManager(HttpSecurity http) throws Exception
    // {

    // AuthenticationManagerBuilder authBuilder =
    // http.getSharedObject(AuthenticationManagerBuilder.class);
    // authBuilder
    // .userDetailsService(myUserDetailsService)
    // .passwordEncoder(passwordEncoder);
    // return authBuilder.build();
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    // return new BCryptPasswordEncoder();
    // }

    // @Override
    // public void configure(AuthenticationManagerBuilder auth) throws Exception {
    // auth.inMemoryAuthentication()
    // .withUser("admin")
    // .password(passwordEncoder().encode("adminPassword")) // A senha agora está
    // criptografada com BCrypt
    // .roles("ADMIN");
    // }
}
