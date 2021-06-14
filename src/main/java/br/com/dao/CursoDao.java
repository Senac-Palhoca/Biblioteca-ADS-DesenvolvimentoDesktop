package br.com.dao;

import br.com.model.Curso;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
*
*@author Titione.Amorim
*/
public interface CursoDao extends BaseDao<Curso, Long>{
    
    List<Curso> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
    
    List<Curso> listarTodos(Session sessao) throws HibernateException;
    
    void excluir(Curso curso, Session session) throws HibernateException;
    
}