package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gcakcorr database table.
 * 
 */
@Entity
@Table(name="gcakcorr")
@NamedQuery(name="CadastroCorretor.findAll", query="SELECT c FROM CadastroCorretor c")
public class CadastroCorretor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="corsuspcp")
	private String susepPrincipalCorretor;

	@Column(name="cornom")
	private String nomeCorretor;

	public CadastroCorretor() {
	}

	public String getSusepPrincipalCorretor() {
		return this.susepPrincipalCorretor;
	}

	public void setSusepPrincipalCorretor(String susepPrincipalCorretor) {
		this.susepPrincipalCorretor = susepPrincipalCorretor;
	}

	public String getNomeCorretor() {
		return this.nomeCorretor;
	}

	public void setNomeCorretor(String nomeCorretor) {
		this.nomeCorretor = nomeCorretor;
	}

}