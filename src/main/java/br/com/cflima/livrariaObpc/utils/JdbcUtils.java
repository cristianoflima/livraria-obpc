package br.com.cflima.livrariaObpc.utils;

public class JdbcUtils {
	
	public static final String USUARIO_POR_LOGIN = "SELECT u FROM user u WHERE u.email LIKE :login";

}
