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

import java.util.List;

import javax.inject.Inject;
import javax.jws.HandlerChain;
import javax.jws.WebService;

import br.com.portoseguro.ramoselementares.admin.grupousuarioebo.v1.ListaGruposUsuarioEBO;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.AtualizarGrupoUsuarioRequest;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.AtualizarGrupoUsuarioResponse;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.CriarGrupoUsuarioRequest;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.CriarGrupoUsuarioResponse;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.GruposUsuarioWebServicePortType;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.ListarGrupoUsuarioRequest;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.ListarGrupoUsuarioResponse;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.ProcurarGrupoUsuarioPorNomeGrupoUsuarioContendoRequest;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.ProcurarGrupoUsuarioPorNomeGrupoUsuarioContendoResponse;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.ProcurarGrupoUsuarioRequest;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.ProcurarGrupoUsuarioResponse;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.RemoverGrupoUsuarioRequest;
import br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.RemoverGrupoUsuarioResponse;

import com.porto.re.exception.PortoFaultException;
import com.porto.re.module.facade.GrupoUsuarioFacade;
import com.porto.re.module.type.converter.GrupoUsuarioTypeConverter;
import com.porto.re.module.entity.GrupoUsuario;

/**
 * Web service que expoe o recurso grupo de usuario.
 * 
 * @author alessandro.g.romero
 *
 */
@WebService(
  endpointInterface = "br.com.portoseguro.ramoselementares.admin.grupousuarioservice.v1_0.GruposUsuarioWebServicePortType")
@HandlerChain(file = "/re-errorhandling/handler-chain.xml")
public class GruposUsuarioWebService_v1_0Impl implements
		GruposUsuarioWebServicePortType {

	/**
	 * Fachada EJB.
	 */
	@Inject
	private transient GrupoUsuarioFacade grupoUsuarioFacade;

	/**
	 * Conversor de grupo.
	 */
	@Inject
	private transient GrupoUsuarioTypeConverter grupoUsuarioTypeConverter;

	@Override
	public CriarGrupoUsuarioResponse criar(
			final CriarGrupoUsuarioRequest parameters)
			throws PortoFaultException {
		final GrupoUsuario grupoUsuario = grupoUsuarioFacade
				.create(grupoUsuarioTypeConverter.convertToEntity(parameters
						.getGrupoUsuarioEBO()));

		final CriarGrupoUsuarioResponse resp = new CriarGrupoUsuarioResponse();
		resp.setGrupoUsuarioEBO(grupoUsuarioTypeConverter
				.convertToType(grupoUsuario));
		return resp;
	}

	@Override
	public RemoverGrupoUsuarioResponse remover(
			final RemoverGrupoUsuarioRequest parameters)
			throws PortoFaultException {
		grupoUsuarioFacade.delete(parameters.getCodigoGrupoUsuario());
		return new RemoverGrupoUsuarioResponse();
	}

	@Override
	public ProcurarGrupoUsuarioResponse procurar(
			final ProcurarGrupoUsuarioRequest parameters)
			throws PortoFaultException {
		final GrupoUsuario grupoUsuario = grupoUsuarioFacade.find(parameters
				.getCodigoGrupoUsuario());

		final ListaGruposUsuarioEBO toRet = new ListaGruposUsuarioEBO();
		if (grupoUsuario != null) {
			toRet.getGrupoUsuarioEBO().add(
					grupoUsuarioTypeConverter.convertToType(grupoUsuario));
		}

		final ProcurarGrupoUsuarioResponse resp = new ProcurarGrupoUsuarioResponse();
		resp.setListaGruposUsuarioEBO(toRet);
		return resp;
	}

	@Override
	public ListarGrupoUsuarioResponse listar(
			final ListarGrupoUsuarioRequest parameters)
			throws PortoFaultException {
		final List<GrupoUsuario> paged = grupoUsuarioFacade.list(
				parameters.getSkip().intValue(), parameters.getTop().intValue());

		final ListaGruposUsuarioEBO toRet = new ListaGruposUsuarioEBO();
		toRet.getGrupoUsuarioEBO().addAll(
				grupoUsuarioTypeConverter.convertToType(paged));

		final ListarGrupoUsuarioResponse resp = new ListarGrupoUsuarioResponse();
		resp.setListaGruposUsuarioEBO(toRet);
		return resp;
	}

	@Override
	public AtualizarGrupoUsuarioResponse atualizar(
			final AtualizarGrupoUsuarioRequest parameters)
			throws PortoFaultException {
		final GrupoUsuario grupoUsuario = grupoUsuarioFacade
				.update(grupoUsuarioTypeConverter.convertToEntity(parameters
						.getGrupoUsuarioEBO()));
		final AtualizarGrupoUsuarioResponse resp = new AtualizarGrupoUsuarioResponse();
		resp.setGrupoUsuarioEBO(grupoUsuarioTypeConverter
				.convertToType(grupoUsuario));

		return resp;
	}

	@Override
	public ProcurarGrupoUsuarioPorNomeGrupoUsuarioContendoResponse procurarPorNomeGrupoUsuarioContendo(
			final ProcurarGrupoUsuarioPorNomeGrupoUsuarioContendoRequest parameters)
			throws PortoFaultException {
		final List<GrupoUsuario> gruposUsuario = grupoUsuarioFacade
				.findByNomeGrupoUsuarioContaining(parameters
						.getNomeGrupoUsuario());

		final ListaGruposUsuarioEBO toRet = new ListaGruposUsuarioEBO();
		toRet.getGrupoUsuarioEBO().addAll(
				grupoUsuarioTypeConverter.convertToType(gruposUsuario));

		final ProcurarGrupoUsuarioPorNomeGrupoUsuarioContendoResponse resp = 
				new ProcurarGrupoUsuarioPorNomeGrupoUsuarioContendoResponse();
		resp.setListaGruposUsuarioEBO(toRet);
		return resp;
	}
}
