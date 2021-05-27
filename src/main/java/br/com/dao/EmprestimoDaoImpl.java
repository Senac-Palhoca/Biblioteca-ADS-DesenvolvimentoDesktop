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
public class EmprestimoDaoImpl extends BaseDaoImpl<Emprestimo, Long> implements EmprestimoDao{
    @Override
    public Emprestimo pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Emprestimo) sessao.get(Emprestimo.class, id);
    }
    
    @Override
    public List<Emprestimo> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Emprestimo where nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.list();
    }
    
    @Override
    public List<Emprestimo> listarTodos(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery(("FROM Emprestimo"));
        return consulta.list();
    }
}
