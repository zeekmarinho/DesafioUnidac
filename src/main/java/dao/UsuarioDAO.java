package dao;

import java.util.List;

import entidade.Usuario;

public interface UsuarioDAO {
	
	public boolean inserirUsuario(Usuario usuario);
	
	public boolean alterarUsuario(Usuario usuario);
	
	public boolean removerUsuario(Usuario usuario);
	
	public Usuario pesquisarUsuario(String cpf);
	
	public List<Usuario> pesquisarUsuario(Usuario usuario);
	
	public List<Usuario> listarUsuario();

}
