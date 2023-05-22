package br.com.requeijo.backend.security;

import br.com.requeijo.backend.security.service.DetalheUsuarioServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JWTConfiguracao extends WebSecurityConfigurerAdapter {

    private final DetalheUsuarioServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;

    public JWTConfiguracao(DetalheUsuarioServiceImpl usuarioService, PasswordEncoder passwordEncoder, UserAuthenticationEntryPoint userAuthenticationEntryPoint) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.userAuthenticationEntryPoint = userAuthenticationEntryPoint;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().ignoringAntMatchers("/h2-console/**").disable()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/login", "/api/usuario/salvar").permitAll()
                .and()
                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .addFilter(new JWTAutenticarFilter(authenticationManager()))
                .addFilter(new JWTValidarFilter(authenticationManager()))
                .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//        source.registerCorsConfiguration("/**", corsConfiguration);
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
        corsConfiguration.addAllowedMethod(HttpMethod.PATCH);
        corsConfiguration.addAllowedMethod(HttpMethod.POST);
        corsConfiguration.addAllowedMethod(HttpMethod.PUT);
        corsConfiguration.addAllowedMethod(HttpMethod.GET);
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }

}
