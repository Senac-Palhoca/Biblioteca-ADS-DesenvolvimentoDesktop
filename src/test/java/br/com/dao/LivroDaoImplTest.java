package br.com.dao;

import br.com.model.Livro;
import static br.com.util.UtilGerador.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.hibernate.*;

/**
 *
 * @author marcelo
 */
//public class LivroDaoImplTest {
//
//    private Livro livro;
//    private LivroDao livroDao;
//    private Session sessao;
//
//    public LivroDaoImplTest() {
//        livroDao = new LivroDaoImpl();
//    }
//
////    @Test
//    public void testPesquisarPorId() {
//        gerarLivroBd();
//        sessao = HibernateUtil.abrirConexao();
//        Livro livroId = livroDao.pesquisarPorId(livro.getId(), sessao);
//        sessao.close();
//        assertNotNull(livroId);
//    }
//
////    @Test
//    public void testListarTodo() {
//        gerarLivroBd();
//        sessao = HibernateUtil.abrirConexao();
//        List<Livro> livros = livroDao.listarTodo(sessao);
//        sessao.close();
//        boolean isEmpty = livros.isEmpty();
//        assertFalse(isEmpty);
//    }
//
////    @Test
//    public void testPesquisarPorTitulo() {
//        gerarLivroBd();
//        sessao = HibernateUtil.abrirConexao();
//        List<Livro> livros = livroDao.pesquisarPorTitulo(livro.getTitulo().substring(1, 3), sessao);
//        sessao.close();
//        assertFalse(livros.isEmpty());
//    }
//
////    @Test
//    public void testSalvar() {
//        livro = new Livro(gerarTitulo(), gerarNomeSobrenome(), gerarNumero(1), gerarEditora(), gerarNumero(13));
//        sessao = HibernateUtil.abrirConexao();
//        livroDao.salvarOuAlterar(livro, sessao);
//        sessao.close();
//        assertNotNull(livro.getId());
//    }
//
////    @Test
//    public void testAlterar() {
//        gerarLivroBd();
//        sessao = HibernateUtil.abrirConexao();
//        Livro livroId = livroDao.pesquisarPorId(livro.getId(), sessao);
//        sessao.close();
//        assertNotNull(livroId);
//    }
//
////    @Test
//    public void testExcluir() {
//        gerarLivroBd();
//        sessao = HibernateUtil.abrirConexao();
//        livroDao.excluir(livro, sessao);
//        Livro livroExc = livroDao.pesquisarPorId(livro.getId(), sessao);
//        sessao.close();
//        assertNull(livroExc);
//    }
//
//    public Livro gerarLivroBd() {
//        sessao = HibernateUtil.abrirConexao();
//        Query consulta = sessao.createQuery("from Livro");
//        List<Livro> livros = consulta.list();
//        sessao.close();
//        if (livros.isEmpty()) {
//            testSalvar();
//        } else {
//            livro = livros.get(0);
//        }
//        return livro;
//    }
//}
