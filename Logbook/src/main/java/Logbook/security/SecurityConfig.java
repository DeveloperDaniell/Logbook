package Logbook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/", "/home", "/register", "/h2-console/**", "/css/**").permitAll() // CSS-tiedostot sallittu
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/home", true) // Oletusarvoisen onnistumis-URL:n muutos
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/login?logout")
                                .permitAll()
                )
                .headers().frameOptions().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
