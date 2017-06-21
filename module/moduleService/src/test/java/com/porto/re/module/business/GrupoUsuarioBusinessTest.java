package com.porto.re.module.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.porto.re.module.dao.GrupoUsuarioDAO;
import com.porto.re.module.entity.GrupoUsuario;

@RunWith(MockitoJUnitRunner.class)
public class GrupoUsuarioBusinessTest {

	@InjectMocks
	GrupoUsuarioBusiness grupoUsuarioBusiness;

	@Mock
	GrupoUsuarioDAO grupoUsuarioDAO;

	@Test
	public void testFindByNomeGrupoUsuarioContaining() {

		List<GrupoUsuario> grupoUsuarioL = new ArrayList<GrupoUsuario>();
		grupoUsuarioL.add(new GrupoUsuario());

		when(grupoUsuarioDAO.findByNomeGrupoUsuarioContaining("teste"))
				.thenReturn(grupoUsuarioL);

		List<GrupoUsuario> l2 = grupoUsuarioBusiness
				.findByNomeGrupoUsuarioContaining("teste");
		assertEquals(grupoUsuarioL, l2);

		verify(grupoUsuarioDAO, Mockito.times(1))
				.findByNomeGrupoUsuarioContaining("teste");
	}

}
