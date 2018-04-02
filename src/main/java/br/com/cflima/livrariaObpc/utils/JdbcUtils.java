package br.com.cflima.livrariaObpc.utils;

public class JdbcUtils {
	
	public static final String USUARIO_POR_LOGIN = "SELECT email, senha, nome FROM pessoa"
			+ " WHERE email = ?";
	
	public static final String PERMISSOES_POR_USUARIO = "SELECT p.email, r.nome as nome_permissao FROM pessoa_role pr"
			+ " JOIN pessoa p ON p.id = pr.pessoa_id"
			+ " JOIN role r ON r.id = pr.role_id"
			+ " WHERE u.email = ?";

}
