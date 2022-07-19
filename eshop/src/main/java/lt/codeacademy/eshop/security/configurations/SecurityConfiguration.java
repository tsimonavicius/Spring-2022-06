package lt.codeacademy.eshop.security.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().anyRequest().authenticated();

        http.formLogin()
                .permitAll()
                .loginPage("/prisijungimas")
                .loginProcessingUrl("/prisijungti")
                .defaultSuccessUrl("/products")
                .failureUrl("/prisijungimas?error=login.failed")
                .passwordParameter("slaptazodis")
                .usernameParameter("vartotojoVardas");

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/prisijungimas?logout");
    }
}
