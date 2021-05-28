/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.dao.HibernateUtil;
import br.com.model.Perfil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Felipe 
 * 
 * Tem algum erro que não para de executar, mas podemos usar
 * enquanto tiver em desenvolvimento. Executar uma única vez, para não duplicar!
 */
public class PopulaPerfis {

    public static void main(String[] args) {
        Perfil perfil;
        Session session = HibernateUtil.abrirConexao();
        try {
            perfil = new Perfil(null, "Administrador", "Gerencia bibliotecários, alunos, cursos e turmas");
            salvar(perfil, session);
            perfil = new Perfil(null, "Coordenador", "Ranking de turmas e alunos");
            salvar(perfil, session);
            perfil = new Perfil(null, "Bibliotecário", "Gerencia livros e acesso ao ranking mensal");
            salvar(perfil, session);
            perfil = new Perfil(null, "Aluno", "Tem acesso aos seus emprestimos pessoais");
            salvar(perfil, session);
        } catch (HibernateException e) {
            System.err.println("Erro ao popular perfil: " + e.getMessage());
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
