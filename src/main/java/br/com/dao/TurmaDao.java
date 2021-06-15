package br.com.dao;

import br.com.model.Curso;
import br.com.model.Turma;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Titione.Amorim
 */
public interface TurmaDao extends BaseDao<Turma, Long> {

    List<Turma> pesquisarPorNome(String nome, Session sessao) throws HibernateException;

    List<Turma> listarRanking(Session sessao) throws HibernateException;

    List<Turma> listarPorCurso(Curso curso, Session sessao) throws HibernateException;

    List<Turma> listarTodos(Session sessao) throws HibernateException;

    void excluir(Turma turma, Session sessao) throws HibernateException;
}
