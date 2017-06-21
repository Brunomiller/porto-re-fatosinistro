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

package com.porto.re.module.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import com.porto.re.contextaware.application.annotations.BusinessContextChosen;
import com.porto.re.exception.BusinessUncheckedException;
import com.porto.re.exception.IntegrationException;
import com.porto.re.module.business.interfaces.IGrupoUsuarioBusiness;
import com.porto.re.module.business.interfaces.IGrupoUsuarioBusiness2;
import com.porto.re.module.entity.GrupoUsuario;


/**
 * EJB de Fachada usado para garantir transacao.
 * 
 * @author alessandro.g.romero
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class GrupoUsuarioFacade {
	
	/**
	 * Chave mensagem.
	 */
	private static final String MODULE_GRUPO_USUARIO_NOT_FOUND = "module.grupoUsuario.notFound";
	/**
	 * Mensagem excecao.
	 */
	private static final String NAO_ENCONTRADO = "NAO ENCONTRADO";
	/**
	 * Business que prove a gestao de grupos de usuario.
	 */
	@Inject
	@BusinessContextChosen(IGrupoUsuarioBusiness.class)
	private transient IGrupoUsuarioBusiness grupoUsuarioBusiness;

	/**
	 * Business que prove a gestao de grupos de usuario.
	 */
	@Inject
	@BusinessContextChosen(IGrupoUsuarioBusiness2.class)
	private transient IGrupoUsuarioBusiness2 grupoUsuarioBusiness2;
	
	/**
	 * Recupera grupos de usuario baseado no nome.
	 * 
	 * @param nomeGrupoUsuario grupos de usuario
	 * @return lista de grupos de usuario
	 */
	public List<GrupoUsuario> findByNomeGrupoUsuarioContaining(
			final String nomeGrupoUsuario) {
		return grupoUsuarioBusiness
				.findByNomeGrupoUsuarioContaining(nomeGrupoUsuario);
	}

	/**
	 * Cria um grupo de usuario.
	 * 
	 * @param grupoUsuario grupo de usuario
	 * @return grupo de usuario atualizado
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GrupoUsuario create(final GrupoUsuario grupoUsuario) {
		return grupoUsuarioBusiness.create(grupoUsuario);
	}

	/**
	 * Remove um grupo de usuario.
	 * 
	 * @param primaryKey primary key
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(final String primaryKey) {
		try {
			grupoUsuarioBusiness.delete(primaryKey);
		} catch (EntityNotFoundException exception) {
			throw new BusinessUncheckedException(NAO_ENCONTRADO, exception,
					MODULE_GRUPO_USUARIO_NOT_FOUND, null);
		}
	}

	/**
	 * Procura um grupo de usuario mediante a primary key.
	 * 
	 * @param primaryKey primary key
	 * @return grupo de usuario
	 */
	public GrupoUsuario find(final String primaryKey) {
		return grupoUsuarioBusiness.find(primaryKey);
	}

	/**
	 * Atualiza um grupo de usuario.
	 * 
	 * @param grupoUsuario grupo de usuario
	 * @return grupo de usuario atualizado
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GrupoUsuario update(final GrupoUsuario grupoUsuario) {
		return grupoUsuarioBusiness.update(grupoUsuario);
	}

	/**
	 * Lista grupos de usuario.
	 * 
	 * @param skip registro inicial
	 * @param top numero de registros
	 * @return lista de grupos
	 */
	public List<GrupoUsuario> list(final Integer skip, final Integer top) {
		return grupoUsuarioBusiness.list(skip, top);
	}

	/**
	 * Procura um grupo de usuario mediante a primary key.
	 * 
	 * @param primaryKey primary key
	 * @return grupo de usuario
	 * @throws IntegrationException excecao de integracao
	 */
	public GrupoUsuario findByWebService(final String primaryKey) throws IntegrationException {
		return grupoUsuarioBusiness.findByWebService(primaryKey);
	}
}
