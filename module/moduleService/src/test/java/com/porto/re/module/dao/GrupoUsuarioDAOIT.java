package com.porto.re.module.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.GregorianCalendar;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.porto.re.module.entity.GrupoUsuario;
import com.sun.xml.ws.api.tx.at.Transactional;
import com.sun.xml.ws.api.tx.at.Transactional.TransactionFlowType;

@RunWith(Arquillian.class)
@Transactional(value = TransactionFlowType.SUPPORTS)
public class GrupoUsuarioDAOIT {

	@Deployment
	public static Archive<?> createDeployment() {
		Archive<?> jar = ShrinkWrap
				.create(WebArchive.class, "test2.war")
				.addPackages(true, "com.porto.re.module")
				.addPackages(true, "com.porto.re.contextaware.application")
				.addPackages(true, "com.porto.re.contextaware.messagerepository")
				.addPackages(true, "com.porto.re.contextaware.bean")
				.addClass("com.porto.re.security.bean.ISubject")
				.addClass("com.porto.re.security.bean.SubjectMockBean")
				.addAsResource("META-INF/persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource("META-INF/beans.xml",
						ArchivePaths.create("beans.xml"));
		jar.as(ZipExporter.class).exportTo(new File("target/test2.war"), true);
		return jar;
	}

	@Inject
	private UserTransaction userTransaction;

	@Inject
	private GrupoUsuarioDAO grupoUsuarioDAO;

	@InSequence(1)
	@Test
	public void setup() throws NotSupportedException, SystemException,
			SecurityException, IllegalStateException, RollbackException,
			HeuristicMixedException, HeuristicRollbackException {

		assertTrue(grupoUsuarioDAO != null);

		GrupoUsuario gu = new GrupoUsuario();

		gu.setCodigoGrupoUsuario("T01");
		gu.setNomeGrupoUsuario("Teste 01");
		gu.setFlagAtivo("S");
		gu.setCodigoTipoUsuarioUltimaAlteracao("F");
		gu.setCodigoEmpresaUsuarioUltimaAlteracao("01");
		gu.setCodigoMatriculaUsuarioUltimaAlteracao("5678");
		gu.setDataUltimaAtualizacao(GregorianCalendar.getInstance().getTime());

		userTransaction.begin();
		grupoUsuarioDAO.create(gu);
		userTransaction.commit();
	}

	@InSequence(2)
	@Test
	public void testCrudCreate() throws NotSupportedException, SystemException,
			RollbackException, HeuristicMixedException,
			HeuristicRollbackException {
		userTransaction.begin();
		// SEVERE: The persistence-context-ref-name
		// [com.porto.re.persistence.GenericCrudIT/persistenceContext] in module
		// [test] resolves to a persistence unit called [pu-innovare] which is
		// of type RESOURCE_LOCAL. Only persistence units with transaction type
		// JTA can be used as a container managed entity manager. Please verify
		// your application.
		// persistenceContext.getTransaction().begin();

		GrupoUsuario gu = new GrupoUsuario();

		gu.setCodigoGrupoUsuario("T02");
		gu.setNomeGrupoUsuario("Teste 02");
		gu.setFlagAtivo("S");
		gu.setCodigoTipoUsuarioUltimaAlteracao("F");
		gu.setCodigoEmpresaUsuarioUltimaAlteracao("01");
		gu.setCodigoMatriculaUsuarioUltimaAlteracao("1234");
		gu.setDataUltimaAtualizacao(GregorianCalendar.getInstance().getTime());

		grupoUsuarioDAO.create(gu);

		assertTrue(true);
		// persistenceContext.getTransaction().commit();
		userTransaction.commit();

	}

	@InSequence(3)
	@Test
	public void testCrudFind() {
		GrupoUsuario gu = grupoUsuarioDAO.find(GrupoUsuario.class, "T01");
		assertTrue(gu != null);
	}

	@InSequence(4)
	@Test
	public void testUpdate() throws NotSupportedException, SystemException,
			SecurityException, IllegalStateException, RollbackException,
			HeuristicMixedException, HeuristicRollbackException {
		GrupoUsuario gu = grupoUsuarioDAO.find(GrupoUsuario.class, "T01");
		gu.setNomeGrupoUsuario("Teste 01-2");
		userTransaction.begin();
		GrupoUsuario updated = grupoUsuarioDAO.update(gu);
		userTransaction.commit();
		assertEquals("Teste 01-2", updated.getNomeGrupoUsuario());
	}

	@InSequence(5)
	@Test
	public void testDelete() throws NotSupportedException, SystemException,
			SecurityException, IllegalStateException, RollbackException,
			HeuristicMixedException, HeuristicRollbackException {
		userTransaction.begin();
		grupoUsuarioDAO.delete(GrupoUsuario.class, "T01");
		userTransaction.commit();
	}

	@InSequence(6)
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNotFound() throws NotSupportedException,
			SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException,
			HeuristicRollbackException {
		userTransaction.begin();
		grupoUsuarioDAO.delete(GrupoUsuario.class, "T03");
		userTransaction.commit();
	}

}
