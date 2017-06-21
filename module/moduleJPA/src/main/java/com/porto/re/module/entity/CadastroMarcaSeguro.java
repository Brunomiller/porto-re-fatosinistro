package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the agbksgrmrc database table.
 * 
 */
@Entity
@Table(name="agbksgrmrc")
@NamedQuery(name="CadastroMarcaSeguro.findAll", query="SELECT c FROM CadastroMarcaSeguro c")
public class CadastroMarcaSeguro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sgrmrccod", insertable=false, updatable=false)
	private int codigoMarca;

	@Column(name="sgrmrcnom", insertable=false, updatable=false)
	private String nomeMarca;

	public CadastroMarcaSeguro() {
	}

	public int getCodigoMarca() {
		return this.codigoMarca;
	}

	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getNomeMarca() {
		return this.nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

}