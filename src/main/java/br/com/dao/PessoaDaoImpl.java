/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Pessoa;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PessoaDaoImpl implements PessoaDao {

    @Override
    public Pessoa login(String login, String senha, Session session) throws HibernateException {
        Query consulta = session.createQuery("from Pessoa where email = :email and senha = :senha");
        consulta.setParameter("email", login);
        consulta.setParameter("senha", senha);
        return (Pessoa) consulta.uniqueResult();
    }

}
