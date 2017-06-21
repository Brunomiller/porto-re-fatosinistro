package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rsdmdocto database table.
 * 
 */
@Entity
@Table(name="rsdmdocto")
@NamedQuery(name="DocumentoSeguroRE.findAll", query="SELECT d FROM DocumentoSeguroRE d")
public class DocumentoSeguroRE implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DocumentoSeguroREPK id;

	@Column(name="edsnumdig")
	private String numeroDigitoEndosso;

	@Column(name="segnumdig")
	private String numeroDigitoSegurado;

	@Column(name="vigfnl")
	private String finalVigencia;

	@Column(name="viginc")
	private String inicioVigencia;

	public DocumentoSeguroRE() {
	}

	public DocumentoSeguroREPK getId() {
		return this.id;
	}

	public void setId(DocumentoSeguroREPK id) {
		this.id = id;
	}

	public String getNumeroDigitoEndosso() {
		return this.numeroDigitoEndosso;
	}

	public void setNumeroDigitoEndosso(String numeroDigitoEndosso) {
		this.numeroDigitoEndosso = numeroDigitoEndosso;
	}

	public String getNumeroDigitoSegurado() {
		return this.numeroDigitoSegurado;
	}

	public void setNumeroDigitoSegurado(String numeroDigitoSegurado) {
		this.numeroDigitoSegurado = numeroDigitoSegurado;
	}

	public String getFinalVigencia() {
		return this.finalVigencia;
	}

	public void setFinalVigencia(String finalVigencia) {
		this.finalVigencia = finalVigencia;
	}

	public String getInicioVigencia() {
		return this.inicioVigencia;
	}

	public void setInicioVigencia(String inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

}