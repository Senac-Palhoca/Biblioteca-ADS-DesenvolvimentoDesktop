package br.com.dao;

import br.com.model.Curso;
import br.com.model.Turma;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author Titione.Amorim
 */
public class TurmaDaoImpl extends BaseDaoImpl<Turma, Long> implements TurmaDao {

    @Override
    public Turma pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Turma) sessao.get(Turma.class, id);
    }

    @Override
    public List<Turma> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Turma where nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.list();
    }

    @Override
    public List<Turma> listarTodos(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("FROM Turma");
        return consulta.list();
    }

    @Override
    public List<Turma> listarRanking(Session sessao) throws HibernateException {
        return sessao.createQuery("FROM Turma t order by t.quantidadeEmprestimo desc").list();
    }

    @Override
    public List<Turma> listarPorCurso(Curso curso, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Turma where curso.id like :idCurso");
        consulta.setParameter("idCurso", curso.getId());
        return consulta.list();
    }

    @Override
    public void excluir(Turma turma, Session session) throws HibernateException {
        Transaction transacao;
        transacao = session.beginTransaction();
        session.delete(turma);
        transacao.commit();
    }

}
