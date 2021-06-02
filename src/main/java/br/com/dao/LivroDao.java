/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Livro;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Silvio
 */
public interface LivroDao extends BaseDao<Livro, Long>{
    
    List<Livro> listarTodo(Session sessao) throws HibernateException;
    
    List<Livro> pesquisarPorTituloAutor(String titulo, String autor, Session sessao) throws HibernateException;
    
}
