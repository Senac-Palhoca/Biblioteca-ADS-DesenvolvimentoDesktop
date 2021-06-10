package br.com.dao;

import br.com.model.Curso;
import br.com.model.Turma;
import br.com.util.UtilGerador;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.hibernate.*;

/**
 *
 * @author Felipe.Stahlhofer
 */
public class TurmaDaoImplTest {

    private Turma turma;
    private TurmaDao turmaDao;
    private Session sessao;
    private Curso curso;
    private CursoDao cursoDao;

    public TurmaDaoImplTest() {
        turmaDao = new TurmaDaoImpl();
    }

    @Test
    public void testSalvar() {
        CursoDaoImplTest cursoDaoImplTest = new CursoDaoImplTest();
        curso = cursoDaoImplTest.buscarCursoBd();
        turma = new Turma();
        turma.setNome("turma" + UtilGerador.gerarNome());
        turma.setFase("" + UtilGerador.criarNumeroEntre2Valores(0, 6));
        turma.setAno("2021");
        turma.setPeriodo("Noturno");
        turma.setCurso(curso);
        sessao = HibernateUtil.abrirConexao();
        turmaDao.salvarOuAlterar(turma, sessao);
        sessao.close();
        assertNotNull(turma.getId());
    }

//@Test
    public void testAlterar() {
        buscarTurmaBd();
        sessao = HibernateUtil.abrirConexao();
        turma.setNome("Turma do Xuxu");
        turmaDao.salvarOuAlterar(turma, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Turma turmaPesquisada = turmaDao.pesquisarPorId(turma.getId(), sessao);
        sessao.close();
        assertEquals(turmaPesquisada.getNome(), turma.getNome());
    }

    @Test
    public void testPesquisarPorId() {
        buscarTurmaBd();
        sessao = HibernateUtil.abrirConexao();
        Turma turmaId = turmaDao.pesquisarPorId(turma.getId(), sessao);
        sessao.close();
        assertNotNull(turmaId);
    }

    @Test
    public void testPesquisarPorNome() {
        buscarTurmaBd();
        sessao = HibernateUtil.abrirConexao();
        List<Turma> turmas = turmaDao.pesquisarPorNome(turma.getNome().substring(1, 3), sessao);
        sessao.close();
        assertFalse(turmas.isEmpty());
    }

    @Test
    public void testListarTodos() {
        buscarTurmaBd();
        sessao = HibernateUtil.abrirConexao();
        List<Turma> turmas = turmaDao.listarTodos(sessao);
        sessao.close();
        boolean isEmpty = turmas.isEmpty();
        assertFalse(isEmpty);
    }

    @Test
    public void testExcluir() {
        System.out.println("Test Excluir não deve ser executado");
    }

    public Turma buscarTurmaBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Turma");
        List<Turma> turmas = consulta.list();
        sessao.close();
        if (turmas.isEmpty()) {
            testSalvar();
        } else {
            turma = turmas.get(UtilGerador.criarNumeroEntre2Valores(-1, turmas.size()));
        }
        return turma;

    }
}
