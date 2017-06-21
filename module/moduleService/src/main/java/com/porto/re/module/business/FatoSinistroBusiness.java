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

package com.porto.re.module.business;

import javax.inject.Inject;
import javax.inject.Named;

import com.porto.re.module.business.interfaces.IFatoSinistroBusiness;
import com.porto.re.module.dao.SinistroDAO;
import com.porto.re.module.entity.Sinistro;

/**
 * Implementacao da interface de negocio para FatoSinistroBusiness. 
 * 
 * @author bruno.miller
 *
 */
@Named
public class FatoSinistroBusiness implements IFatoSinistroBusiness {

	/**
	 * Grupo usuario DAO.
	 */
	@Inject
	private transient SinistroDAO sinistroDAO;
		
	@Override
	public Sinistro recuperarFatoSinistro(String codigoRamo, String anoSinistro, String numeroSinistro,
			String sequenciaItemSinistro) {

		Sinistro sinistro = sinistroDAO.findByNumeroSinistro(codigoRamo, anoSinistro, numeroSinistro);
		
		return sinistro;
	}

}