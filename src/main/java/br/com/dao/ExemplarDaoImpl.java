/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Exemplar;
import br.com.model.Livro;
import java.io.Serializable;
import java.util.List;
import org.hibernate.*;

public class ExemplarDaoImpl extends BaseDaoImpl<Exemplar, Long> implements ExemplarDao, Serializable {
    
    @Override
    public List<Exemplar> listarTodos(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery(("FROM Exemplar"));
        return consulta.list();
    }

    @Override
    public Exemplar pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Exemplar) sessao.get(Exemplar.class, id);
    }

    @Override
    public List<Exemplar> pesquisarPorTituloLivro(String titulo, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Exemplar e where e.livro.titulo like :titulo");
        consulta.setParameter("titulo", "%" + titulo + "%");
        return consulta.list();
    }
}
