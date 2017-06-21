package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the svimsin database table.
 * 
 */
@Entity
@NamedQuery(name="Svimsin.findAll", query="SELECT s FROM Svimsin s")
public class Svimsin implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SvimsinPK id;

	@Column(name="aplnumdig")
	private int numeroDigitoApolice;

	@Column(name="succod")
	private int codigoSucursal;

	public Svimsin() {
	}

	public SvimsinPK getId() {
		return this.id;
	}

	public void setId(SvimsinPK id) {
		this.id = id;
	}

	public int getNumeroDigitoApolice() {
		return this.numeroDigitoApolice;
	}

	public void setNumeroDigitoApolice(int numeroDigitoApolice) {
		this.numeroDigitoApolice = numeroDigitoApolice;
	}

	public int getCodigoSucursal() {
		return this.codigoSucursal;
	}

	public void setCodigoSucursal(int codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

}