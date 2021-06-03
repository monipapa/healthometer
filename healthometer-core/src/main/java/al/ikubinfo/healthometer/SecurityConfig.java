package al.ikubinfo.healthometer;

import al.ikubinfo.healthometer.users.security.JWTConfigurer;
import al.ikubinfo.healthometer.users.security.JwtAccessDeniedHandler;
import al.ikubinfo.healthometer.users.security.JwtAuthenticationEntryPoint;
import al.ikubinfo.healthometer.users.security.TokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private TokenProvider tokenProvider;
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private JwtAuthenticationEntryPoint authenticationErrorHandler;

    // Configure BCrypt password encoder
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(
                        "/auth",
                        "/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/h2-console/**");
    }

    // Configure security settings
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
                .csrf()
                .disable()
                .addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(authenticationErrorHandler)
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .mvcMatchers("/auth")
                .permitAll()
                .mvcMatchers(HttpMethod.POST, "/users")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.DELETE, "/users/{^[\\d]$}")
                .hasAuthority("admin")
                .mvcMatchers(HttpMethod.GET, "/users/{^[\\d]$}")
                .hasAnyAuthority("user", "admin")
                .mvcMatchers(HttpMethod.PUT, "/users/{^[\\d]$}")
                .hasAuthority("admin")
                .mvcMatchers(HttpMethod.PUT, "/users/{^[\\d]$}/change-role/**")
                .hasAuthority("admin")
                .mvcMatchers(HttpMethod.GET, "/unitCategories")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.GET, "/unitSubcategories")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.GET, "/targetCategories")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.GET, "/products")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.GET, "/measurementCategories")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.GET, "/bodyMeasurements")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.GET, "/targets")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.GET, "/targetTrackers")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.PUT, "/unitCategories/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.PUT, "/unitSubcategories/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.PUT, "/targetCategories/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.PUT, "/products/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.PUT, "/measurementCategories/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.PUT, "/bodyMeasurements/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.PUT, "/targets/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.PUT, "/targetTrackers/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.GET, "/unitCategories/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.GET, "/unitSubcategories/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.GET, "/targetCategories/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.GET, "/products/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.GET, "/measurementCategories/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.GET, "/bodyMeasurements/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.GET, "/targets/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.GET, "/targetTrackers/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.POST, "/unitCategories")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.POST, "/unitSubcategories")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.POST, "/targetCategories")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.POST, "/products")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.POST, "/measurementCategories")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.POST, "/bodyMeasurements")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.POST, "/targets")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.POST, "/targetTrackers")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.DELETE, "/unitCategories/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.DELETE, "/unitSubcategories/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.DELETE, "/targetCategories/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.DELETE, "/products/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.DELETE, "/measurementCategories/{^[\\d]$}")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.DELETE, "/bodyMeasurements/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.DELETE, "/targets/{^[\\d]$}")
                .hasAnyAuthority("admin")
                .mvcMatchers(HttpMethod.DELETE, "/targetTrackers/{^[\\d]$}")
                .hasAnyAuthority("admin")
                //TODO
                .mvcMatchers(HttpMethod.POST, "/unitCategories/filter")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.POST, "/unitSubcategories/filter")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.POST, "/targetCategories/filter")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.POST, "/products/filter")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.POST, "/measurementCategories/filter")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.POST, "/bodyMeasurements/filter")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.POST, "/targets/filter")
                .hasAnyAuthority("admin", "user")
                .mvcMatchers(HttpMethod.POST, "/targetTrackers/filter")
                .hasAnyAuthority("admin", "user")
                .anyRequest()
                .authenticated()
                .and()
                .apply(securityConfigurerAdapter());
    }

    private JWTConfigurer securityConfigurerAdapter() {
        return new JWTConfigurer(tokenProvider);
    }
}
