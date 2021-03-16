package Sklep_Internetowy_package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM USERS WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, role FROM USERS WHERE username=?");
    }


    @Override
    protected  void configure(HttpSecurity http)  throws Exception {
        http.authorizeRequests()
                .antMatchers("/list/produkty/admin", "/list/pracownicy", "/list/magazyny", "/new/produkt/admin","/new/pracownik", "/new/magazyn", "/edit/produkt/admin/**", "/edit/pracownik/**", "/edit/magazyn/**","/delete/produkt/admin/**", "/delete/magazyn/**", "/delete/pracownik/**","/update/produkt/admin", "/update/magazyn","/update/pracownik","/save/produkt/admin", "/save/pracownik", "/save/magazyn").hasRole("ADMIN")
                .antMatchers("/list/produkty/user", "/new/produkt/user", "edit/produkt/user/**","save/produkt/user","/delete/produkt/user/**","update/produkt/user").hasAnyRole( "USER")
                .antMatchers( "/").hasAnyRole( "ADMIN","USER")
                .anyRequest().permitAll()
                .and()
               .formLogin().loginPage("/login").permitAll()
               .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
