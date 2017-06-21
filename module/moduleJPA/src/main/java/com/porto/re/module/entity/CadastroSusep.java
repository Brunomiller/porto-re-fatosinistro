package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gcaksusep database table.
 * 
 */
@Entity
@Table(name="gcaksusep")
@NamedQuery(name="CadastroSusep.findAll", query="SELECT c FROM CadastroSusep c")
public class CadastroSusep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="corsus")
	private String susepCorretor;

	@Column(name="corfilnum")
	private String numFilial;

	@Column(name="corsuspcp")
	private String susepPrincipalCorretor;

	public CadastroSusep() {
	}

	public String getSusepCorretor() {
		return this.susepCorretor;
	}

	public void setSusepCorretor(String susepCorretor) {
		this.susepCorretor = susepCorretor;
	}

	public String getNumFilial() {
		return this.numFilial;
	}

	public void setNumFilial(String numFilial) {
		this.numFilial = numFilial;
	}

	public String getSusepPrincipalCorretor() {
		return this.susepPrincipalCorretor;
	}

	public void setSusepPrincipalCorretor(String susepPrincipalCorretor) {
		this.susepPrincipalCorretor = susepPrincipalCorretor;
	}

}