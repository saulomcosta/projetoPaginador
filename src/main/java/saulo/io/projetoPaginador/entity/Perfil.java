package saulo.io.projetoPaginador.entity;

import jakarta.persistence.*;
import saulo.io.projetoPaginador.enun.StatusPerfil;

@Entity
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private StatusPerfil statusPerfil;

	public Perfil() {}

	public Perfil(String nome, StatusPerfil statusPerfil) {

		this.nome = nome;
		this.statusPerfil = statusPerfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusPerfil getStatusPerfil() {
		return statusPerfil;
	}

	public void setStatusPerfil(StatusPerfil statusPerfil) {
		this.statusPerfil = statusPerfil;
	}

}
