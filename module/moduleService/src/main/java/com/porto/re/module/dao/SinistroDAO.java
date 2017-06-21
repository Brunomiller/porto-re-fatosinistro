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

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.porto.re.exception.BusinessUncheckedException;
import com.porto.re.module.business.database.ReModuleProviderDatabase;
import com.porto.re.module.entity.Sinistro;
import com.porto.re.module.entity.SinistroPK;
import com.porto.re.persistence.AbstractGenericCrud;
import com.porto.re.security.bean.ISubject;

/**
 * Implementacao do DAO para grupos de usuario.
 * 
 * @author bruno.miller
 *
 */
@Named
public class SinistroDAO extends AbstractGenericCrud<Sinistro, String> {

	/**
	 * Chave mensagem.
	 */
	private static final String MODULE_SINISTRO_NOT_FOUND = "module.sinistro.notFound";
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
	 * Recupera sinistro por ramo, ano e numero.
	 * @param codigoRamo Ramo do sinistro
	 * @param anoSinistro Ano do sinistro
	 * @param numeroSinistro numero do sinistro
	 * @return sinistro encontrado
	 */
	public Sinistro findByNumeroSinistro(
			final String codigoRamo, final String anoSinistro, final String numeroSinistro) {
		
		SinistroPK pk = new SinistroPK();
		pk.setCodigoRamo(Integer.parseInt(codigoRamo));
		pk.setAnoSinistro(Integer.parseInt(anoSinistro));
		pk.setNumeroSinistro(Integer.parseInt(numeroSinistro));
		
		Sinistro sinistro = this.getEntityManager().find(Sinistro.class, pk);

		if (sinistro == null) {
			throw new BusinessUncheckedException(NAO_ENCONTRADO,
					MODULE_SINISTRO_NOT_FOUND);
		} else {
			return sinistro;
		}


		/*
		return findWithNamedQuery(Sinistro.FIND_BY_NUMERO_SINISTRO,
				QueryParameter
					.with("codigoRamo", codigoRamo)
					.and("anoSinistro", anoSinistro)
					.and("numeroSinistro", numeroSinistro)
					.parameters()).;
					*/
	}
	
}
