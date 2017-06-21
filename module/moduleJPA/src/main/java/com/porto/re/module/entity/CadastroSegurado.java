package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gsakseg database table.
 * 
 */
@Entity
@Table(name="gsakseg")
@NamedQuery(name="CadastroSegurado.findAll", query="SELECT c FROM CadastroSegurado c")
public class CadastroSegurado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="segnumdig")
	private int numeroDigitoSegurado;

	private String cgcCpfDig;

	private String cgcCpfNum;

	private String cgcOrd;

	@Column(name="segnom")
	private String nomeSegurado;

	public CadastroSegurado() {
	}

	public int getNumeroDigitoSegurado() {
		return this.numeroDigitoSegurado;
	}

	public void setNumeroDigitoSegurado(int numeroDigitoSegurado) {
		this.numeroDigitoSegurado = numeroDigitoSegurado;
	}

	public String getCgcCpfDig() {
		return this.cgcCpfDig;
	}

	public void setCgcCpfDig(String cgcCpfDig) {
		this.cgcCpfDig = cgcCpfDig;
	}

	public String getCgcCpfNum() {
		return this.cgcCpfNum;
	}

	public void setCgcCpfNum(String cgcCpfNum) {
		this.cgcCpfNum = cgcCpfNum;
	}

	public String getCgcOrd() {
		return this.cgcOrd;
	}

	public void setCgcOrd(String cgcOrd) {
		this.cgcOrd = cgcOrd;
	}

	public String getNomeSegurado() {
		return this.nomeSegurado;
	}

	public void setNomeSegurado(String nomeSegurado) {
		this.nomeSegurado = nomeSegurado;
	}

}