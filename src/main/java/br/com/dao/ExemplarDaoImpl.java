package br.com.dao;

import br.com.model.Exemplar;
import java.io.Serializable;
import java.util.List;
import org.hibernate.*;

public class ExemplarDaoImpl extends BaseDaoImpl<Exemplar, Long> implements ExemplarDao, Serializable {
    
    @Override
    public List<Exemplar> listarTodos(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery(("FROM Exemplar"));
        return consulta.list();
    }

    @Override
    public Exemplar pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Exemplar) sessao.get(Exemplar.class, id);
    }

    @Override
    public List<Exemplar> pesquisarPorTituloAutor(String titulo, String autor, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Exemplar e where e.livro.titulo like :titulo or e.livro.autor like :autor");
        consulta.setParameter("titulo", "%" + titulo + "%");
        consulta.setParameter("autor", "%" + autor + "%");
        return consulta.list();
    }
}
