/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Exemplar;
import br.com.util.UtilGerador;
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

    @Test
    public void testListarTodos() {
        System.out.println("######################");
        System.out.println("# Teste Listar Todos #");
        System.out.println("######################");
        gerarExemplarBd();
        sessao = HibernateUtil.abrirConexao();
        List<Exemplar> exemplars = exemplarDao.listarTodos(sessao);
        sessao.close();
        boolean isEmpty = exemplars.isEmpty();
        assertFalse(isEmpty);
    }

    @Test
    public void pesquisarPorTituloAutor() {
        System.out.println("##############################");
        System.out.println("# Pesquisar Por Titulo Livro #");
        System.out.println("##############################");
        gerarExemplarBd();
        sessao = HibernateUtil.abrirConexao();
        List<Exemplar> exemplars = exemplarDao.pesquisarPorTituloAutor("", "", sessao);
        sessao.close();
        assertNotNull(exemplars.isEmpty());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("##########################");
        System.out.println("# Teste Pesquisar Por Id #");
        System.out.println("##########################");
        gerarExemplarBd();
        sessao = HibernateUtil.abrirConexao();
        Exemplar exemplarId = exemplarDao.pesquisarPorId(exemplar.getId(), sessao);
        sessao.close();
        assertNotNull(exemplarId);
    }

    @Test
    public void testSalvar() {
        System.out.println("################");
        System.out.println("# Teste Salvar #");
        System.out.println("################");
        LivroDaoImplTest livroteste = new LivroDaoImplTest();

        exemplar = new Exemplar(gerarCodigoLivro(),  livroteste.gerarLivroBd());
        sessao = HibernateUtil.abrirConexao();
        exemplarDao.salvarOuAlterar(exemplar, sessao);
        sessao.close();
        assertNotNull(exemplar.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("#################");
        System.out.println("# Teste Alterar #");
        System.out.println("#################");
        gerarExemplarBd();
        sessao = HibernateUtil.abrirConexao();
        Exemplar exemplarId = exemplarDao.pesquisarPorId(exemplar.getId(), sessao);
        sessao.close();
        assertNotNull(exemplarId);
    }

//    @Test
    public void testExcluir() {
        System.out.println("#################");
        System.out.println("# Teste Excluir #");
        System.out.println("#################");
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
        if (exemplars.isEmpty()){
            testSalvar();
        } else {
            exemplar = exemplars.get(UtilGerador.criarNumeroEntre2Valores(-1, exemplars.size()));
        }
        return exemplar;
    }
}
