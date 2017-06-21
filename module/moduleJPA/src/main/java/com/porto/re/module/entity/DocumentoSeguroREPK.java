package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rsdmdocto database table.
 * 
 */
@Embeddable
public class DocumentoSeguroREPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="prporg")
	private int orgProposta;

	@Column(name="prpnumdig")
	private int numeroDigitoProposta;

	public DocumentoSeguroREPK() {
	}
	public int getOrgProposta() {
		return this.orgProposta;
	}
	public void setOrgProposta(int orgProposta) {
		this.orgProposta = orgProposta;
	}
	public int getNumeroDigitoProposta() {
		return this.numeroDigitoProposta;
	}
	public void setNumeroDigitoProposta(int numeroDigitoProposta) {
		this.numeroDigitoProposta = numeroDigitoProposta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DocumentoSeguroREPK)) {
			return false;
		}
		DocumentoSeguroREPK castOther = (DocumentoSeguroREPK)other;
		return 
			(this.orgProposta == castOther.orgProposta)
			&& (this.numeroDigitoProposta == castOther.numeroDigitoProposta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orgProposta;
		hash = hash * prime + this.numeroDigitoProposta;
		
		return hash;
	}
}