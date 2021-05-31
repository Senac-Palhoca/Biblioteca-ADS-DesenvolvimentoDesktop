/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Aluno;
import br.com.model.Curso;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Felip
 */
public interface AlunoDao extends BaseDao<Aluno, Long>{
    List<Aluno> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
    
    List<Aluno> pesquisarPorMatricula(String matricula, Session sessao) throws HibernateException;
    
    List<Aluno> pesquisarPorCurso(Curso curso, Session sessao) throws HibernateException;
    
    List<Aluno> listarRankingMes(Integer mes, Integer ano, Session sessao) throws HibernateException;
    
    List<Aluno> listarTodos(Session sessao) throws HibernateException;
    
}