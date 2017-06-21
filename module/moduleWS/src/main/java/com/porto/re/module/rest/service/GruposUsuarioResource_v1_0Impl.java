/******************************************************************************* 
 * Copyright (c) 2014-2014, 2015 Porto Seguro Seguros S.A., Inc. All Rights Reserved.
 * 
 * Este software contém informações confidenciais e de propriedade da Porto Seguro Seguros S.A. 
 * ("Informações Confidenciais"). 
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

package com.porto.re.module.rest.service;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.portoseguro.ramoselementares.admin.grupousuarioresource.v1_0.GruposUsuarioResource;
import br.com.portoseguro.ramoselementares.admin.grupousuarioebo.v1.GrupoUsuarioEBO;

import com.porto.re.exception.BusinessUncheckedException;
import com.porto.re.module.entity.GrupoUsuario;
import com.porto.re.module.facade.GrupoUsuarioFacade;
import com.porto.re.module.type.converter.GrupoUsuarioTypeConverter;

import com.porto.re.exception.IntegrationException;
import com.porto.re.exception.EnvironmentException;

/**
 * Recurso de representa grupos de usuario.
 * 
 * @author alessandro.g.romero
 * 
 */
public class GruposUsuarioResource_v1_0Impl implements GruposUsuarioResource {

	/**
	 * SKIP default.
	 */
	private static final int SKIP = 0;

	/**
	 * TOP default.
	 */
	private static final int TOP = 199;

	/**
	 * Chave mensagem.
	 */
	private static final String MODULE_GRUPO_USUARIO_CONFLICTS = "module.grupoUsuario.conflicts";

	/**
	 * Mensagem excecao.
	 */
	private static final String IDENTIFICACAO_CONFLITANTE = "IDENTIFICACAO CONFLITANTE";

	/**
	 * Injetado pelo provider para ajudar a construcao de URI.
	 */
	@Context
	private transient UriInfo uriInfo;

	/**
	 * Fachada EJB.
	 */
	@Inject
	private transient GrupoUsuarioFacade grupoUsuarioFacade;

	/**
	 * Conversor.
	 */
	@Inject
	private transient GrupoUsuarioTypeConverter grupoUsuarioTypeConverter;

	// INTERFACE
	@Override
	public Response find(final Long skip,
			final Long top, final String campos, final String nomeGrupoUsuario) {
		List<GrupoUsuario> gruposUsuario;

		int skipI = SKIP, topI = TOP;
		if (skip != null){
			skipI = skip.intValue();
		}
		if (top != null){
			topI = top.intValue();
		}
		
		if (nomeGrupoUsuario == null) {
			gruposUsuario = grupoUsuarioFacade.list(skipI, topI);
		} else {
			gruposUsuario = grupoUsuarioFacade
					.findByNomeGrupoUsuarioContaining(nomeGrupoUsuario);
			// FIXME
			if (top <= gruposUsuario.size()) {
				gruposUsuario = gruposUsuario.subList(skipI, topI);
			}
		}

		List<GrupoUsuarioEBO> grupoUsuariosType;
		if (campos == null) {
			grupoUsuariosType = grupoUsuarioTypeConverter
					.convertToType(gruposUsuario);
		} else {
			final String[] arrayCampos = campos.split(",");
			grupoUsuariosType = grupoUsuarioTypeConverter.convertToType(
					gruposUsuario, arrayCampos);
		}

		return Response.ok().entity(grupoUsuariosType).build();
	}

	@Override
	public Response create(final GrupoUsuarioEBO grupousuarioebo) {
		final UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		URI userUri;

		final GrupoUsuario grupoUsuario = grupoUsuarioFacade
				.create(grupoUsuarioTypeConverter
						.convertToEntity(grupousuarioebo));

		final GrupoUsuarioEBO grupoUsuarioTypeToRet = grupoUsuarioTypeConverter
				.convertToType(grupoUsuario);

		userUri = uriBuilder
				.path(grupoUsuarioTypeToRet.getCodigoGrupoUsuario()).build();

		return Response.ok(userUri).entity(grupoUsuarioTypeToRet).build();
	}

	@Override
	public Response findById(final String primaryKey) {
		// este metodo foi alterado para mostrar uma chamada a um servico na camada de negocio
		//final GrupoUsuario grupoUsuario = grupoUsuarioFacade.find(primaryKey);
		GrupoUsuario grupoUsuario = null; 
		try {
			grupoUsuario = grupoUsuarioFacade.findByWebService(primaryKey);
		} catch (IntegrationException ie) {
			// o tratamento de excecao empregado utiliza uma unchecked exception
			// pois o contrato foi gerado automaticamente
			throw new EnvironmentException(ie);
		}
		
		Response response;
		if (grupoUsuario == null) {
			response = Response.status(Response.Status.NOT_FOUND).build();
		} else {
			response = Response
					.ok()
					.entity(grupoUsuarioTypeConverter
							.convertToType(grupoUsuario)).build();
		}
		return response;
	}

	@Override
	public Response remove(final String primaryKey) {
		grupoUsuarioFacade.delete(primaryKey);
		return Response.ok().build();
	}

	@Override
	public Response update(final String primaryKey,
			final GrupoUsuarioEBO grupousuarioebo) {
		if (!primaryKey.equals(grupousuarioebo.getCodigoGrupoUsuario())) {
			throw new BusinessUncheckedException(IDENTIFICACAO_CONFLITANTE,
					MODULE_GRUPO_USUARIO_CONFLICTS);
		}

		final GrupoUsuario grupoUsuario = grupoUsuarioFacade
				.update(grupoUsuarioTypeConverter
						.convertToEntity(grupousuarioebo));

		return Response.ok()
				.entity(grupoUsuarioTypeConverter.convertToType(grupoUsuario))
				.build();
	}

}