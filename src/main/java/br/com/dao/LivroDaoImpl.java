/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Livro;
import java.io.Serializable;
import java.util.List;
import org.hibernate.*;

public class LivroDaoImpl extends BaseDaoImpl<Livro, Long> implements LivroDao, Serializable {

    @Override
    public Livro pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Livro) sessao.get(Livro.class, id);
    }

    @Override
    public List<Livro> listarTodo(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery(("FROM Livro"));
        return consulta.list();
    }

    @Override
    public List<Livro> pesquisarPorTitulo(String titulo, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Livro where nome like :titulo");
        consulta.setParameter("titulo", "%" + titulo + "%");
        return consulta.list();
    }

}
