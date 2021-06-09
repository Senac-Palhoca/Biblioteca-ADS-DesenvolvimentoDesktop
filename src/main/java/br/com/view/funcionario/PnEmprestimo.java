/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view.funcionario;

import br.com.dao.AlunoDao;
import br.com.dao.AlunoDaoImpl;
import br.com.dao.EmprestimoDao;
import br.com.dao.EmprestimoDaoImpl;
import br.com.dao.ExemplarDao;
import br.com.dao.ExemplarDaoImpl;
import br.com.dao.HibernateUtil;
import br.com.model.Aluno;
import br.com.model.Emprestimo;
import br.com.model.Exemplar;
import br.com.view.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public class PnEmprestimo extends javax.swing.JPanel {

    private Session sessao;
    private Emprestimo emprestimo;
    private EmprestimoDao emprestimoDao;
    private Exemplar exemplar;
    private ExemplarDao exemplarDao;
    private AlunoDao alunoDao;
    private List<Emprestimo> emprestimosAberto;
    private DefaultTableModel tabelaModelo;
    private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/YYYY");

    /**
     * Creates new form PnEmprestimo
     */
    public PnEmprestimo() {
        initComponents();
        emprestimoDao = new EmprestimoDaoImpl();
        exemplarDao = new ExemplarDaoImpl();
        alunoDao = new AlunoDaoImpl();
        listarAtrasados();
        listarAbertos();
        tiraInformacoes();
    }

    private void listarAtrasados() {
        sessao = HibernateUtil.abrirConexao();
        List<Emprestimo> emprestimos = emprestimoDao.listarAtrasados(sessao);
        if (emprestimos.isEmpty()) {
            lbAtraso.setText("Não há livros atrasados.");
        } else {
            lbAtraso.setText("Há " + emprestimos.size() + " livro(s) atrasado(s).");
        }
        sessao.close();
    }

    private void listarAbertos() {
        sessao = HibernateUtil.abrirConexao();
        emprestimosAberto = emprestimoDao.listarTodosEmAberto(sessao);
        sessao.close();
        carregaTabela();
    }

    private void carregaTabela() {
        tabelaModelo = (DefaultTableModel) tbLivro.getModel();
        tabelaModelo.setNumRows(0);
        for (Emprestimo emp : emprestimosAberto) {
            tabelaModelo.addRow(new Object[]{emp.getAluno().getNome(),
                emp.getExemplar().getLivro().getTitulo(),
                emp.getExemplar().getLivro().getAutor(),
                emp.getExemplar().getLivro().getIsbn(),
                dataFormatada.format(emp.getDataRetirada()),
                dataFormatada.format(emp.getDataPrevista())});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btNovoEmprestimo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLivro = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbAtraso = new javax.swing.JLabel();
        txBuscarAluno = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txAluno = new javax.swing.JLabel();
        jLabelAluno = new javax.swing.JLabel();
        txTitulo = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelDevolucao = new javax.swing.JLabel();
        txData = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        btDevolucao = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setText("Emprestimos");

        btNovoEmprestimo.setText("+ Emprestar Livro");
        btNovoEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoEmprestimoActionPerformed(evt);
            }
        });

        tbLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Aluno", "Título", "Autor", "ISNB", "Data Emprestimo", "Data Prev. Dev."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbLivro);

        jPanel1.setBackground(new java.awt.Color(249, 224, 224));

        lbAtraso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbAtraso.setForeground(new java.awt.Color(153, 0, 0));
        lbAtraso.setText("Existem 7 livros em atraso.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbAtraso)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAtraso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar Aluno");

        txAluno.setText("Aluno:");

        jLabelAluno.setText("Aluno");

        txTitulo.setText("Título:");

        jLabelTitulo.setText("Título");

        jLabelDevolucao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelDevolucao.setForeground(new java.awt.Color(200, 0, 0));
        jLabelDevolucao.setText("Devolução Registrada!");

        txData.setText("Data Devolução:");

        jLabelData.setText("00/00/0000");

        btDevolucao.setText("Registrar Devolução");
        btDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDevolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addComponent(btDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txAluno)
                    .addComponent(jLabelAluno)
                    .addComponent(txData)
                    .addComponent(jLabelData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTitulo)
                    .addComponent(jLabelTitulo)
                    .addComponent(jLabelDevolucao))
                .addGap(18, 18, 18)
                .addComponent(btDevolucao)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btNovoEmprestimo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txBuscarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btBuscar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(3, 3, 3)))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovoEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txBuscarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoEmprestimoActionPerformed
        Principal.pnPrincipal.AbrirPanel(new PnEmprestar());
    }//GEN-LAST:event_btNovoEmprestimoActionPerformed

    private void btDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDevolucaoActionPerformed
        int linhaSelecionada = tbLivro.getSelectedRow();
        if (linhaSelecionada >= 0) {
            sessao = HibernateUtil.abrirConexao();
            emprestimo = emprestimosAberto.get(linhaSelecionada);
            emprestimo.setDataDevolucao(new Date());
            exemplar = emprestimo.getExemplar();
            exemplar.setStatus(true);
            try {
                exemplarDao.salvarOuAlterar(exemplar, sessao);
                emprestimoDao.salvarOuAlterar(emprestimo, sessao);
                devolucao();
            } catch (HibernateException h) {
                System.out.println("Erro ao salvar devolução!" + h.getMessage());
            } finally {
                sessao.close();
                listarAbertos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btDevolucaoActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        emprestimosAberto = new ArrayList<>();
        sessao = HibernateUtil.abrirConexao();
        emprestimosAberto = emprestimoDao.pesquisarPorAlunoAberto(txBuscarAluno.getText().trim(), sessao);
        sessao.close();
        if (emprestimosAberto.size() > 0) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado");
        }
        listarAbertos();
//        carregaTabela();
        tiraInformacoes();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tiraInformacoes() {
        txAluno.setVisible(false);
        jLabelAluno.setVisible(false);
        txData.setVisible(false);
        jLabelData.setVisible(false);
        txTitulo.setVisible(false);
        jLabelTitulo.setVisible(false);
        jLabelDevolucao.setVisible(false);
    }

    private void devolucao() {
        txAluno.setVisible(true);
        txData.setVisible(true);
        txTitulo.setVisible(true);
        jLabelAluno.setText(emprestimo.getAluno().getNome());
        jLabelAluno.setVisible(true);
        jLabelTitulo.setText(emprestimo.getExemplar().getLivro().getTitulo());
        jLabelTitulo.setVisible(true);
        jLabelData.setText(dataFormatada.format(new Date()));
        jLabelData.setVisible(true);
        jLabelDevolucao.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btDevolucao;
    private javax.swing.JButton btNovoEmprestimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAluno;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDevolucao;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAtraso;
    private javax.swing.JTable tbLivro;
    private javax.swing.JLabel txAluno;
    private javax.swing.JTextField txBuscarAluno;
    private javax.swing.JLabel txData;
    private javax.swing.JLabel txTitulo;
    // End of variables declaration//GEN-END:variables
}
