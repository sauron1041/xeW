//package com.example.baimauck.backend.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Autowired
//    public void globalConfig(AuthenticationManagerBuilder auth, PasswordEncoder encoder, DataSource dataSource) throws  Exception{
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser(User.withUsername("admin")
//                        .password(encoder.encode("admin"))
//                        .roles("ADMIN")
//                        .build()
//                )
//                .withUser(User.withUsername("longueur")
//                        .password(encoder.encode("123"))
//                        .roles("GUYS")
//                        .build()
//                );
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeHttpRequests(auth->auth
//                .requestMatchers("/","/admin/home").permitAll()
//                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
//                .requestMatchers("/guys/*").hasAnyRole("GUYS")
//                .requestMatchers(("/h2-console/**")).permitAll()
//                .anyRequest().authenticated()//cac uri khac can dang nhap duoi bat ky role nao
//        );
//        httpSecurity.httpBasic(Customizer.withDefaults());//cac thiet lap con lai thi theo mac dinh
//        httpSecurity.csrf(csrf->csrf.ignoringRequestMatchers("/h2-console/**"));
//        httpSecurity.headers(headers ->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
//
//        return  httpSecurity.build();
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}
