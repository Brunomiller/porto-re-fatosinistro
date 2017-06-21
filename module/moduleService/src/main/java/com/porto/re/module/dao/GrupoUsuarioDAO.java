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

package com.porto.re.module.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.porto.re.exception.BusinessUncheckedException;
import com.porto.re.module.business.database.ReModuleProviderDatabase;
import com.porto.re.module.entity.GrupoUsuario;
import com.porto.re.persistence.AbstractGenericCrud;
import com.porto.re.persistence.PagedEntity;
import com.porto.re.persistence.QueryParameter;
import com.porto.re.security.bean.ISubject;

/**
 * Implementacao do DAO para grupos de usuario.
 * 
 * @author alessandro.g.romero
 *
 */
@Named
public class GrupoUsuarioDAO extends AbstractGenericCrud<GrupoUsuario, String> {

	/**
	 * Chave mensagem.
	 */
	private static final String MODULE_GRUPO_USUARIO_NOT_FOUND = "module.grupoUsuario.notFound";
	/**
	 * Mensagem excecao.
	 */
	private static final String NAO_ENCONTRADO = "NAO ENCONTRADO";
	/**
	 * Usuario logado.
	 */
	@Inject
	private transient ISubject subjectBean;
	
	@Inject
	@Override
	@ReModuleProviderDatabase
	protected void setEntityManager(final EntityManager entityManager) {
		setEntityManagerProtected(entityManager);
	}

	/**
	 * Recupera grupo de usuario por nome.
	 * 
	 * @param nomeGrupoUsuario nome do grupo de usuario (suporta like)
	 * @return lista de grupos de usuario
	 */
	public List<GrupoUsuario> findByNomeGrupoUsuarioContaining(
			final String nomeGrupoUsuario) {
		return findWithNamedQuery(
				GrupoUsuario.FIND_BY_NOME_GRUPO_USUARIO_CONTAINING,
				QueryParameter.with("nomeGrupoUsuario",
						nomeGrupoUsuario).parameters());
	}

	/**
	 * Atualiza um grupo de usuario.
	 * 
	 * @param grupoUsuario grupo de usuario
	 * @return grupo de usuario atualizado
	 */
	public GrupoUsuario update(final GrupoUsuario grupoUsuario) {
		GrupoUsuario reference = this.getEntityManager().find(GrupoUsuario.class,
				grupoUsuario.getCodigoGrupoUsuario());

		if (reference == null) {
			throw new BusinessUncheckedException(NAO_ENCONTRADO,
					MODULE_GRUPO_USUARIO_NOT_FOUND);
		} else {
			grupoUsuario.setCodigoTipoUsuarioUltimaAlteracao(subjectBean.getUserType());
			grupoUsuario.setCodigoEmpresaUsuarioUltimaAlteracao(subjectBean.getEmployer());
			grupoUsuario.setCodigoMatriculaUsuarioUltimaAlteracao(subjectBean.getUserId());
			grupoUsuario.setDataUltimaAtualizacao(new Date());
			reference = this.getEntityManager().merge(grupoUsuario);
		}

		return reference;
	}

	/**
	 * Lista grupo de usuarios.
	 * 
	 * @param skip registro inicial
	 * @param top numero de registros
	 * @return lista paginada
	 */
	public PagedEntity<GrupoUsuario> list(final Integer skip, final Integer top) {
		return listWithNamedQuery(GrupoUsuario.FIND_ALL, skip, top);
	}
	
	@Override
	public GrupoUsuario create(final GrupoUsuario type) {
		type.setCodigoTipoUsuarioUltimaAlteracao(subjectBean.getUserType());
		type.setCodigoEmpresaUsuarioUltimaAlteracao(subjectBean.getEmployer());
		type.setCodigoMatriculaUsuarioUltimaAlteracao(subjectBean.getUserId());
		type.setDataUltimaAtualizacao(new Date());
		return super.create(type);
	}

}
