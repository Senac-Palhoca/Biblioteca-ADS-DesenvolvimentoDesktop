/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Perfil;
import br.com.util.UtilGerador;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Felipe
 */
public class PerfilDaoImplTest {

    private Session sessao;
    private Perfil perfil;
    List<Perfil> perfis;
    private PerfilDao perfilDao;

    public PerfilDaoImplTest() {
        perfilDao = new PerfilDaoImpl();
    }

    @Test
    public void testSalvar() {
        testPesquisarPerfil();
        
        if (perfis.isEmpty()) {
            Session session = HibernateUtil.abrirConexao();
            perfil = new Perfil(null, "Administrador", "Gerencia bibliotecários, alunos, cursos e turmas");
            salvar(perfil, session);
            perfil = new Perfil(null, "Coordenador", "Ranking de turmas e alunos");
            salvar(perfil, session);
            perfil = new Perfil(null, "Bibliotecário", "Gerencia livros e acesso ao ranking mensal");
            salvar(perfil, session);
            perfil = new Perfil(null, "Aluno", "Tem acesso aos seus emprestimos pessoais");
            salvar(perfil, session);
            session.close();
        }
        assertTrue(!perfis.isEmpty());
    }

    private void salvar(Perfil perfil, Session sessao) throws HibernateException {
        Transaction transacao;
        transacao = sessao.beginTransaction();
        sessao.saveOrUpdate(perfil);
        transacao.commit();
    }

    @Test
    public void testPesquisarPerfil() {
        System.out.println("pesquisarPerfil");
        sessao = HibernateUtil.abrirConexao();
        perfis = perfilDao.pesquisarPerfil(sessao);
        if (perfis.isEmpty()) {
            testSalvar();
        }
        sessao.close();
        assertTrue(!perfis.isEmpty());
    }

    public Perfil gerarPerfilBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Perfil");
        List<Perfil> perfils = consulta.list();
        sessao.close();
        if (perfils.isEmpty()) {
            testSalvar();
        } else {
            perfil = perfils.get(UtilGerador.criarNumeroEntre2Valores(-1, perfils.size()));
        }
        return perfil;
    }
}
