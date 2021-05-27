/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Perfil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public class PerfilDaoImpl implements PerfilDao, Serializable {

    @Override
    public List<Perfil> pesquisarPerfil(Session session) throws HibernateException {
        Query consulta = session.createQuery("from Perfil");
        return consulta.list();
    }
}
