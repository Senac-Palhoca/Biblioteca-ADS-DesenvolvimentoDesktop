/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view.aluno;

import br.com.dao.*;
import br.com.model.Livro;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.*;

/**
 *
 * @author Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 *
 */
public class PnPesquisarLivro extends javax.swing.JPanel {

    private Session sessao;
    private Livro livro;
    private LivroDao livroDao;
    private List<Livro> livros;
    private DefaultTableModel tabelaModelo;

    public PnPesquisarLivro() {
        initComponents();
        livroDao = new LivroDaoImpl();
    }

    int numeracao = 1;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLivro = new javax.swing.JTable();
        tfTituloAutor = new javax.swing.JTextField();
        lbTituloAutor = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setText("Buscar Livro");

        tbLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor", "Editora", "Isbn"
            }
        ));
        jScrollPane1.setViewportView(tbLivro);

        tfTituloAutor.setToolTipText("Digite o titulo do liro ou o autor que deseja pesquisar");

        lbTituloAutor.setText("Título/Autor:");

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbTituloAutor)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(tfTituloAutor)
                                                .addGap(10, 10, 10)
                                                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(26, 26, 26)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTituloAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTituloAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        if (btBuscar.isEnabled()) {
            try {
                sessao = HibernateUtil.abrirConexao();
                livros = livroDao.pesquisarPorTituloAutor(tfTituloAutor.getText().trim(),
                        tfTituloAutor.getText().trim(), sessao);
                if (livros.isEmpty()) {
                    if (tabelaModelo != null) {
                        tabelaModelo.setNumRows(0);
                    }
                    JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum valor!");
                } else {
                    popularTabela();
                    numeracao = 1;
                }
            } catch (HibernateException e) {
                System.err.println("Erro ao pesquisar " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao pesquisar livro, "
                        + "comunique o administrador do sistema!\n\n\n Informe sobre o erro: "
                        + e.getMessage(), "Erro ao pesquisar livro", JOptionPane.ERROR_MESSAGE);
            } finally {
                sessao.close();
            }
    }//GEN-LAST:event_btBuscarActionPerformed
    }

    private void popularTabela() {
        tabelaModelo = (DefaultTableModel) tbLivro.getModel();
        tabelaModelo.setNumRows(0);
        String ativo;
        for (Livro livro : livros) {
            tabelaModelo.addRow(new Object[]{numeracao + ") " + livro.getTitulo(), livro.getAutor(),
                livro.getEditora(), livro.getIsbn()});
            numeracao++;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTituloAutor;
    private javax.swing.JTable tbLivro;
    private javax.swing.JTextField tfTituloAutor;
    // End of variables declaration//GEN-END:variables
}
