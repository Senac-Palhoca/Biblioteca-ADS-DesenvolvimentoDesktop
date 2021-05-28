/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Funcionario;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public class FuncionarioDaoImpl extends BaseDaoImpl<Funcionario, Long> implements Serializable, FuncionarioDao{

    @Override
    public Funcionario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Funcionario) sessao.get(Funcionario.class, id);
    }
    
}
