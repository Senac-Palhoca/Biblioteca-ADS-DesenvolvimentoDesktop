/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Emprestimo;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author Felip
 */
public interface EmprestimoDao extends BaseDao<Emprestimo, Long>{
    List<Emprestimo> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
    List<Emprestimo> listarTodos(Session sessao) throws HibernateException;
}
