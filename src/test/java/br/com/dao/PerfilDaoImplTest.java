/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Perfil;
import static br.com.util.UtilGerador.gerarNome;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
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
        perfil = new Perfil(null, "Função " + gerarNome(), "Descrição " + gerarNome());
        sessao = HibernateUtil.abrirConexao();
        perfilDao.salvarOuAlterar(perfil, sessao);
        sessao.close();
        assertNotNull(perfil.getId());
    }

//    @Test
    public void testPesquisarPerfil() {
        System.out.println("pesquisarPerfil");
        sessao = HibernateUtil.abrirConexao();
        perfis = perfilDao.pesquisarPerfil(sessao);
        sessao.close();
        assertTrue(!perfis.isEmpty());
    }
    
    public Perfil gerarPerfilBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Perfil");
        List<Perfil> perfils = consulta.list();
        sessao.close();
        if(perfils.isEmpty()){
            testSalvar();
        }else{
           perfil = perfils.get(0);
        }
        return perfil;
    }
}
