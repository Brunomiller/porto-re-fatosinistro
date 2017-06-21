package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sinmcbt database table.
 * 
 */
@Embeddable
public class CoberturaSinistroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ramcod")
	private int codigoRamo;

	@Column(name="sinano")
	private int anoSinistro;

	@Column(name="sinnum")
	private int numeroSinistro;

	@Column(name="sinitmseq")
	private int sequenciaItemSinistro;

	public CoberturaSinistroPK() {
	}
	public int getCodigoRamo() {
		return this.codigoRamo;
	}
	public void setCodigoRamo(int codigoRamo) {
		this.codigoRamo = codigoRamo;
	}
	public int getAnoSinistro() {
		return this.anoSinistro;
	}
	public void setAnoSinistro(int anoSinistro) {
		this.anoSinistro = anoSinistro;
	}
	public int getNumeroSinistro() {
		return this.numeroSinistro;
	}
	public void setNumeroSinistro(int numeroSinistro) {
		this.numeroSinistro = numeroSinistro;
	}
	public int getSequenciaItemSinistro() {
		return this.sequenciaItemSinistro;
	}
	public void setSequenciaItemSinistro(int sequenciaItemSinistro) {
		this.sequenciaItemSinistro = sequenciaItemSinistro;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CoberturaSinistroPK)) {
			return false;
		}
		CoberturaSinistroPK castOther = (CoberturaSinistroPK)other;
		return 
			(this.codigoRamo == castOther.codigoRamo)
			&& (this.anoSinistro == castOther.anoSinistro)
			&& (this.numeroSinistro == castOther.numeroSinistro)
			&& (this.sequenciaItemSinistro == castOther.sequenciaItemSinistro);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codigoRamo;
		hash = hash * prime + this.anoSinistro;
		hash = hash * prime + this.numeroSinistro;
		hash = hash * prime + this.sequenciaItemSinistro;
		
		return hash;
	}
}