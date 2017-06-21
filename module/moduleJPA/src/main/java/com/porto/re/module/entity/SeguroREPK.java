package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rsamseguro database table.
 * 
 */
@Embeddable
public class SeguroREPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="succod")
	private int codigoSucursal;

	@Column(name="ramcod")
	private String codigoRamo;

	@Column(name="aplnumdig")
	private String numeroDigitoApolice;

	public SeguroREPK() {
	}
	public int getCodigoSucursal() {
		return this.codigoSucursal;
	}
	public void setCodigoSucursal(int codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public String getCodigoRamo() {
		return this.codigoRamo;
	}
	public void setCodigoRamo(String codigoRamo) {
		this.codigoRamo = codigoRamo;
	}
	public String getNumeroDigitoApolice() {
		return this.numeroDigitoApolice;
	}
	public void setNumeroDigitoApolice(String numeroDigitoApolice) {
		this.numeroDigitoApolice = numeroDigitoApolice;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SeguroREPK)) {
			return false;
		}
		SeguroREPK castOther = (SeguroREPK)other;
		return 
			(this.codigoSucursal == castOther.codigoSucursal)
			&& this.codigoRamo.equals(castOther.codigoRamo)
			&& this.numeroDigitoApolice.equals(castOther.numeroDigitoApolice);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codigoSucursal;
		hash = hash * prime + this.codigoRamo.hashCode();
		hash = hash * prime + this.numeroDigitoApolice.hashCode();
		
		return hash;
	}
}