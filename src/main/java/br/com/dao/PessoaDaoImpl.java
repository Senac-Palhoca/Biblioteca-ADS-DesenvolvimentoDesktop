/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Perfil;
import br.com.model.Pessoa;
import java.util.List;
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

    @Override
    public List<Pessoa> listarTodo(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery(("FROM Pessoa"));
        return consulta.list();
    }

    @Override
    public List<Pessoa> listarPorPerfil(Perfil perfil, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Pessoa where perfil.id like :idPerfil");
        consulta.setParameter("idPerfil", perfil.getId());
        return consulta.list();
    }
}
