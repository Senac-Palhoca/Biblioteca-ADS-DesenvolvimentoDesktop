/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Aluno;
import br.com.util.UtilGerador;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.hibernate.*;

/**
 *
 * @author Felip
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
        aluno = new Aluno(null, UtilGerador.gerarNome(), UtilGerador.gerarNumero(12), UtilGerador.gerarEmail(), UtilGerador.gerarCaracter(6), UtilGerador.gerarNumero(3)); //Aluno(Long id, String nome, String cpf, String email, String senha, String matricula)
        sessao = HibernateUtil.abrirConexao();
        alunoDao.salvarOuAlterar(aluno, sessao);
        sessao.close();
        assertNotNull(aluno.getId());
    }
    
    @Test
    public void testAlterar() {
        gerarAlunoBd();
        sessao = HibernateUtil.abrirConexao();
        Aluno alunoId = alunoDao.pesquisarPorId(aluno.getId(), sessao);
        sessao.close();
        assertNotNull(alunoId);
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
    
    @Test
    public void testExcluir() {
        gerarAlunoBd();
        sessao = HibernateUtil.abrirConexao();
        alunoDao.excluir(aluno, sessao);
        Aluno alunoExc = alunoDao.pesquisarPorId(aluno.getId(), sessao);
        sessao.close();
        assertNull(alunoExc);
    }
    
    public Aluno gerarAlunoBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Aluno");
        List<Aluno> alunos = consulta.list();
        sessao.close();
        if(alunos.isEmpty()){
            testSalvar();
        }else{
           aluno = alunos.get(0);
        }
        return aluno;
    }
    
}
