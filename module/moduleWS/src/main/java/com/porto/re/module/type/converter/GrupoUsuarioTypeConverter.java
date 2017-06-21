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

package com.porto.re.module.type.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Named;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import br.com.portoseguro.ramoselementares.admin.grupousuarioebo.v1.GrupoUsuarioEBO;

import com.porto.re.exception.EnvironmentException;
import com.porto.re.module.entity.GrupoUsuario;

/**
 * Conversor para grupo de usuario.
 * 
 * @author alessandro.g.romero
 *
 */
@Named
public class GrupoUsuarioTypeConverter implements
		ITypeConverter<GrupoUsuarioEBO, GrupoUsuario> {

	// fields
	/**
	 * codigo.
	 */
	public static final String CODIGO_GRUPO_USUARIO = "codigoGrupoUsuario";
	/**
	 * data.
	 */
	public static final String DATA_ULTIMA_ATUALIZACAO = "dataUltimaAtualizacao";
	/**
	 * codigo empresa.
	 */
	public static final String CODIGO_EMPRESA_USUARIO_ULTIMA_ATUALIZACAO = "codigoEmpresaUsuarioUltimaAlteracao";
	/**
	 * codigo matricula.
	 */
	public static final String CODIGO_MATRICULA_USUARIO_ULTIMA_ATUALIZACAO = "codigoMatriculaUsuarioUltimaAlteracao";
	/**
	 * codigo tipo.
	 */
	public static final String CODIGO_TIPO_USUARIO_ULTIMA_ATUALIZACAO = "codigoTipoUsuarioUltimaAlteracao";
	/**
	 * flag de ativacao.
	 */
	public static final String FLAG_ATIVO = "flagAtivo";
	/**
	 * nome grupo usuario.
	 */
	public static final String NOME_GRUPO_USUARIO = "nomeGrupoUsuario";

	@Override
	public GrupoUsuarioEBO convertToType(final GrupoUsuario grupoUsuario) {
		final GrupoUsuarioEBO grupoUsuarioType = new GrupoUsuarioEBO();
		grupoUsuarioType.setCodigoGrupoUsuario(grupoUsuario
				.getCodigoGrupoUsuario());
		grupoUsuarioType
				.setNomeGrupoUsuario(grupoUsuario.getNomeGrupoUsuario());
		grupoUsuarioType.setFlagAtivo(grupoUsuario.getFlagAtivo());
		try {
			final GregorianCalendar gregory = new GregorianCalendar();
			gregory.setTime(grupoUsuario.getDataUltimaAtualizacao());
			grupoUsuarioType.setDataUltimaAtualizacao(DatatypeFactory
					.newInstance().newXMLGregorianCalendar(gregory));
		} catch (DatatypeConfigurationException dce) {
			throw new EnvironmentException(dce);
		}
		grupoUsuarioType.setCodigoTipoUsuarioUltimaAlteracao(grupoUsuario
				.getCodigoTipoUsuarioUltimaAlteracao());
		grupoUsuarioType.setCodigoEmpresaUsuarioUltimaAlteracao(grupoUsuario
				.getCodigoEmpresaUsuarioUltimaAlteracao());
		grupoUsuarioType.setCodigoMatriculaUsuarioUltimaAlteracao(grupoUsuario
				.getCodigoMatriculaUsuarioUltimaAlteracao());
		return grupoUsuarioType;
	}

	@Override
	public GrupoUsuario convertToEntity(final GrupoUsuarioEBO grupoUsuarioType) {
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

	@Override
	public List<GrupoUsuarioEBO> convertToType(
			final List<GrupoUsuario> gruposUsuario) {
		final List<GrupoUsuarioEBO> gruposUsuarioType = new ArrayList<GrupoUsuarioEBO>();
		for (final GrupoUsuario grupoUsuario : gruposUsuario) {
			gruposUsuarioType.add(convertToType(grupoUsuario));
		}
		return gruposUsuarioType;
	}

	@Override
	public List<GrupoUsuario> convertToEntity(
			final List<GrupoUsuarioEBO> gruposUsuarioType) {
		final List<GrupoUsuario> gruposUsuario = new ArrayList<GrupoUsuario>();
		for (final GrupoUsuarioEBO grupoUsuario : gruposUsuarioType) {
			gruposUsuario.add(convertToEntity(grupoUsuario));
		}
		return gruposUsuario;
	}

	@Override
	public GrupoUsuarioEBO convertToType(final GrupoUsuario grupoUsuario,
			final String[] campos) {
		final GrupoUsuarioEBO grupoUsuarioType = new GrupoUsuarioEBO();
		final List<String> camposList = Arrays.asList(campos);
		if (camposList.contains(CODIGO_GRUPO_USUARIO)) {
			grupoUsuarioType.setCodigoGrupoUsuario(grupoUsuario
					.getCodigoGrupoUsuario());
		}
		if (camposList.contains(NOME_GRUPO_USUARIO)) {
			grupoUsuarioType.setNomeGrupoUsuario(grupoUsuario
					.getNomeGrupoUsuario());
		}
		if (camposList.contains(FLAG_ATIVO)) {
			grupoUsuarioType.setFlagAtivo(grupoUsuario.getFlagAtivo());
		}
		if (camposList.contains(DATA_ULTIMA_ATUALIZACAO)) {
			try {
				final GregorianCalendar gregory = new GregorianCalendar();
				gregory.setTime(grupoUsuario.getDataUltimaAtualizacao());
				grupoUsuarioType.setDataUltimaAtualizacao(DatatypeFactory
						.newInstance().newXMLGregorianCalendar(gregory));
			} catch (DatatypeConfigurationException dce) {
				throw new EnvironmentException(dce);
			}
		}
		if (camposList.contains(CODIGO_TIPO_USUARIO_ULTIMA_ATUALIZACAO)) {
			grupoUsuarioType.setCodigoTipoUsuarioUltimaAlteracao(grupoUsuario
					.getCodigoTipoUsuarioUltimaAlteracao());
		}
		if (camposList.contains(CODIGO_EMPRESA_USUARIO_ULTIMA_ATUALIZACAO)) {
			grupoUsuarioType
					.setCodigoEmpresaUsuarioUltimaAlteracao(grupoUsuario
							.getCodigoEmpresaUsuarioUltimaAlteracao());
		}
		if (camposList.contains(CODIGO_MATRICULA_USUARIO_ULTIMA_ATUALIZACAO)) {
			grupoUsuarioType
					.setCodigoMatriculaUsuarioUltimaAlteracao(grupoUsuario
							.getCodigoMatriculaUsuarioUltimaAlteracao());
		}
		return grupoUsuarioType;
	}

	@Override
	public List<GrupoUsuarioEBO> convertToType(
			final List<GrupoUsuario> gruposUsuario, final String[] campos) {
		final List<GrupoUsuarioEBO> gruposUsuarioType = new ArrayList<GrupoUsuarioEBO>();
		for (final GrupoUsuario grupoUsuario : gruposUsuario) {
			gruposUsuarioType.add(convertToType(grupoUsuario, campos));
		}
		return gruposUsuarioType;
	}

}
