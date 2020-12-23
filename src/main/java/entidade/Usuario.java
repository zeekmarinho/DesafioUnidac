package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	@Id
	@Column(name="ID_USUARIO", nullable=false)
	@GeneratedValue(generator = "S_USER")
	@SequenceGenerator(name = "S_USER", sequenceName = "S_USER", allocationSize = 1)	
	private long idUsuario;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="DATANASCIMENTO")
	private int dataNascimento;
	
	@Column(name="SENHA")
	private String senha;	

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(int dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
