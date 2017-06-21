package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the gtakram database table.
 * 
 */
@Embeddable
public class RamoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="empcod")
	private int codigoEmpresa;

	@Column(name="ramcod")
	private int codigoRamo;

	public RamoPK() {
	}
	public int getCodigoEmpresa() {
		return this.codigoEmpresa;
	}
	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	public int getCodigoRamo() {
		return this.codigoRamo;
	}
	public void setCodigoRamo(int codigoRamo) {
		this.codigoRamo = codigoRamo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RamoPK)) {
			return false;
		}
		RamoPK castOther = (RamoPK)other;
		return 
			(this.codigoEmpresa == castOther.codigoEmpresa)
			&& (this.codigoRamo == castOther.codigoRamo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codigoEmpresa;
		hash = hash * prime + this.codigoRamo;
		
		return hash;
	}
}