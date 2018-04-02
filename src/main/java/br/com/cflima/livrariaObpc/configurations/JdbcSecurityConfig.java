package br.com.cflima.livrariaObpc.configurations;

import static br.com.cflima.livrariaObpc.utils.JdbcUtils.PERMISSOES_POR_USUARIO;
import static br.com.cflima.livrariaObpc.utils.JdbcUtils.USUARIO_POR_LOGIN;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class JdbcSecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder, PasswordEncoder passwordEncoder, DataSource dataSource) throws Exception{
		builder			
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder)
			.usersByUsernameQuery(USUARIO_POR_LOGIN)
			.authoritiesByUsernameQuery(PERMISSOES_POR_USUARIO);
	}

}
