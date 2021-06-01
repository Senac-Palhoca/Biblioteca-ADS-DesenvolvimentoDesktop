/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Funcionario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public interface FuncionarioDao extends BaseDao<Funcionario, Long>{
    List<Funcionario> listarTodos(Session sessao) throws HibernateException;
}
