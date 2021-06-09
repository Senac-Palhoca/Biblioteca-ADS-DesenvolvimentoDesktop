/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.dao.HibernateUtil;
import br.com.dao.PerfilDao;
import br.com.dao.PerfilDaoImpl;
import br.com.model.Perfil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Felipe
 */
public class PopulaPerfis {

    public static void Popular() {
        Perfil perfil;
        PerfilDao perfilDao = new PerfilDaoImpl();
        Session session = HibernateUtil.abrirConexao();
        try {
            List<Perfil> perfis = perfilDao.pesquisarPerfil(session);

            if (perfis.isEmpty()) {
                perfil = new Perfil(null, "Administrador", "Gerência funcionários, alunos, cursos e turmas");
                salvar(perfil, session);
                perfil = new Perfil(null, "Coordenador", "Gerencia livros, empréstimos e acesso ao ranking");
                salvar(perfil, session);
                perfil = new Perfil(null, "Bibliotecário", "Gerencia livros, empréstimos e acesso ao ranking");
                salvar(perfil, session);
                perfil = new Perfil(null, "Aluno", "Tem acesso aos seus empréstimos pessoais");
                salvar(perfil, session);
            }
        } catch (HibernateException e) {
            System.out.println("Erro ao salvar perfis padrão" + e.getMessage());
        } finally {
            session.close();
        }
    }

    private static void salvar(Perfil perfil, Session sessao) throws HibernateException {
        Transaction transacao;
        transacao = sessao.beginTransaction();
        sessao.saveOrUpdate(perfil);
        transacao.commit();
    }
}
