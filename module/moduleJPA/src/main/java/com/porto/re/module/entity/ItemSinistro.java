package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ssamitem database table.
 * 
 */
@Entity
@Table(name="ssamitem")
@NamedQuery(name="ItemSinistro.findAll", query="SELECT i FROM ItemSinistro i")
public class ItemSinistro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemSinistroPK id;

	@Column(name="acsfrqvlr")
	private BigDecimal valorFranquiaAcessorios;

	@Column(name="acsvlr")
	private BigDecimal valorAcessorios;

	@Column(name="apvajtvlr")
	private BigDecimal valorAjusteAprovado;

	@Column(name="apvtotvlr")
	private BigDecimal valorTotalAprovado;

	@Column(name="avrtotvlr")
	private BigDecimal valorTotalAvaria;

	@Column(name="frqvlr")
	private BigDecimal valorFranquia;

	@Column(name="jrdsinflg")
	private String flagSinistroJuridico;

	@Column(name="sinntzcod")
	private String codigoNaturezaSinistro;

	@Column(name="terceslcrvlr")
	private BigDecimal valorLucroCessanteTerceiro;

	public ItemSinistro() {
	}

	public ItemSinistroPK getId() {
		return this.id;
	}

	public void setId(ItemSinistroPK id) {
		this.id = id;
	}

	public BigDecimal getValorFranquiaAcessorios() {
		return this.valorFranquiaAcessorios;
	}

	public void setValorFranquiaAcessorios(BigDecimal valorFranquiaAcessorios) {
		this.valorFranquiaAcessorios = valorFranquiaAcessorios;
	}

	public BigDecimal getValorAcessorios() {
		return this.valorAcessorios;
	}

	public void setValorAcessorios(BigDecimal valorAcessorios) {
		this.valorAcessorios = valorAcessorios;
	}

	public BigDecimal getValorAjusteAprovado() {
		return this.valorAjusteAprovado;
	}

	public void setValorAjusteAprovado(BigDecimal valorAjusteAprovado) {
		this.valorAjusteAprovado = valorAjusteAprovado;
	}

	public BigDecimal getValorTotalAprovado() {
		return this.valorTotalAprovado;
	}

	public void setValorTotalAprovado(BigDecimal valorTotalAprovado) {
		this.valorTotalAprovado = valorTotalAprovado;
	}

	public BigDecimal getValorTotalAvaria() {
		return this.valorTotalAvaria;
	}

	public void setValorTotalAvaria(BigDecimal valorTotalAvaria) {
		this.valorTotalAvaria = valorTotalAvaria;
	}

	public BigDecimal getValorFranquia() {
		return this.valorFranquia;
	}

	public void setValorFranquia(BigDecimal valorFranquia) {
		this.valorFranquia = valorFranquia;
	}

	public String getFlagSinistroJuridico() {
		return this.flagSinistroJuridico;
	}

	public void setFlagSinistroJuridico(String flagSinistroJuridico) {
		this.flagSinistroJuridico = flagSinistroJuridico;
	}

	public String getCodigoNaturezaSinistro() {
		return this.codigoNaturezaSinistro;
	}

	public void setCodigoNaturezaSinistro(String codigoNaturezaSinistro) {
		this.codigoNaturezaSinistro = codigoNaturezaSinistro;
	}

	public BigDecimal getValorLucroCessanteTerceiro() {
		return this.valorLucroCessanteTerceiro;
	}

	public void setValorLucroCessanteTerceiro(BigDecimal valorLucroCessanteTerceiro) {
		this.valorLucroCessanteTerceiro = valorLucroCessanteTerceiro;
	}

}