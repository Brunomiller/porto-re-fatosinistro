package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gtakram database table.
 * 
 */
@Entity
@Table(name="gtakram")
@NamedQuery(name="Ramo.findAll", query="SELECT r FROM Ramo r")
public class Ramo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RamoPK id;

	@Column(name="ramgrpcod")
	private String codigoGrupoRamo;

	public Ramo() {
	}

	public RamoPK getId() {
		return this.id;
	}

	public void setId(RamoPK id) {
		this.id = id;
	}

	public String getCodigoGrupoRamo() {
		return this.codigoGrupoRamo;
	}

	public void setCodigoGrupoRamo(String codigoGrupoRamo) {
		this.codigoGrupoRamo = codigoGrupoRamo;
	}

}