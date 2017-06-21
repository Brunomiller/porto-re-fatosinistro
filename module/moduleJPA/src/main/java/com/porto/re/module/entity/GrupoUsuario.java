/******************************************************************************* 
 * Copyright (c) 2014-2014, 2015 Porto Seguro Seguros S.A., Inc. All Rights Reserved.
 * 
 * Este software contém informações confidenciais e de propriedade da Porto Seguro Seguros S.A. ("Informações Confidenciais"). 
 * Você não deve divulgar qualquer tipo de informações confidenciais e deve usá-las apenas, de acordo com os termos do 
 * contrato de licença firmado com a Porto Seguro. 
 * 
 * A Porto Seguro não faz declarações ou garantias sobre a adequação do software, expressa ou implicitamente, incluindo, 
 * mas não se limitando, a garantias de comercialização, adequação para um determinado fim ou qualquer tipo de violação. 
 * 
 * A PORTO SEGURO NÃO SERÁ RESPONSÁVEL POR QUAISQUER DANOS SOFRIDOS PELO LICENCIADO EM DECORRÊNCIA DO USO, MODIFICAÇÃO 
 * OU DISTRIBUIÇÃO DESTE SOFTWARE OU SEUS DERIVADOS. 
 * 
 * 
 * Criado em(Created on): 08/06/2015 
 * Autor(Author)        : rafael.silva@accenture.com
 * 
 * ----------------------------------------------------------------------------- 
 * Histórico da Revisão (Revision History) - Release 1.0.0 
 * ----------------------------------------------------------------------------- 
 *  VERSÃO      DATA           AUTOR                DESCRIÇÃO DA MUDANÇA 
 * (VERSION)   (DATE)         (AUTHOR)             (DESCRIPTION OF CHANGE) 
 * ----------------------------------------------------------------------------- 
 * 1.0.0   | DD/MM/YYYY |                    | Criação Inicial (Initial Create) 
 * --------|------------|--------------------|---------------------------------- 
 *******************************************************************************/

package com.porto.re.module.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
/**
 * Entidade Grupo de Usuario.
 * 
 * @author rafael.silva
 *
 */
@SuppressWarnings({"PMD.TooManyFields","PMD.TooManyMethods"})
@Entity
@Table(name="REIKUSRGRP")
@NamedQueries({
@NamedQuery(name=GrupoUsuario.FIND_ALL, query="SELECT g FROM GrupoUsuario g"),
@NamedQuery(name=GrupoUsuario.FIND_BY_NOME_GRUPO_USUARIO_CONTAINING, 
	query="SELECT g FROM GrupoUsuario g WHERE nomeGrupoUsuario like CONCAT('%',:nomeGrupoUsuario,'%')")})
public class GrupoUsuario implements Serializable {
	/**
	 * Versao.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Query que retorna todos os registros.
	 */
	public final static String FIND_ALL = "GrupoUsuario.findAll";
	/**
	 * Query para buscar pelo Nome.
	 */
	public final static String FIND_BY_NOME_GRUPO_USUARIO_CONTAINING = "GrupoUsuario.findByNomeGrupoUsuarioContaining";
	
	/**
	 * Codigo Grupo Usuario.
	 */
	@Id
	@Column(name="USRGRPCOD", unique=true, nullable=false)
	private String codigoGrupoUsuario;

	/**
	 * Data Ultima Atualizacao.
	 * Usado TemporatlType.TIMESTAMP para armazenar DATA e HORA.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ALTULTDAT", nullable=false)
	private Date dataUltimaAtualizacao;

	/**
	 * Codigo Empresa Usuario Ultima Alteracao.
	 */
	@Column(name="ALTULTUSREMPCOD", nullable=false, length=2)
	private String codigoEmpresaUsuarioUltimaAlteracao;

	/**
	 * Codigo Matricula Usuario Ultima Alteracao.
	 */
	@Column(name="ALTULTUSRMATCOD", nullable=false, length=6)
	private String codigoMatriculaUsuarioUltimaAlteracao;

	/**
	 * Codigo Tipo Usuario Ultima Alteracao.
	 */
	@Column(name="ALTULTUSRTIPCOD", nullable=false, length=1)
	private String codigoTipoUsuarioUltimaAlteracao;

	/**
	 * Flag Ativo.
	 */
	@Column(name="ATOFLG", nullable=false, length=1)
	private String flagAtivo;

	/**
	 * Nome Grupo Usuario.
	 */
	@Column(name="USRGRPNOM", nullable=false, length=100)
	private String nomeGrupoUsuario;

	/**
	 * retorna Codigo grupo usuario.
	 * 
	 * @return String
	 */
	public String getCodigoGrupoUsuario() {
		return this.codigoGrupoUsuario;
	}

	/**
	 * atribui Codigo grupo usuario.
	 * 
	 * @param codigoGrupoUsuario Codigo grupo usuario  
	 */
	public void setCodigoGrupoUsuario(final String codigoGrupoUsuario) {
		this.codigoGrupoUsuario = codigoGrupoUsuario;
	}

	/**
	 * retorna Data ultima atualizacao.
	 * 
	 * @return Date
	 */
	public Date getDataUltimaAtualizacao() {
		Date dataUltimaAtualizacao = null;
		if (this.dataUltimaAtualizacao != null) {
			dataUltimaAtualizacao = (Date) this.dataUltimaAtualizacao.clone();
		}
		return dataUltimaAtualizacao;
	}

	/**
	 * atribui Data ultima atualizacao.
	 * 
	 * @param dataUltimaAtualizacao Data ultima atualizacao
	 */
	@SuppressWarnings("PMD.NullAssignment")
	public void setDataUltimaAtualizacao(final Date dataUltimaAtualizacao) {
		if (dataUltimaAtualizacao == null) {
			this.dataUltimaAtualizacao = null;
		} else {
			this.dataUltimaAtualizacao = (Date) dataUltimaAtualizacao.clone();	
		}		
		
	}

	/**
	 * retorna Codigo empresa usuario ultima alteracao. 
	 * 
	 * @return String
	 */
	public String getCodigoEmpresaUsuarioUltimaAlteracao() {
		return this.codigoEmpresaUsuarioUltimaAlteracao;
	}

	/**
	 * atribui codigo Empresa Usuario Ultima Alteracao.
	 * 
	 * @param codigoEmpresaUsuarioUltimaAlteracao codigo Empresa Usuario Ultima Alteracao
	 */
	public void setCodigoEmpresaUsuarioUltimaAlteracao(final String codigoEmpresaUsuarioUltimaAlteracao) {
		this.codigoEmpresaUsuarioUltimaAlteracao = codigoEmpresaUsuarioUltimaAlteracao;
	}

	/**
	 * retorna codigo Matricula Usuario Ultima Alteracao.
	 * 
	 * @return String
	 */
	public String getCodigoMatriculaUsuarioUltimaAlteracao() {
		return this.codigoMatriculaUsuarioUltimaAlteracao;
	}

	/**
	 * atribui codigo Matricula Usuario Ultima Alteracao.
	 * 
	 * @param codigoMatriculaUsuarioUltimaAlteracao codigo Matricula Usuario Ultima Alteracao
	 */
	public void setCodigoMatriculaUsuarioUltimaAlteracao(final String codigoMatriculaUsuarioUltimaAlteracao) {
		this.codigoMatriculaUsuarioUltimaAlteracao = codigoMatriculaUsuarioUltimaAlteracao;
	}

	/**
	 * retorna codigo Tipo Usuario Ultima Alteracao.
	 * 
	 * @return String
	 */
	public String getCodigoTipoUsuarioUltimaAlteracao() {
		return this.codigoTipoUsuarioUltimaAlteracao;
	}

	/**
	 * atribui codigo Tipo Usuario Ultima Alteracao.
	 * 
	 * @param codigoTipoUsuarioUltimaAlteracao codigo Tipo Usuario Ultima Alteracao
	 */
	public void setCodigoTipoUsuarioUltimaAlteracao(final String codigoTipoUsuarioUltimaAlteracao) {
		this.codigoTipoUsuarioUltimaAlteracao = codigoTipoUsuarioUltimaAlteracao;
	}

	/**
	 * retorna Flag Ativo.
	 * 
	 * @return String
	 */
	public String getFlagAtivo() {
		return this.flagAtivo;
	}

	/**
	 * atribui Flag Ativo.
	 * 
	 * @param flagAtivo Flag Ativo
	 */
	public void setFlagAtivo(final String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	/**
	 * retorna Nome Grupo Usuario.
	 * 
	 * @return String
	 */
	public String getNomeGrupoUsuario() {
		return this.nomeGrupoUsuario;
	}

	/**
	 * atribui Nome Grupo Usuario.
	 * 
	 * @param nomeGrupoUsuario Nome Grupo Usuario
	 */
	public void setNomeGrupoUsuario(final String nomeGrupoUsuario) {
		this.nomeGrupoUsuario = nomeGrupoUsuario;
	}

	@SuppressWarnings({"PMD.AvoidFinalLocalVariable","checkstyle:avoidinlineconditionals"})
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codigoGrupoUsuario == null) ? 0 : codigoGrupoUsuario
						.hashCode());
		return result;
	}

	@SuppressWarnings({ 
		   "PMD.IfStmtsMustUseBraces", 
		   "PMD.OnlyOneReturn", 
		   "PMD.MethodArgumentCouldBeFinal", 
		   "PMD.CyclomaticComplexity",
		   "PMD.LocalVariableCouldBeFinal",
		   "checkstyle:cyclomaticcomplexity",
		   "checkstyle:finalparameters", 
		   "checkstyle:needbraces" }) 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoUsuario other = (GrupoUsuario) obj;
		if (codigoGrupoUsuario == null) {
			if (other.codigoGrupoUsuario != null)
				return false;
		} else if (!codigoGrupoUsuario.equals(other.codigoGrupoUsuario))
			return false;
		return true;
	}

}