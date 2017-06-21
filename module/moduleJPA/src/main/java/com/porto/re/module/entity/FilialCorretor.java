package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gcakfilial database table.
 * 
 */
@Entity
@Table(name="gcakfilial")
@NamedQuery(name="FilialCorretor.findAll", query="SELECT f FROM FilialCorretor f")
public class FilialCorretor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FilialCorretorPK id;

	private String cgcCpfDig;

	private String cgcCpfNum;

	private String cgcOrd;

	private String dddCod;

	private String telTxt;

	public FilialCorretor() {
	}

	public FilialCorretorPK getId() {
		return this.id;
	}

	public void setId(FilialCorretorPK id) {
		this.id = id;
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

	public String getDddCod() {
		return this.dddCod;
	}

	public void setDddCod(String dddCod) {
		this.dddCod = dddCod;
	}

	public String getTelTxt() {
		return this.telTxt;
	}

	public void setTelTxt(String telTxt) {
		this.telTxt = telTxt;
	}

}