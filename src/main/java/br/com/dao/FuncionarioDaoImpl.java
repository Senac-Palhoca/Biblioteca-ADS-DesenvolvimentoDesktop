/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Funcionario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public class FuncionarioDaoImpl extends BaseDaoImpl<Funcionario, Long> implements Serializable, FuncionarioDao{

    @Override
    public Funcionario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Funcionario) sessao.get(Funcionario.class, id);
    }

    @Override
    public List<Funcionario> listarTodos(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("FROM Funcionario order by nome");
        return consulta.list();
    }
    
    @Override
    public List<Funcionario> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Funcionario where nome like :nome order by nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.list();
    }
}
