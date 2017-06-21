package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ssammvto database table.
 * 
 */
@Entity
@Table(name="ssammvto")
@NamedQuery(name="MovimentacaoValorSinistro.findAll", query="SELECT m FROM MovimentacaoValorSinistro m")
public class MovimentacaoValorSinistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MovimentacaoValorSinistroPK id;

	@Column(name="sinmvtcod")
	private String codigoMovimentoSinistro;

	@Column(name="sinmvtvlr")
	private BigDecimal valorMovimentoSinistro;

	public MovimentacaoValorSinistro() {
	}

	public MovimentacaoValorSinistroPK getId() {
		return this.id;
	}

	public void setId(MovimentacaoValorSinistroPK id) {
		this.id = id;
	}

	public String getCodigoMovimentoSinistro() {
		return this.codigoMovimentoSinistro;
	}

	public void setCodigoMovimentoSinistro(String codigoMovimentoSinistro) {
		this.codigoMovimentoSinistro = codigoMovimentoSinistro;
	}

	public BigDecimal getValorMovimentoSinistro() {
		return this.valorMovimentoSinistro;
	}

	public void setValorMovimentoSinistro(BigDecimal valorMovimentoSinistro) {
		this.valorMovimentoSinistro = valorMovimentoSinistro;
	}

}