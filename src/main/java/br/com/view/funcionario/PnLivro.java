package br.com.view.funcionario;

import br.com.dao.*;
import br.com.model.*;
import br.com.view.Principal;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.hibernate.*;

/**
 *
 * @author Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 *
 */
public class PnLivro extends javax.swing.JPanel {

    private Session sessao;
    private DefaultTableModel tabelaModelo;
    private ExemplarDao exemplarDao;
    private LivroDao livroDao;
    private List<Exemplar> exemplares;
    private int contarDisponivel;

    public PnLivro() {
        initComponents();
        livroDao = new LivroDaoImpl();
        exemplarDao = new ExemplarDaoImpl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLivro = new javax.swing.JTable();
        tfTituloAutor = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btNovoLivro = new javax.swing.JButton();
        btAlterarLivroSelecionado = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        lbQuantidade = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setText("Livros");

        tbLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor", "Editora", "Edição", "ISBN", "Código", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbLivro);
        if (tbLivro.getColumnModel().getColumnCount() > 0) {
            tbLivro.getColumnModel().getColumn(0).setResizable(false);
            tbLivro.getColumnModel().getColumn(0).setPreferredWidth(350);
            tbLivro.getColumnModel().getColumn(1).setResizable(false);
            tbLivro.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbLivro.getColumnModel().getColumn(2).setResizable(false);
            tbLivro.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbLivro.getColumnModel().getColumn(3).setResizable(false);
            tbLivro.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbLivro.getColumnModel().getColumn(4).setResizable(false);
            tbLivro.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbLivro.getColumnModel().getColumn(5).setResizable(false);
            tbLivro.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbLivro.getColumnModel().getColumn(6).setResizable(false);
            tbLivro.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        tfTituloAutor.setToolTipText("Digite o titulo do Livro ou Autor que deseja pesquisar");

        btBuscar.setText("Buscar");
        btBuscar.setToolTipText("Clique para Pesquisar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar Título/Autor");

        btNovoLivro.setText("+ Novo Livro");
        btNovoLivro.setToolTipText("Cadastrar novo Livro");
        btNovoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoLivroActionPerformed(evt);
            }
        });

        btAlterarLivroSelecionado.setText("Alterar Livro Selecionado");
        btAlterarLivroSelecionado.setToolTipText("Alterar Livro");
        btAlterarLivroSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarLivroSelecionadoActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir Livro Selecionado");
        btExcluir.setToolTipText("Excluir Livro Selecionado");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        lbQuantidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbQuantidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbQuantidade.setPreferredSize(new java.awt.Dimension(20, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfTituloAutor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btNovoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterarLivroSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTituloAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterarLivroSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lbQuantidade.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoLivroActionPerformed
        Principal.pnPrincipal.AbrirPanel(new PnCadastrarLivro());
    }//GEN-LAST:event_btNovoLivroActionPerformed

    private void btAlterarLivroSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarLivroSelecionadoActionPerformed
        int linhaSelecionada = tbLivro.getSelectedRow();

        if (linhaSelecionada >= 0) {
            Exemplar exemplarSelecionado = exemplares.get(linhaSelecionada);
            Principal.pnPrincipal.AbrirPanel(new PnCadastrarLivro(exemplarSelecionado.getLivro()));
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada, "
                    + "selecione uma linha e clique em Alterar Livro Selecionado", "Nenhuma linha selecionada", 1);
        }
    }//GEN-LAST:event_btAlterarLivroSelecionadoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linhaSelecionada = tbLivro.getSelectedRow();
        sessao = HibernateUtil.abrirConexao();
        
        if (linhaSelecionada >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o exemplar selecionado?","Confirmação de exclusão", 2);
            
            if (opcao == 0) {
                try {
                    Exemplar exemplarSelecionado = exemplares.get(linhaSelecionada);
                    exemplarDao.excluir(exemplarSelecionado, sessao);
                    JOptionPane.showMessageDialog(null, "Exemplar excluído com sucesso!", "Exemplar Excluído", 1);
                    buscarExemplares();
                } catch (HeadlessException | HibernateException e) {
                    System.err.println("Erro ao excluir " + e.getMessage());
                    JOptionPane.showMessageDialog(null, "Exemplar com Status EMPRESTADO não pode ser excluído.\n\n"
                            + "Aguarde sua devolução, para prosseguir com a exclusão.",
                            "Erro ao excluir exemplar emprestado", 0);
                } finally {
                    sessao.close();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha!", "Selecione uma linha", 1);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        buscarExemplares();
        lbQuantidade.setText("Possuímos " + Integer.toString(contarDisponivel) + " livros disponíveis para empréstimo");
        contarDisponivel = 0;
    }//GEN-LAST:event_btBuscarActionPerformed

    private void buscarExemplares() {
        sessao = HibernateUtil.abrirConexao();
        exemplares = exemplarDao.pesquisarPorTituloAutor(tfTituloAutor.getText(), tfTituloAutor.getText(), sessao);
        sessao.close();
        popularTabela(exemplares);
    }

    private void popularTabela(List<Exemplar> exemplares1) {
        tabelaModelo = (DefaultTableModel) tbLivro.getModel();
        tabelaModelo.setNumRows(0);
        
        for (Exemplar exemplar : exemplares1) {
            tabelaModelo.addRow(new Object[]{exemplar.getLivro().getTitulo(), exemplar.getLivro().getAutor(),
                exemplar.getLivro().getEditora(), exemplar.getLivro().getEdicao(), exemplar.getLivro().getIsbn(),
                exemplar.getCodigoLivro(), exemplar.getStatus() ? "Disponível" : "Emprestado"});
            
            if (exemplar.getStatus() == true) {
                contarDisponivel++;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterarLivroSelecionado;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovoLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JTable tbLivro;
    private javax.swing.JTextField tfTituloAutor;
    // End of variables declaration//GEN-END:variables
}
