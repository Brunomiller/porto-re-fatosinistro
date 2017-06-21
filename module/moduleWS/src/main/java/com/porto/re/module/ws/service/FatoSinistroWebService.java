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

package com.porto.re.module.ws.service;

import javax.inject.Inject;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.porto.re.exception.PortoFaultException;
import com.porto.re.module.entity.Sinistro;
import com.porto.re.module.facade.FatoSinistroFacade;

/**
 * Web service que expoe o recurso grupo de usuario.
 * 
 * @author bruno.miller
 *
 */
@WebService(
		serviceName="FatoSinistroWebService",
		portName="FatoSinistroWebServicePort",
		targetNamespace="http://fatosinistrowebservice.portoseguro.com.br"  
  )
@HandlerChain(file = "/re-errorhandling/handler-chain.xml")
public class FatoSinistroWebService {
	
	public FatoSinistroWebService(){
		
	}
	/**
	 * Fachada EJB.
	 */
	@Inject
	private transient FatoSinistroFacade fatoSinistroFacade;

	@WebMethod
	public Sinistro procurar(String codigoRamo, String anoSinistro, String numeroSinistro, String sequenciaItemSinistro)
			throws PortoFaultException {

		Sinistro sinistro = fatoSinistroFacade.recuperarFatoSinistro(codigoRamo, anoSinistro, numeroSinistro, sequenciaItemSinistro);
		return sinistro;
	}

}
