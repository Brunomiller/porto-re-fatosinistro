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
 * Autor(Author)        : alessandro.g.romero@accenture.com
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

package com.porto.re.module.business.interfaces;

import java.util.List;

import com.porto.re.module.entity.GrupoUsuario;

import com.porto.re.exception.IntegrationException;

/**
 * Interface de negocio para gesta de grupos de usuario.
 * 
 * @author alessandro.g.romero
 *
 */
public interface IGrupoUsuarioBusiness {

	/**
	 * Recupera grupo de usuario for nome.
	 * 
	 * @param nomeGrupoUsuario
	 *            Nome do grupo do Usuario.
	 * 
	 * @return lista de grupos de usuarios
	 */
	List<GrupoUsuario> findByNomeGrupoUsuarioContaining(String nomeGrupoUsuario);

	/**
	 * Cria grupo de usuario.
	 * 
	 * @param grupoUsuario
	 *            Grupo de usuario.
	 * @return grupo de usuario
	 */
	GrupoUsuario create(GrupoUsuario grupoUsuario);

	/**
	 * Remove grupo de usuario.
	 * 
	 * @param primaryKey
	 *            primary key
	 */
	void delete(String primaryKey);

	/**
	 * Recupera pela chave primaria.
	 * 
	 * @param primaryKey
	 *            primary key
	 * @return grupo de usuario
	 */
	GrupoUsuario find(String primaryKey);

	/**
	 * Atualiza grupo de usuario.
	 * 
	 * @param grupoUsuario
	 *            grupo de usuario
	 * @return o grupo de usuario
	 */
	GrupoUsuario update(GrupoUsuario grupoUsuario);

	/**
	 * Lista os grupos de usuario.
	 * 
	 * @param skip
	 *            registro inicial
	 * @param top
	 *            numero maximo de registros
	 * @return lista com grupos de usuario
	 */
	List<GrupoUsuario> list(Integer skip, Integer top);

	/**
	 * Recupera pela chave primaria atraves de uma chamada ao WebService.
	 * Nota IMPORTANTE: definido apenas para mostrar como deve funcionar 
	 * uma chamada a um webservice a partir da camada de negocio.
	 * 
	 * Nota IMPORTANTE: nao e esperado que metodos de negocio lancem
	 * IntegrationException, eles devem trata-la.
	 * 
	 * @param primaryKey
	 *            primary key
	 * @return grupo de usuario
	 * @throws IntegrationException excecao de integracao
	 */
	GrupoUsuario findByWebService(String primaryKey) throws IntegrationException;
}
