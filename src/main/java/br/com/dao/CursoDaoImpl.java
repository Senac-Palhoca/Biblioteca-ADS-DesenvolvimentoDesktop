package br.com.dao;

import br.com.model.Curso;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author Titione.Amorim
 */
public class CursoDaoImpl extends BaseDaoImpl<Curso, Long> implements CursoDao {

    @Override
    public Curso pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Curso) sessao.get(Curso.class, id);
    }

    @Override
    public List<Curso> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Curso where nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.list();
    }

    @Override
    public List<Curso> listarTodos(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery(("FROM Curso"));
        return consulta.list();
    }

    @Override
    public void excluir(Curso curso, Session session) throws HibernateException {
        Transaction transacao;
        transacao = session.beginTransaction();
        session.delete(curso);
        transacao.commit();
    }
}
