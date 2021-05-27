/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Emprestimo;
import br.com.util.UtilGerador;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.hibernate.*;

/**
 *
 * @author Felip
 */
public class EmprestimoDaoImplTest {
    private Emprestimo emprestimo;
    private EmprestimoDao emprestimoDao;
    private Session sessao;
    
    public EmprestimoDaoImplTest() {
        emprestimoDao = new EmprestimoDaoImpl();
    }
    
    @Test
    public void testSalvar() {
        emprestimo = new Emprestimo(null, new Date(), new Date(), new Date());
        sessao = HibernateUtil.abrirConexao();
        emprestimoDao.salvarOuAlterar(emprestimo, sessao);
        sessao.close();
        assertNotNull(emprestimo.getId());
    }
    
    @Test
    public void testAlterar() {
        gerarEmprestimoBd();
        sessao = HibernateUtil.abrirConexao();
        Emprestimo emprestimoId = emprestimoDao.pesquisarPorId(emprestimo.getId(), sessao);
        sessao.close();
        assertNotNull(emprestimoId);
    }
    
    @Test
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
    
    @Test
    public void testListarTodos() {
        gerarEmprestimoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Emprestimo> emprestimos = emprestimoDao.listarTodos(sessao);
        sessao.close();
        boolean isEmpty = emprestimos.isEmpty();
        assertFalse(isEmpty);
    }
    
    @Test
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
        List<Emprestimo> emprestimos = consulta.list();
        sessao.close();
        if(emprestimos.isEmpty()){
            testSalvar();
        }else{
           emprestimo = emprestimos.get(0);
        }
        return emprestimo;
    }
}
