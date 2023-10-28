package com.example.DBMSPro.Config;
import com.example.DBMSPro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    @Qualifier("userDetailsService")
    UserService  userService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/admin").hasAnyRole("ADMIN")
//                        .requestMatchers("/user").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/","/search/**","/update_employee/**","/productImages/**","/update_product/{ProductId}","/addProduct","/user","viewOrder/**","/Orders/**","/update_order/{order_id}","/checkout","/add_employee/**","admin/**","/addToCart/**","/shop/**","/cart/**","/product/**","/product/delete/{ProductId}","/update_product/{prod_id}","/products","/addProduct","/resources/**","/home","/signin/**","/login/**","/register/**","/logout/**","/shop/**","/about/**","/css/**", "/js/**", "/images/**").permitAll()
//                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/signin")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/",true)
                )
                .logout((logout) ->
                        logout.deleteCookies("remove")
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/").permitAll()
                )
                .httpBasic(Customizer.withDefaults());
        return http.csrf(AbstractHttpConfigurer::disable).build();
    }
}
