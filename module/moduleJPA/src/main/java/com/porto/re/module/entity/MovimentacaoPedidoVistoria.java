package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rgdmsinis database table.
 * 
 */
@Entity
@Table(name="rgdmsinis")
@NamedQuery(name="MovimentacaoPedidoVistoria.findAll", query="SELECT m FROM MovimentacaoPedidoVistoria m")
public class MovimentacaoPedidoVistoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MovimentacaoPedidoVistoriaPK id;

	@Column(name="prpnumdig")
	private int numeroDigitoProposta;

	@Column(name="prporg")
	private int orgProposta;

	public MovimentacaoPedidoVistoria() {
	}

	public MovimentacaoPedidoVistoriaPK getId() {
		return this.id;
	}

	public void setId(MovimentacaoPedidoVistoriaPK id) {
		this.id = id;
	}

	public int getNumeroDigitoProposta() {
		return this.numeroDigitoProposta;
	}

	public void setNumeroDigitoProposta(int numeroDigitoProposta) {
		this.numeroDigitoProposta = numeroDigitoProposta;
	}

	public int getOrgProposta() {
		return this.orgProposta;
	}

	public void setOrgProposta(int orgProposta) {
		this.orgProposta = orgProposta;
	}

}