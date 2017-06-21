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

import java.util.List;

/**
 * Interface de conversao.
 * 
 * @author alessandro.g.romero
 *
 * @param <TypeClass>
 *            tipo a ser convertido
 * @param <EntityClass>
 *            entidade a ser convertida
 */
public interface ITypeConverter<TypeClass, EntityClass> {
	/**
	 * Converte a partir da entidade.
	 * 
	 * @param entityClass
	 *            classe da entidade
	 * @return tipo
	 */
	TypeClass convertToType(EntityClass entityClass);

	/**
	 * Converte para entidade.
	 * 
	 * @param typeClass
	 *            tipo da entidade
	 * @return entidade
	 */
	EntityClass convertToEntity(TypeClass typeClass);

	/**
	 * Conversao de listas.
	 * 
	 * @param entityClasses entidade
	 * @return tipo
	 */
	List<TypeClass> convertToType(List<EntityClass> entityClasses);

	/**
	 * Conversao de listas.
	 * 
	 * @param typeClasses tipo
	 * @return entidade
	 */
	List<EntityClass> convertToEntity(List<TypeClass> typeClasses);

	/**
	 * Entidade para lista de tipos. 
	 * 
	 * @param entityClass entidade
	 * @param campos lista
	 * @return tipo
	 */
	TypeClass convertToType(EntityClass entityClass, String[] campos);

	/**
	 * Entidade para lista de tipos.
	 * 
	 * @param entityClasses entidade
	 * @param campos campos
	 * @return tipo
	 */
	List<TypeClass> convertToType(List<EntityClass> entityClasses,
			String[] campos);
}
