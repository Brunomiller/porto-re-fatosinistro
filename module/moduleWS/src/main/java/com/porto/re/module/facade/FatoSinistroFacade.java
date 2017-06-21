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

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.porto.re.contextaware.application.annotations.BusinessContextChosen;
import com.porto.re.module.business.interfaces.IFatoSinistroBusiness;
import com.porto.re.module.entity.Sinistro;


/**
 * EJB de Fachada usado para garantir transacao.
 * 
 * @author bruno.miller
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class FatoSinistroFacade {
	
	/**
	 * Chave mensagem.
	 */
	private static final String MODULE_GRUPO_USUARIO_NOT_FOUND = "module.sinistro.notFound";
	/**
	 * Mensagem excecao.
	 */
	private static final String NAO_ENCONTRADO = "NAO ENCONTRADO";
	/**
	 * Business que prove a gestao de grupos de usuario.
	 */
	@Inject
	@BusinessContextChosen(IFatoSinistroBusiness.class)
	private transient IFatoSinistroBusiness fatoSinistroBusiness;
	
	
	/**
	 * Procura um grupo de usuario mediante a primary key.
	 * 
	 * @param primaryKey primary key
	 * @return grupo de usuario
	 */
	public Sinistro recuperarFatoSinistro(String codigoRamo, String anoSinistro, String numeroSinistro, String sequenciaItemSinistro) {
		return fatoSinistroBusiness.recuperarFatoSinistro(codigoRamo, anoSinistro, numeroSinistro, sequenciaItemSinistro);
	}

}
