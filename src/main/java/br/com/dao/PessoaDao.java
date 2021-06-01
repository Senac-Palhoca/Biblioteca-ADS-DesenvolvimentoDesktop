/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Pessoa;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public interface PessoaDao {

    Pessoa login(String login, String senha, Session session) throws HibernateException;
}
