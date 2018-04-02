package br.com.cflima.livrariaObpc.configurations;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.cflima.livrariaObpc.models.User;

import static br.com.cflima.livrariaObpc.utils.JdbcUtils.*;

@Component
public class OBPCUserDetailsService implements UserDetailsService{
	
	private static final Logger logger = Logger.getLogger(OBPCUserDetailsService.class.getSimpleName());
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
			User user = buscarUsuario(username);
			return user;		
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Problemas ao realizar a busca por usuario!", e);
			throw new UsernameNotFoundException("Problemas com a tentativa de conexão! Ao buscar usuario", e);
		} 
		
	}
	
	public User buscarUsuario(String login) throws SQLException {		
		User user = manager.createQuery(USUARIO_POR_LOGIN, User.class)
				.setParameter("login", login)
				.getSingleResult();

		if (user == null) {
			throw new UsernameNotFoundException("Usuário " + login + " não encontrado!");
		}
		return user;
	}
	
}
