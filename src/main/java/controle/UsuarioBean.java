package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entidade.Usuario;
import negocio.negocio;


@ManagedBean(name = "UsuarioBean")
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario;
	private negocio negocio;
	private List<Usuario> listaUsuario;
	
	public UsuarioBean() {
		this.usuario = new Usuario();
		this.negocio = new negocio();
		this.listaUsuario = new ArrayList<Usuario>();

	}

	//Salvar
	public void salvar() {
		
		if (this.negocio.inserirUsuario(usuario)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Paciente cadastrado!"));
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro no cadastro!"));
		}

	}
	
	public void pesquisar() {
		this.listaUsuario = negocio.pesquisarUsuario(this.usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	

}
