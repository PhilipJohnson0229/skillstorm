package com.InventoryManagement;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.InventoryManagement.filter.FilterChainConfig;
import com.InventoryManagement.filter.JwtFilter;
import com.InventoryManagement.utils.CustomPasswordEncoder;

@Configuration
@EnableWebSecurity  // role-based access control (RBAC) to methods.. not just URL
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	//@Autowired // Spring Data JPA should have a datasource already
	//private DataSource datasource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder customPasswordEncoder;
	
	@Autowired
    private JwtFilter jwtFilter;
	//were going to use JWT JSON Web Tokens for statelessness 
	
	// Spring Security Filter logic (pseudo)
	// 1. http-req Authentication Header, filter extract header/ decode base64 Authentication header
	// 2. hashes password with Bcrypt -  $2a$10$iCyW/yDkb6URKSeVwKrQt.FoIf5TJs87OkZfShVWuMQJWSHG83nGe
	// 3. jdbc auth, select username, password, enabled from users where username = ?
	// 4. !enabled? 401 : next
	// 5. $2a$10$iCyW/yDkb6URKSeVwKrQt.FoIf5TJs87OkZfShVWuMQJWSHG83nGe check with the password value from DB
	// 6. authenticated or not?
	// 7. Principal (user currently logged in). stores in HttpSession (any data needs to be Serializable) 
	
	@Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder);
		//auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder.getPasswordEncoder());
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		/*http.csrf().disable().httpBasic(); // not-prod
		http.authorizeRequests().mvcMatchers("/login-check").hasAnyRole("USER");
		http.authorizeRequests().mvcMatchers("/items/**").hasAnyRole("USER");
		http.authorizeRequests().mvcMatchers("/store/**").hasAnyRole("ADMIN");
		http.authorizeRequests().mvcMatchers("/album/**").hasAnyRole("ADMIN");
		http.authorizeRequests().mvcMatchers("/**").permitAll();
		http.logout().deleteCookies("custom-cookie").invalidateHttpSession(true);*/
		//http.logout().deleteCookies("custom-cookie").invalidateHttpSession(false);
		// POST /logout
		// CSRF - 
		// 1. login to Bank of America (session, cookie)
		// 2. hacker send you an email with link
		// 3. click link href=malicious JS   POST boa.com/api/transfer/your-acct/myacct/balance
		// 4. YOU initiated the request
		//http.csrf().disable().addFilterBefore(new FilterChainConfig(), UsernamePasswordAuthenticationFilter.class);
		    http.csrf().disable().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	        
	        http = http.sessionManagement()
	                   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                   .and();
	        
	        http = http.exceptionHandling()
	                   .authenticationEntryPoint((request, response, ex) -> {
	                       response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
	                   }).and();
	                   
	        http.authorizeRequests()
	            .antMatchers("/auth/**").permitAll()
	            .antMatchers("/api").permitAll()
	            .antMatchers("/item/**").permitAll()
	            .antMatchers("/store/**").permitAll()
	            .antMatchers("/login").permitAll()
	            .anyRequest().authenticated();
	        
	      
		// generate a random csrf_token. Unsafe methods MUST contain the CSRF token or-else request is denied
		
	}
	
}
