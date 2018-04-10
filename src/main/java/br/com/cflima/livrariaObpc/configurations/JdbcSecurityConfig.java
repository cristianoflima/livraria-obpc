package br.com.cflima.livrariaObpc.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class JdbcSecurityConfig {
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder builder, PasswordEncoder passwordEncoder, DataSource dataSource) throws Exception{
//		builder			
//			.jdbcAuthentication()
//			.dataSource(dataSource)
//			.passwordEncoder(passwordEncoder)
//			.usersByUsernameQuery(USUARIO_POR_LOGIN)
//			.authoritiesByUsernameQuery(PERMISSOES_POR_USUARIO);
//	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("fabio").password("123").roles("1")
			.and()
			.withUser("cristiano").password("123").roles("2")
			.and()
			.withUser("cleber").password("123").roles("1");
	}

}
