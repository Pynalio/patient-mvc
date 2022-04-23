package ma.enset.patientmvc.secutity;

import ma.enset.patientmvc.secutity.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired //injecter celui qu on a declarer le fichier app.prop
    private DataSource dataSource;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
   private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //il faut evite PasswordEncoder dans une class extends de WebSecurityConfigurerAdapter


       /* PasswordEncoder passwordEncoder=passwordEncoder();*/

        /*auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as principal ,password as credentials ,active from users where username=?").
                authoritiesByUsernameQuery("select username as principal, role from users_roles where username=?  ").rolePrefix("ROLE_").
                passwordEncoder(passwordEncoder);*/

       /* auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return null;
            }
        });*/
    //quand l utilisateur s auth on va se dirige par l objet userDetailsService a la clase userDetailsServiceImpl pour identifer comment on va chercher utilisateur
      auth.userDetailsService(userDetailsService);




        //comment chercher les utilisateurs et les roles (base de donnees ou memory ...)
        //{noop} n utilise pas le mdp on codeur


       /* String code=passwordEncoder.encode("1234");
        System.out.println(code);
        auth.inMemoryAuthentication().withUser("user1").password(code).roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password(code).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(code).roles("USER","ADMIN");
    }*/
}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //formulaire d authen //formulaire defaut http.formLogin() sinon on peut utiliser notre formulaire http.formLogin().loginPage("/login");
        http.formLogin();
        //les droits  d acces
        http.authorizeRequests().antMatchers("/").permitAll();

       /* http.authorizeRequests().antMatchers("/formPatient/**").hasRole("ADMIN");*/
        //tout ce qui lier a /admin doit etre auth en tant que admin
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/user/**").hasAuthority("USER");
        //obligatoire
        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();

        //gerer les exception
        http.exceptionHandling().accessDeniedPage("/403");

    }

}
