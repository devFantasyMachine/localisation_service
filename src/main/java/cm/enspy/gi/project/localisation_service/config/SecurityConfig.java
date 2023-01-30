package cm.enspy.gi.project.localisation_service.config;
 
 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy; 
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource; 

import cm.enspy.gi.project.localisation_service.filters.JWTAuthorizationFilter;

 

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    boolean securityDebug = true;

    private static final String[] AUTH_WHITELIST = {
        "/swagger-resources/**",
        "/swagger-ui/**",
        "/v3/api-docs/**",
        "/v2/api-docs/**",
        "/webjars/**"
    };

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests()
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .requestMatchers("/api/**").permitAll() 
                //.requestMatchers(HttpMethod.POST, "/api/users/**").permitAll()
                //.requestMatchers(HttpMethod.GET, "/api/users/**").permitAll()
                //.hasAnyRole("USER", "ADMIN")
                //.requestMatchers(HttpMethod.PUT, "/api/users/**").hasAnyRole("USER")            
                //.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                //.requestMatchers("/admin/**").hasAnyRole("ADMIN")
                .and()
                .cors().configurationSource(configurationSource())
                .and().csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);


      
        return http.build();
    }

    
  

    public CorsConfigurationSource configurationSource() {
    
        UrlBasedCorsConfigurationSource source =  new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        
        return source;
    }


}




