package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the gcakfilial database table.
 * 
 */
@Embeddable
public class FilialCorretorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="corsuspcp")
	private int susepPrincipalCorretor;

	@Column(name="corfilnum")
	private String numFilial;

	public FilialCorretorPK() {
	}
	public int getSusepPrincipalCorretor() {
		return this.susepPrincipalCorretor;
	}
	public void setSusepPrincipalCorretor(int susepPrincipalCorretor) {
		this.susepPrincipalCorretor = susepPrincipalCorretor;
	}
	public String getNumFilial() {
		return this.numFilial;
	}
	public void setNumFilial(String numFilial) {
		this.numFilial = numFilial;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FilialCorretorPK)) {
			return false;
		}
		FilialCorretorPK castOther = (FilialCorretorPK)other;
		return 
			(this.susepPrincipalCorretor == castOther.susepPrincipalCorretor)
			&& this.numFilial.equals(castOther.numFilial);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.susepPrincipalCorretor;
		hash = hash * prime + this.numFilial.hashCode();
		
		return hash;
	}
}