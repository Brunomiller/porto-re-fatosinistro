package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the sinmcbt database table.
 * 
 */
@Entity
@Table(name="sinmcbt")
@NamedQuery(name="CoberturaSinistro.findAll", query="SELECT c FROM CoberturaSinistro c")
public class CoberturaSinistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CoberturaSinistroPK id;

	@Column(name="sincbtetmvlr")
	private BigDecimal valorEstimadoCoberturaSinistro;

	public CoberturaSinistro() {
	}

	public CoberturaSinistroPK getId() {
		return this.id;
	}

	public void setId(CoberturaSinistroPK id) {
		this.id = id;
	}

	public BigDecimal getValorEstimadoCoberturaSinistro() {
		return this.valorEstimadoCoberturaSinistro;
	}

	public void setValorEstimadoCoberturaSinistro(BigDecimal valorEstimadoCoberturaSinistro) {
		this.valorEstimadoCoberturaSinistro = valorEstimadoCoberturaSinistro;
	}

}