package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Usuario;
import util.JpaUtil;

public class UsuarioDAOImplementacao implements UsuarioDAO{
	
	
	public boolean inserirUsuario(Usuario usuario) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(usuario);

		tx.commit();
		ent.close();

		return true;

	}
	
	
	public boolean alterarUsuario(Usuario usuario) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Usuario existe = ent.find(Usuario.class, usuario.getIdUsuario());

		if (existe != null) {
			existe.setNome(usuario.getNome());
			existe.setCpf(usuario.getCpf());
			existe.setDataNascimento(usuario.getDataNascimento());
			existe.setSenha(usuario.getSenha());


			ent.merge(usuario);

			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}

	}
	
	
	public boolean removerUsuario(Usuario usuario) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		Usuario existe = ent.find(Usuario.class, usuario.getIdUsuario());

		tx.begin();

		if (existe != null) {
			ent.remove(existe);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}
	
	
	public Usuario pesquisarUsuario(String cpf) {
		String sql = "from Paciente p where p.cpf = ?";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);
		query.setParameter(1, cpf);

		List<Usuario> lista = query.getResultList();

		ent.close();
		
		if(lista != null && lista.size() > 0) {
			return lista.get(0);
		}else {
			return null;
		}
	}
	
	
	public List<Usuario> pesquisarUsuario(Usuario usuario) {
		
		return null;
	}
	
	
	public List<Usuario> listarUsuario() {
		
		String sql = "from Paciente p";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);

		List<Usuario> listaUsuario = query.getResultList();

		ent.close();

		return listaUsuario;
	}

}
