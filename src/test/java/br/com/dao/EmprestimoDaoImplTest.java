/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Aluno;
import br.com.model.Emprestimo;
import br.com.model.Exemplar;
import br.com.model.Turma;
import br.com.util.UtilGerador;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.hibernate.*;

/**
 * @author Felipe
 */
public class EmprestimoDaoImplTest {

    private Emprestimo emprestimo;
    private EmprestimoDao emprestimoDao;
    private Session sessao;
    private List<Emprestimo> emprestimos;

    public EmprestimoDaoImplTest() {
        emprestimoDao = new EmprestimoDaoImpl();
    }

//    @Test
    public void testSalvar() {

        emprestimo = new Emprestimo(null, new Date(), new Date(), null);
        AlunoDaoImplTest alunoDao = new AlunoDaoImplTest();
        emprestimo.setAluno(alunoDao.gerarAlunoBd());

        ExemplarDaoImplTest exemplarDao = new ExemplarDaoImplTest();
        emprestimo.setExemplar(exemplarDao.gerarExemplarBd());

        sessao = HibernateUtil.abrirConexao();
        emprestimoDao.salvarOuAlterar(emprestimo, sessao);
        sessao.close();
        assertNotNull(emprestimo.getId());
    }

    //@Test
    public void testAlterar() {
        gerarEmprestimoBd();
        sessao = HibernateUtil.abrirConexao();
        Emprestimo emprestimoId = emprestimoDao.pesquisarPorId(emprestimo.getId(), sessao);
        sessao.close();
        assertNotNull(emprestimoId);
    }

    // @Test
    public void testPesquisarPorId() {
        gerarEmprestimoBd();
        sessao = HibernateUtil.abrirConexao();
        Emprestimo emprestimoId = emprestimoDao.pesquisarPorId(emprestimo.getId(), sessao);
        sessao.close();
        assertNotNull(emprestimoId);
    }

//    @Test
//    public void testPesquisarPorNome() {
//        gerarEmprestimoBd();
//        sessao = HibernateUtil.abrirConexao();
//        List<Emprestimo> emprestimos = emprestimoDao.pesquisarPorNome(emprestimo.getNome().substring(1, 3), sessao);
//        sessao.close();
//        assertFalse(emprestimos.isEmpty());
//    }
    //@Test
    public void testListarTodos() {
        gerarEmprestimoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Emprestimo> emprestimos = emprestimoDao.listarTodos(sessao);
        sessao.close();
        boolean isEmpty = emprestimos.isEmpty();
        assertFalse(isEmpty);
    }

    //@Test
    public void testExcluir() {
        gerarEmprestimoBd();
        sessao = HibernateUtil.abrirConexao();
        emprestimoDao.excluir(emprestimo, sessao);
        Emprestimo emprestimoExc = emprestimoDao.pesquisarPorId(emprestimo.getId(), sessao);
        sessao.close();
        assertNull(emprestimoExc);
    }

    public Emprestimo gerarEmprestimoBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Emprestimo");
        emprestimos = consulta.list();
        sessao.close();
        if (emprestimos.isEmpty()) {
            testSalvar();
        } else {
            emprestimo = emprestimos.get(0);
        }
        return emprestimo;
    }

//    @Test
    public void testPesquisarPorAlunoAberto() {
        System.out.println("pesquisarPorAlunoAberto");
        AlunoDaoImplTest alunoDao = new AlunoDaoImplTest();
        Aluno aluno = alunoDao.gerarAlunoBd();

        sessao = HibernateUtil.abrirConexao();
        emprestimos = emprestimoDao.pesquisarPorAlunoAberto(aluno, sessao);
        sessao.close();

        assertTrue(!emprestimos.isEmpty());
    }

//    @Test
    public void testPesquisarPorTurmaMes() {
        System.out.println("pesquisarPorTurmaMes");
        TurmaDaoImplTest turma = new TurmaDaoImplTest();

        sessao = HibernateUtil.abrirConexao();
        emprestimos = emprestimoDao.pesquisarPorTurmaMes(turma.buscarTurmaBd(), "06", "2021", sessao);
        sessao.close();

//        for (Emprestimo emp : emprestimos) {
//            System.out.println("Emprestimos");
//            System.out.println(emp.getDataPrevista());
//            System.out.println(emp.getDataRetirada());
//            System.out.println(emp.getAluno().getNome());
//            System.out.println(emp.getExemplar().getLivro().getTitulo());
//            System.out.println("");
//        }
        assertTrue(!emprestimos.isEmpty());
    }

//    @Test
    public void testPesquisarPorAlunoMes() {
        System.out.println("pesquisarPorAlunoMes");
        AlunoDaoImplTest aluno = new AlunoDaoImplTest();
        
        sessao = HibernateUtil.abrirConexao();
        emprestimos = emprestimoDao.pesquisarPorAlunoMes(aluno.gerarAlunoBd(), "06", "2021", sessao);
        sessao.close();

        assertTrue(!emprestimos.isEmpty());
    }

//    @Test
    public void testListarTodosEmAberto() {
        System.out.println("listarTodosEmAberto");

        sessao = HibernateUtil.abrirConexao();
        emprestimos = emprestimoDao.listarTodosEmAberto(sessao);
        sessao.close();

        assertTrue(!emprestimos.isEmpty());
    }
    
//    @Test
    public void testlistarAtrasados(){
        System.out.println("listarAtrasados");
        
        sessao = HibernateUtil.abrirConexao();
        emprestimos = emprestimoDao.listarAtrasados(sessao);
        sessao.close();

        for (Emprestimo emp : emprestimos) {
            System.out.println(emp.getDataPrevista());
            System.out.println(emp.getDataRetirada());
            System.out.println(emp.getAluno().getNome());
            System.out.println(emp.getExemplar().getLivro().getTitulo());
            System.out.println("");
        }
        assertTrue(!emprestimos.isEmpty());
    }
}
