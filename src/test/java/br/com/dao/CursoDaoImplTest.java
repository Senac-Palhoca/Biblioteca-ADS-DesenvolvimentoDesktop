package br.com.dao;

import br.com.model.Curso;
import static br.com.utilitario.UtilGerador.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.hibernate.*;

/**
*
*@author Felipe.Stahlhofer
*/
public class CursoDaoImplTest {
    private Curso curso;
    private CursoDao cursoDao;
    private Session sessao;
    
    public CursoDaoImplTest() {
        cursoDao = new CursoDaoImpl();
    }
    
    //@Test
    public void testSalvar() {
        curso = new Curso(null, "Curso " + gerarNome());
        sessao = HibernateUtil.abrirConexao();
        cursoDao.salvarOuAlterar(curso, sessao);
        sessao.close();
        assertNotNull(curso.getId());
    }
    
   //@Test
    public void testAlterar() {
        buscarCursoBd();
        sessao = HibernateUtil.abrirConexao();
        curso.setNome("Curso de Java do Xuxu");
        cursoDao.salvarOuAlterar(curso, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        Curso cursoPesquisado = cursoDao.pesquisarPorId(curso.getId(), sessao);
        sessao.close();
        assertEquals(curso.getNome(), cursoPesquisado.getNome());
    }
    
    //@Test
    public void testPesquisarPorId() {
        buscarCursoBd();
        sessao = HibernateUtil.abrirConexao();
        Curso cursoId = cursoDao.pesquisarPorId(curso.getId(), sessao);
        sessao.close();
        assertNotNull(cursoId);
    }
    
    //@Test
    public void testPesquisarPorNome() {
        buscarCursoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Curso> cursos = cursoDao.pesquisarPorNome(curso.getNome().substring(1, 3), sessao);
        sessao.close();
        assertFalse(cursos.isEmpty());
    }
    
    //@Test
    public void testListarTodos() {
        buscarCursoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Curso> cursos = cursoDao.listarTodos(sessao);
        sessao.close();
        boolean isEmpty = cursos.isEmpty();
        assertFalse(isEmpty);
    }
    
    // @Test
    public void testExcluir() {
        System.out.println("Teste Excluir não deve ser executado");
    }
    
    public Curso buscarCursoBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Curso");
        List<Curso> cursos = consulta.list();
        sessao.close();
        if(cursos.isEmpty()){
            testSalvar();
        }else{
           curso = cursos.get(0);
        }
        return curso;
    }
}