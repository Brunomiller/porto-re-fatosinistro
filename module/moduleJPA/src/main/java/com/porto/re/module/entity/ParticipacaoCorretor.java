package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rsampcorre database table.
 * 
 */
@Entity
@Table(name="rsampcorre")
@NamedQuery(name="ParticipacaoCorretor.findAll", query="SELECT p FROM ParticipacaoCorretor p")
public class ParticipacaoCorretor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sgrorg")
	private String orgSeguro;

	@Column(name="corsus")
	private String susepCorretor;

	@Column(name="sgrnumdig")
	private String numDigSeguro;

	public ParticipacaoCorretor() {
	}

	public String getOrgSeguro() {
		return this.orgSeguro;
	}

	public void setOrgSeguro(String orgSeguro) {
		this.orgSeguro = orgSeguro;
	}

	public String getSusepCorretor() {
		return this.susepCorretor;
	}

	public void setSusepCorretor(String susepCorretor) {
		this.susepCorretor = susepCorretor;
	}

	public String getNumDigSeguro() {
		return this.numDigSeguro;
	}

	public void setNumDigSeguro(String numDigSeguro) {
		this.numDigSeguro = numDigSeguro;
	}

}