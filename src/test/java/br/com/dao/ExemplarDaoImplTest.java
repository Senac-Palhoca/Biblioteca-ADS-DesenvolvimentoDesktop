/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Exemplar;
import static br.com.util.UtilGerador.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.hibernate.*;

/**
 *
 * @author marcelo
 */
public class ExemplarDaoImplTest {

    private Exemplar exemplar;
    private ExemplarDao exemplarDao;
    private Session sessao;

    public ExemplarDaoImplTest() {
        exemplarDao = new ExemplarDaoImpl();
    }

//    @Test
    public void testListarTodos() {
        gerarExemplarBd();
        sessao = HibernateUtil.abrirConexao();
        List<Exemplar> exemplars = exemplarDao.listarTodos(sessao);
        sessao.close();
        boolean isEmpty = exemplars.isEmpty();
        assertFalse(isEmpty);
    }

//    @Test
    public void testPesquisarPorTitulo() {
//        gerarExemplarBd();
//        sessao = HibernateUtil.abrirConexao();
//        List<Exemplar> exemplars = exemplarDao.pesquisarPorTitulo(exemplar.getCodigoLivro().substring(1, 3), sessao);
//        sessao.close();
//        assertFalse(exemplars.isEmpty());
    }

//    @Test
    public void testPesquisarPorId() {
        gerarExemplarBd();
        sessao = HibernateUtil.abrirConexao();
        Exemplar exemplarId = exemplarDao.pesquisarPorId(exemplar.getId(), sessao);
        sessao.close();
        assertNotNull(exemplarId);
    }

//    @Test
    public void testSalvar() {
        exemplar = new Exemplar(gerarCodigoLivro());
        sessao = HibernateUtil.abrirConexao();
        exemplarDao.salvarOuAlterar(exemplar, sessao);
        sessao.close();
        assertNotNull(exemplar.getId());
    }

//    @Test
    public void testAlterar() {
        gerarExemplarBd();
        sessao = HibernateUtil.abrirConexao();
        Exemplar exemplarId = exemplarDao.pesquisarPorId(exemplar.getId(), sessao);
        sessao.close();
        assertNotNull(exemplarId);
    }

//    @Test
    public void testExcluir() {
        gerarExemplarBd();
        sessao = HibernateUtil.abrirConexao();
        exemplarDao.excluir(exemplar, sessao);
        Exemplar exemplarExc = exemplarDao.pesquisarPorId(exemplar.getId(), sessao);
        sessao.close();
        assertNull(exemplarExc);
    }

    public Exemplar gerarExemplarBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Exemplar");
        List<Exemplar> exemplars = consulta.list();
        sessao.close();
        if (exemplars.isEmpty()) {
            testSalvar();
        } else {
            exemplar = exemplars.get(0);
        }
        return exemplar;
    }
}
