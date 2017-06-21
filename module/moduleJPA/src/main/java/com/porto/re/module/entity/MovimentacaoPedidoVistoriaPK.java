package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rgdmsinis database table.
 * 
 */
@Embeddable
public class MovimentacaoPedidoVistoriaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="sinvstano")
	private int anoVistoriaSinistro;

	@Column(name="sinvstnum")
	private int numeroVistoriaSinistro;

	public MovimentacaoPedidoVistoriaPK() {
	}
	public int getAnoVistoriaSinistro() {
		return this.anoVistoriaSinistro;
	}
	public void setAnoVistoriaSinistro(int anoVistoriaSinistro) {
		this.anoVistoriaSinistro = anoVistoriaSinistro;
	}
	public int getNumeroVistoriaSinistro() {
		return this.numeroVistoriaSinistro;
	}
	public void setNumeroVistoriaSinistro(int numeroVistoriaSinistro) {
		this.numeroVistoriaSinistro = numeroVistoriaSinistro;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MovimentacaoPedidoVistoriaPK)) {
			return false;
		}
		MovimentacaoPedidoVistoriaPK castOther = (MovimentacaoPedidoVistoriaPK)other;
		return 
			(this.anoVistoriaSinistro == castOther.anoVistoriaSinistro)
			&& (this.numeroVistoriaSinistro == castOther.numeroVistoriaSinistro);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.anoVistoriaSinistro;
		hash = hash * prime + this.numeroVistoriaSinistro;
		
		return hash;
	}
}