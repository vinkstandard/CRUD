package Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigSicurezza {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // disabilita CSRF (si può anche non fare)
                .csrf(csrf -> csrf.disable())

                // configura le regole di autorizzazione
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/utenti/public/**").permitAll()
                        .anyRequest().authenticated()
                )

                // abilita HTTP basic auth
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
