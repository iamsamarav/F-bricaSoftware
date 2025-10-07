package com.avanade.avabank.avabank.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.avanade.avabank.avabank.repositories.AdministradorRepository;
import com.avanade.avabank.avabank.repositories.ContaRepository;
import com.avanade.avabank.avabank.security.JwtAuthenticationFilter;
import com.avanade.avabank.avabank.security.JwtAuthorizationFilter;
import com.avanade.avabank.avabank.security.JwtUtil;
import com.avanade.avabank.avabank.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class ConfigSeguranca {
	
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private AdministradorRepository administradorRepository;
    
    @Autowired
    private ContaRepository contaRepository;
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .authorizeHttpRequests(authorize -> authorize
            	.requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/clientes/cadastrar").hasAuthority("ADMIN")
//               .requestMatchers(HttpMethod.DELETE, "/clientes").hasRole("ADMIN")
//               .requestMatchers(HttpMethod.PUT, "/clientes/").hasAnyAuthority("ADMIN", "CLIENTE")
//               .requestMatchers(HttpMethod.GET, "/clientes/**").permitAll()
                .anyRequest().permitAll()
            )
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );


        AuthenticationManager authManager = authenticationManager(
            http.getSharedObject(AuthenticationConfiguration.class)
        );

        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(
            authManager, 
            jwtUtil, 
            usuarioService,
            administradorRepository,
            bCryptPasswordEncoder(),
            contaRepository
        );
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        JwtAuthorizationFilter jwtAuthorizationFilter = new JwtAuthorizationFilter(
            authManager,
            jwtUtil,
            userDetailsService
        );

        http.addFilter(jwtAuthenticationFilter);
        http.addFilter(jwtAuthorizationFilter);

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) 
            throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
  

	
	

