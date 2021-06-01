/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Titione.Amorim
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Pessoa.class);
            cfg.addAnnotatedClass(Aluno.class);
            cfg.addAnnotatedClass(Perfil.class);
            cfg.addAnnotatedClass(Funcionario.class);
            cfg.addAnnotatedClass(Exemplar.class);
            cfg.addAnnotatedClass(Emprestimo.class);
            cfg.addAnnotatedClass(Livro.class);
            cfg.addAnnotatedClass(Curso.class);
            cfg.addAnnotatedClass(Turma.class);
            cfg.addAnnotatedClass(Livro.class);
            cfg.addAnnotatedClass(Exemplar.class);
            
            cfg.configure("/META-INF/hibernate.cfg.xml");
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().
                    applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(build.build());
        } catch (HibernateException ex) {
            System.err.println("Erro ao criar Hibernate util." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session abrirConexao() {
        return sessionFactory.openSession();
    }
}
