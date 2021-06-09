/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Aluno;
import br.com.model.Emprestimo;
import br.com.util.UtilGerador;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.hibernate.*;

/**
 * @author Felipe
 */
public class AlunoDaoImplTest {
    
    private Aluno aluno;
    private AlunoDao alunoDao;
    private Session sessao;
    
    public AlunoDaoImplTest() {
        alunoDao = new AlunoDaoImpl();
    }
    
    @Test
    public void testSalvar() {
        PerfilDao perfilDao = new PerfilDaoImpl();
        TurmaDaoImplTest turmaTest = new TurmaDaoImplTest();
        EmprestimoDaoImplTest emprestimoTest = new EmprestimoDaoImplTest();
        List<Emprestimo> emprestimos = new ArrayList<>();     
 
        aluno = new Aluno(null, UtilGerador.gerarNome(), UtilGerador.gerarCPF(), UtilGerador.gerarEmail(), UtilGerador.gerarCaracter(6), UtilGerador.gerarNumero(3)); //Aluno(Long id, String nome, String cpf, String email, String senha, String matricula)
        sessao = HibernateUtil.abrirConexao();
        aluno.setPerfil(perfilDao.pesquisarPerfil(sessao).get(3));
        aluno.setTurma(turmaTest.buscarTurmaBd());
        alunoDao.salvarOuAlterar(aluno, sessao);
        sessao.close();
        
        assertNotNull(aluno.getId());
    }
    
    @Test
    public void testAlterar() {
        gerarAlunoBd();
        aluno.setNome("Alterado");
        
        sessao = HibernateUtil.abrirConexao();
        alunoDao.salvarOuAlterar(aluno, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        Aluno altAluno = alunoDao.pesquisarPorId(aluno.getId(), sessao);
        sessao.close();
        
        assertEquals(aluno.getNome(), (altAluno.getNome()));
    }
    
    @Test
    public void testPesquisarPorId() {
        gerarAlunoBd();
        sessao = HibernateUtil.abrirConexao();
        Aluno alunoId = alunoDao.pesquisarPorId(aluno.getId(), sessao);
        sessao.close();
        assertNotNull(alunoId);
    }
    
    @Test
    public void testPesquisarPorNome() {
        gerarAlunoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Aluno> alunos = alunoDao.pesquisarPorNome(aluno.getNome().substring(1, 3), sessao);
        sessao.close();
        assertFalse(alunos.isEmpty());
    }
    
    @Test
    public void testListarTodos() {
        gerarAlunoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Aluno> alunos = alunoDao.listarTodos(sessao);
        sessao.close();
        boolean isEmpty = alunos.isEmpty();
        assertFalse(isEmpty);
    }
    
    //@Test
    public void testExcluir() {
        gerarAlunoBd();
        sessao = HibernateUtil.abrirConexao();
        alunoDao.excluir(aluno, sessao);
        Aluno alunoExc = alunoDao.pesquisarPorId(aluno.getId(), sessao);
        sessao.close();
        assertNull(alunoExc);
    }
    
    @Test
    public void testPesquisarPorMatricula(){
        gerarAlunoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Aluno> alunos = alunoDao.pesquisarPorMatricula(aluno.getMatricula(), sessao);
        sessao.close();
        assertFalse(alunos.isEmpty());
    }
    
    @Test
    public void testPesquisarPorTurma(){
        gerarAlunoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Aluno> alunos = alunoDao.pesquisarPorTurma(aluno.getTurma(), sessao);
        sessao.close();
        assertFalse(alunos.isEmpty());
    }
    
    @Test
    public void testListarRankingMes(){
        gerarAlunoBd();
        sessao = HibernateUtil.abrirConexao();
        Date data = new Date();
 
        List<Object[]> objAlunos = alunoDao.listarRankingMes(data, aluno.getTurma().getId(), sessao);
        sessao.close();
        //assertNotNull(data);
        assertFalse(objAlunos.isEmpty());
    }
    
    public Aluno gerarAlunoBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Aluno");
        List<Aluno> alunos = consulta.list();
        sessao.close();
        if(alunos.isEmpty()){
            testSalvar();
        }else{
           aluno = alunos.get(UtilGerador.criarNumeroEntre2Valores(-1, alunos.size()));
        }
        return aluno;
    }
    
}
