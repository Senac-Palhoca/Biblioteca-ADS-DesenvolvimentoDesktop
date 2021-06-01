/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Perfil;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Felipe
 */
public class PerfilDaoImplTest {

    private Session session;
    List<Perfil> perfis;
    private PerfilDao perfilDao;

    public PerfilDaoImplTest() {
        perfilDao = new PerfilDaoImpl();
    }

//    @Test
    public void testPesquisarPerfil() {
        System.out.println("pesquisarPerfil");
        session = HibernateUtil.abrirConexao();
        perfis = perfilDao.pesquisarPerfil(session);
        session.close();
        assertTrue(!perfis.isEmpty());
    }
}
