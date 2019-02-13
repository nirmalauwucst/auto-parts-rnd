/**
 * 
 */
package it.nmadlk.configuration;

import it.nmadlk.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import it.nmadlk.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Navo
 *
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
				.csrf().disable();
		httpSecurity.authorizeRequests()
				.antMatchers("**/vehicles/**").authenticated()
				.anyRequest().permitAll()
				.and()
				.formLogin().permitAll();
	}

	private PasswordEncoder getPasswordEncoder(){
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;
			}
		};
	}

}
