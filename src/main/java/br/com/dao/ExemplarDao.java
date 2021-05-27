/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Exemplar;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Silvio
 */
public interface ExemplarDao extends BaseDao<Exemplar, Long>{
    
    List<Exemplar> pesquisarPorTitulo(String nome, Session sessao) throws HibernateException;
    
    List<Exemplar> listarTodos(Session sessao) throws HibernateException;
    
}