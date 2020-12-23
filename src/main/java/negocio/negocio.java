package negocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.UsuarioDAO;
import dao.UsuarioDAOImplementacao;
import entidade.Usuario;
import util.JpaUtil;

public class negocio {
	
	private UsuarioDAO usuarioDAO;
	
	public negocio() {
		this.usuarioDAO = new UsuarioDAOImplementacao();
	}
	
		//Inserir Usuario	
		public boolean inserirUsuario(Usuario usuario) {

			Usuario pacienteExiste = this.usuarioDAO.pesquisarUsuario(usuario.getCpf());
			
			if(pacienteExiste != null) {
				return false;
			}else {
				return this.usuarioDAO.inserirUsuario(usuario);
			}
		}
		
		//Alterar Usuario

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
		
		//Remover Usuario

		public boolean removerUsuario(Usuario usuario) {
			EntityManager ent = JpaUtil.getEntityManager();
			EntityTransaction tx = ent.getTransaction();

			tx.begin();

			Usuario existe = ent.find(Usuario.class, usuario.getIdUsuario());

			if (existe != null) {

				ent.remove(existe);
				tx.commit();
				ent.close();
				return true;
			} else {
				return false;
			}

		}
		
		//Pesquisar Usuario

		public List<Usuario> pesquisarUsuario(Usuario usuario) {
			String sql = "from Paciente p where 1=1" + montarWhere(usuario);
			return null;
		}
		
		//String montarWhere
		
		private String montarWhere(Usuario usuario) {
			String where = "1";

			if (usuario.getCpf() != null && !usuario.getNome().isEmpty()) {
				where += "and u.cpf = " + usuario.getCpf() + "'";
			} else {
				if (usuario.getNome() != null && !usuario.getNome().isEmpty()) {
					where += "and u.nome like '%" + usuario.getNome() + "%'";
				}
				if (usuario.getDataNascimento() > 01/01/1900 && usuario.getDataNascimento() < 01/01/2020 ) {
					where += "and u.datanacimento = " + usuario.getDataNascimento();
				}
			}
			return null;
		}

}
