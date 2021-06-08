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
public class LivroDaoImplTest {

    private Livro livro;
    private LivroDao livroDao;
    private Session sessao;

    public LivroDaoImplTest() {
        livroDao = new LivroDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("################");
        System.out.println("# Teste Salvar #");
        System.out.println("################");
        livro = new Livro(gerarTitulo(), gerarNome(), gerarNumero(1), gerarEditora(), gerarNumero(13));
        sessao = HibernateUtil.abrirConexao();
        livroDao.salvarOuAlterar(livro, sessao);
        sessao.close();
        assertNotNull(livro.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("#################");
        System.out.println("# Teste Alterar #");
        System.out.println("#################");
        gerarLivroBd();
        sessao = HibernateUtil.abrirConexao();
        livro.setTitulo("Use a cabeça - Java");
        livroDao.salvarOuAlterar(livro, sessao);
        Livro livroId = livroDao.pesquisarPorId(livro.getId(), sessao);
        sessao.close();
        assertNotNull(livroId);
    }

    @Test
    public void testExcluir() {
        System.out.println("#################");
        System.out.println("# Teste Excluir #");
        System.out.println("#################");
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("##########################");
        System.out.println("# Teste Pesquisar por ID #");
        System.out.println("##########################");
        gerarLivroBd();
        sessao = HibernateUtil.abrirConexao();
        Livro livroId = livroDao.pesquisarPorId(livro.getId(), sessao);
        sessao.close();
        assertNotNull(livroId);
    }

    @Test
    public void testListarTodo() {
        System.out.println("#####################");
        System.out.println("# Teste Listar Todo #");
        System.out.println("#####################");
        gerarLivroBd();
        sessao = HibernateUtil.abrirConexao();
        List<Livro> livros = livroDao.listarTodo(sessao);
        sessao.close();
        boolean isEmpty = livros.isEmpty();
        assertFalse(isEmpty);
    }

    @Test
    public void pesquisarPorTituloAutor() {
        System.out.println("####################################");
        System.out.println("# Teste Pesquisar Por Titulo/Autor #");
        System.out.println("####################################");
        gerarLivroBd();
        sessao = HibernateUtil.abrirConexao();
        List<Livro> livros = livroDao.pesquisarPorTituloAutor("", "", sessao);
        sessao.close();
        assertNotNull(livros.isEmpty());
    }

    public Livro gerarLivroBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Livro");
        List<Livro> livros = consulta.list();
        sessao.close();
        if (livros.isEmpty()) {
            testSalvar();
        } else {
            livro = livros.get(criarNumeroEntre2Valores(-1, livros.size()));
        }
        return livro;
    }
}
