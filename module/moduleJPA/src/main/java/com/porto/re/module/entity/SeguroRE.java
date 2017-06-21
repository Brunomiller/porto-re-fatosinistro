package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rsamseguro database table.
 * 
 */
@Entity
@Table(name="rsamseguro")
@NamedQuery(name="SeguroRE.findAll", query="SELECT s FROM SeguroRE s")
public class SeguroRE implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SeguroREPK id;

	private String rmemdlcod;

	@Column(name="sgrnumdig")
	private String numeroDigitoSeguro;

	@Column(name="sgrorg")
	private String orgSeguro;

	public SeguroRE() {
	}

	public SeguroREPK getId() {
		return this.id;
	}

	public void setId(SeguroREPK id) {
		this.id = id;
	}

	public String getRmemdlcod() {
		return this.rmemdlcod;
	}

	public void setRmemdlcod(String rmemdlcod) {
		this.rmemdlcod = rmemdlcod;
	}

	public String getNumeroDigitoSeguro() {
		return this.numeroDigitoSeguro;
	}

	public void setNumeroDigitoSeguro(String numeroDigitoSeguro) {
		this.numeroDigitoSeguro = numeroDigitoSeguro;
	}

	public String getOrgSeguro() {
		return this.orgSeguro;
	}

	public void setOrgSeguro(String orgSeguro) {
		this.orgSeguro = orgSeguro;
	}

}