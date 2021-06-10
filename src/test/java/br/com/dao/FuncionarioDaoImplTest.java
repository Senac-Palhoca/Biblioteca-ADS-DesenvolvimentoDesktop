/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.model.Funcionario;
import br.com.util.UtilGerador;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Felipe
 */
public class FuncionarioDaoImplTest {

    private Funcionario funcionario;
    private FuncionarioDao funcionarioDao;
    private Session sessao;

    public FuncionarioDaoImplTest() {
        funcionarioDao = new FuncionarioDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        funcionario = new Funcionario();
        PerfilDao perfilDao = new PerfilDaoImpl();

        sessao = HibernateUtil.abrirConexao();
        funcionario.setCpf(UtilGerador.gerarCPF());
        funcionario.setEmail(UtilGerador.gerarEmail());
        funcionario.setMatricula(UtilGerador.gerarNumero(5));
        funcionario.setNome(UtilGerador.gerarNome());
        funcionario.setSenha("1234");
        funcionario.setPerfil(perfilDao.pesquisarPerfil(sessao).get(UtilGerador.criarNumeroEntre2Valores(-1, 3)));

        funcionarioDao.salvarOuAlterar(funcionario, sessao);
        sessao.close();

        assertNotNull(funcionario.getId());
    }

//    @Test
    public void testAlterar() {
        System.out.println("Alterar");
        buscarFuncionarioBd();

        funcionario.setEmail(UtilGerador.gerarEmail());

        sessao = HibernateUtil.abrirConexao();
        funcionarioDao.salvarOuAlterar(funcionario, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Funcionario funcionarioAlt = funcionarioDao.pesquisarPorId(funcionario.getId(), sessao);
        sessao.close();

        assertEquals(funcionario.getEmail(), funcionarioAlt.getEmail());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarFuncionarioBd();

        sessao = HibernateUtil.abrirConexao();
        Funcionario func = funcionarioDao.pesquisarPorId(funcionario.getId(), sessao);
        sessao.close();

        assertNotNull(func);
    }

    public Funcionario buscarFuncionarioBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Funcionario");
        List<Funcionario> funcionarios = consulta.list();
        sessao.close();
        if (funcionarios.isEmpty()) {
            testSalvar();
        } else {
            funcionario = funcionarios.get(UtilGerador.criarNumeroEntre2Valores(-1, funcionarios.size()));
        }
        return funcionario;
    }
}
