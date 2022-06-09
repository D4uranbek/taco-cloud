package uz.d4uranbek.tacos.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import uz.d4uranbek.tacos.repositories.UserRepository;

import java.text.MessageFormat;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder( 4 );
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> userRepository
                .findByUsername( username )
                .orElseThrow( () -> new UsernameNotFoundException(
                        MessageFormat.format( "Username {0} not found", username ) ) );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .mvcMatchers( "/design", "/orders" ).hasRole( "USER" )
                .anyRequest().permitAll()

                .and()
                .formLogin()
                .loginPage( "/login" )

//                .and()
//                .oauth2Login()

                .and()
                .logout()
                .logoutSuccessUrl( "/" )

                .and()
                .build();
    }

}
