package com.porto.re.module.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ssamsin database table.
 * 
 */
@Entity
@Table(name="ssamsin")
@NamedQueries({
@NamedQuery(name=Sinistro.FIND_ALL, query="SELECT s FROM Sinistro s"),
@NamedQuery(name=Sinistro.FIND_BY_NUMERO_SINISTRO, 
	query="SELECT s FROM Sinistro s WHERE s.id.codigoRamo = :codigoRamo AND s.id.anoSinistro = :anoSinistro AND s.id.numeroSinistro = :numeroSinistro ")})
public class Sinistro implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Query que retorna todos os registros.
	 */
	public final static String FIND_ALL = "Sinistro.findAll";
	/**
	 * Query para buscar pelo Nome.
	 */
	public final static String FIND_BY_NUMERO_SINISTRO = "Sinistro.findByNumeroSinistro";

	@EmbeddedId
	private SinistroPK id;

	@Column(name="aplnumdig")
	private String numeroDigitoApolice;

	@Column(name="edsnumref")
	private String numeroReferenciaEndosso;

	@Column(name="empcod")
	private String codigoEmpresa;

	@Column(name="itmnumdig")
	private String numeroDigitoItem;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="orrdat")
	private Date dataOcorrencia;

	@Column(name="sinvstano")
	private String anoVistoriaSinistro;

	@Column(name="sinvstnum")
	private String numeroVistoriaSinistro;

	@Column(name="subcod")
	private String codigoSub;

	@Column(name="succod")
	private String codigoSucursal;

	public Sinistro() {
	}

	public SinistroPK getId() {
		return this.id;
	}

	public void setId(SinistroPK id) {
		this.id = id;
	}

	public String getNumeroDigitoApolice() {
		return this.numeroDigitoApolice;
	}

	public void setNumeroDigitoApolice(String numeroDigitoApolice) {
		this.numeroDigitoApolice = numeroDigitoApolice;
	}

	public String getNumeroReferenciaEndosso() {
		return this.numeroReferenciaEndosso;
	}

	public void setNumeroReferenciaEndosso(String numeroReferenciaEndosso) {
		this.numeroReferenciaEndosso = numeroReferenciaEndosso;
	}

	public String getCodigoEmpresa() {
		return this.codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getNumeroDigitoItem() {
		return this.numeroDigitoItem;
	}

	public void setNumeroDigitoItem(String numeroDigitoItem) {
		this.numeroDigitoItem = numeroDigitoItem;
	}

	public Date getDataOcorrencia() {
		return this.dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public String getAnoVistoriaSinistro() {
		return this.anoVistoriaSinistro;
	}

	public void setAnoVistoriaSinistro(String anoVistoriaSinistro) {
		this.anoVistoriaSinistro = anoVistoriaSinistro;
	}

	public String getNumeroVistoriaSinistro() {
		return this.numeroVistoriaSinistro;
	}

	public void setNumeroVistoriaSinistro(String numeroVistoriaSinistro) {
		this.numeroVistoriaSinistro = numeroVistoriaSinistro;
	}

	public String getCodigoSub() {
		return this.codigoSub;
	}

	public void setCodigoSub(String codigoSub) {
		this.codigoSub = codigoSub;
	}

	public String getCodigoSucursal() {
		return this.codigoSucursal;
	}

	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

}