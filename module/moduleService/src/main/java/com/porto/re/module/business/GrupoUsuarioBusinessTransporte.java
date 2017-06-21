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

import java.util.List;

import javax.inject.Inject;

import com.porto.re.module.business.interfaces.IGrupoUsuarioBusiness;
import com.porto.re.module.dao.GrupoUsuarioDAO;
import com.porto.re.module.entity.GrupoUsuario;

import javax.xml.ws.WebServiceRef;
import javax.jws.HandlerChain;

import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.GrupoUsuarioWebService;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.ProcurarGrupoUsuarioRequest;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.ProcurarGrupoUsuarioResponse;

import com.porto.re.contextaware.application.annotations.TransportesLogic;
import com.porto.re.exception.PortoFaultException;

import br.com.portoseguro.ramoselementares.admin.grupousuarioebo.v1.GrupoUsuarioEBO; 

import com.porto.re.exception.IntegrationException;

/**
 * Implementacao da interface de negocio para GrupoUsuarioBusiness. 
 * 
 * @author alessandro.g.romero
 *
 */
@TransportesLogic
public class GrupoUsuarioBusinessTransporte implements IGrupoUsuarioBusiness {

	/**
	 * Grupo usuario DAO.
	 */
	@Inject
	private transient GrupoUsuarioDAO grupoUsuarioDAO;

	/**
	 * WebService Cliente.
	 */
	@HandlerChain(file = "/re-contextaware/handler-chain.xml")
	@WebServiceRef
	private transient GrupoUsuarioWebService grupoUsuarioWebService;
		
	@Override
	public List<GrupoUsuario> findByNomeGrupoUsuarioContaining(
			final String nomeGrupoUsuario) {
		return grupoUsuarioDAO
				.findByNomeGrupoUsuarioContaining(nomeGrupoUsuario);
	}

	@Override
	public GrupoUsuario create(final GrupoUsuario grupoUsuario) {
		return grupoUsuarioDAO.create(grupoUsuario);
	}

	@Override
	public void delete(final String primaryKey) {
		grupoUsuarioDAO.delete(GrupoUsuario.class, primaryKey);
	}

	@Override
	public GrupoUsuario find(final String primaryKey) {
		GrupoUsuario grupoUsuario = grupoUsuarioDAO.find(GrupoUsuario.class, primaryKey);
		grupoUsuario.setNomeGrupoUsuario("Grupo 1 (TRANSPORTE)");
		return grupoUsuario;
	}

	@Override
	public GrupoUsuario update(final GrupoUsuario grupoUsuario) {
		return grupoUsuarioDAO.update(grupoUsuario);
	}

	@Override
	public List<GrupoUsuario> list(final Integer skip, final Integer top) {
		final List<GrupoUsuario> listGU = grupoUsuarioDAO.list(skip, top)
				.getResults();

		return listGU;
	}

	@Override
	public GrupoUsuario findByWebService(final String primaryKey) throws IntegrationException {
		GrupoUsuario toRet = null;
		try {
			final ProcurarGrupoUsuarioRequest request = new ProcurarGrupoUsuarioRequest();
			request.setCodigoGrupoUsuario(primaryKey);
			final ProcurarGrupoUsuarioResponse response = 
					grupoUsuarioWebService.getGrupoUsuarioWebServicePort().procurar(request);
			if (response.getListaGruposUsuarioEBO().getGrupoUsuarioEBO().size() == 1){
				toRet = convertToEntity(response.getListaGruposUsuarioEBO().getGrupoUsuarioEBO().get(0));
			}
		} catch (PortoFaultException pfe){
			//checked exception
			throw new IntegrationException(pfe);
		} catch(javax.xml.ws.WebServiceException wfe){
			//uncheckedexception -- connect exception, not found 404, etc...
			throw new IntegrationException(wfe);
		}
		return toRet;
	}

	/**
	 * WebService Cliente.
	 * Apenas necessario devido ao retorno em um CRUD. 
	 * Nas situacoes reais estes conversores nao devem ser comuns.
	 * 
	 * @param grupoUsuarioType grupo usuario do WebService
	 * @return grupo usuario - entidade - detached
	 */
	private GrupoUsuario convertToEntity(final GrupoUsuarioEBO grupoUsuarioType) {
		final GrupoUsuario grupoUsuario = new GrupoUsuario();
		grupoUsuario.setCodigoGrupoUsuario(grupoUsuarioType
				.getCodigoGrupoUsuario());
		grupoUsuario
				.setNomeGrupoUsuario(grupoUsuarioType.getNomeGrupoUsuario());
		grupoUsuario.setFlagAtivo(grupoUsuarioType.getFlagAtivo());
		if (grupoUsuarioType.getDataUltimaAtualizacao() != null) {
			grupoUsuario
					.setDataUltimaAtualizacao(grupoUsuarioType
							.getDataUltimaAtualizacao().toGregorianCalendar()
							.getTime());
		}
		grupoUsuario.setCodigoTipoUsuarioUltimaAlteracao(grupoUsuarioType
				.getCodigoTipoUsuarioUltimaAlteracao());
		grupoUsuario.setCodigoEmpresaUsuarioUltimaAlteracao(grupoUsuarioType
				.getCodigoEmpresaUsuarioUltimaAlteracao());
		grupoUsuario.setCodigoMatriculaUsuarioUltimaAlteracao(grupoUsuarioType
				.getCodigoMatriculaUsuarioUltimaAlteracao());
		return grupoUsuario;
	}

}
