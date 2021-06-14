package br.com.view.funcionario;

import br.com.dao.*;
import br.com.model.*;
import br.com.view.Principal;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 *
 */
public class PnCadastrarLivro extends javax.swing.JPanel {

    private Session sessao;
    private Livro livro;
    private Exemplar exemplar;
    private LivroDao livroDao;
    private ExemplarDao exemplarDao;
    private DefaultTableModel tabelaModelo;
    private List<Exemplar> exemplares;

    public PnCadastrarLivro() {
        initComponents();
        this.livro = new Livro();
        livroDao = new LivroDaoImpl();
        exemplarDao = new ExemplarDaoImpl();
    }

    public PnCadastrarLivro(Livro livro) {
        initComponents();
        this.livro = livro;
        livroDao = new LivroDaoImpl();
        exemplarDao = new ExemplarDaoImpl();
        carregarLivro();
        btSalvarLivro.setText("Alterar Livro");
        btSalvarExemplar.setText("Adicionar Exemplar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        tfTituloCadastrarLivro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        txAutor = new javax.swing.JLabel();
        tfAutor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfEdicao = new javax.swing.JTextField();
        tfEditora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfIsbn = new javax.swing.JTextField();
        btSalvarLivro = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfCodigoLivro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCodigoLivro = new javax.swing.JTable();
        btSalvarExemplar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);

        tfTituloCadastrarLivro.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        tfTituloCadastrarLivro.setText("Cadastrar Livro");

        jLabel3.setText("Título");

        txAutor.setText("Autor");

        jLabel6.setText("Editora");

        jLabel5.setText("Edição");

        tfEdicao.setVerifyInputWhenFocusTarget(false);

        jLabel7.setText("ISBN");

        btSalvarLivro.setText("Salvar Livro");
        btSalvarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarLivroActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        jLabel2.setText("Código");

        tbCodigoLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do Exemplar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCodigoLivro);

        btSalvarExemplar.setText("Salvar Exemplar");
        btSalvarExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarExemplarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(tfTituloCadastrarLivro)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfTitulo)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfEdicao)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfIsbn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(tfCodigoLivro)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btSalvarExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62))))
                            .addComponent(tfAutor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txAutor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btSalvarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tfTituloCadastrarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCodigoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSalvarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSalvarExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limparLivro();
        limparExemplar();
        tabelaModelo.setNumRows(0);
    }//GEN-LAST:event_btLimparActionPerformed

    private void btSalvarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarLivroActionPerformed
        salvarLivro();
    }//GEN-LAST:event_btSalvarLivroActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        Principal.pnPrincipal.AbrirPanel(new PnLivro());
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btSalvarExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarExemplarActionPerformed
        salvarExemplar();
        popularTabelaExemplar();
    }//GEN-LAST:event_btSalvarExemplarActionPerformed

    private void popularTabelaExemplar() {
        tabelaModelo = (DefaultTableModel) tbCodigoLivro.getModel();
        tabelaModelo.setNumRows(0);
        List<Exemplar> exemplaresLivro = new ArrayList<>();
        sessao = HibernateUtil.abrirConexao();
        exemplares = exemplarDao.listarTodos(sessao);
        sessao.close();

        for (Exemplar exemplar : exemplares) {
            if (exemplar.getLivro().getTitulo().equals(livro.getTitulo())) {
                if (exemplar.getCondicao() == true) {
                    exemplaresLivro.add(exemplar);
                }
            }
        }

        for (Exemplar exemplar1 : exemplaresLivro) {
            tabelaModelo.addRow(new Object[]{exemplar1.getCodigoLivro()});
        }
    }

    private void salvarLivro() {
        if (!validarLivro()) {
            try {
                sessao = HibernateUtil.abrirConexao();
                setarLivro();
                livroDao.salvarOuAlterar(livro, sessao);
                sessao.close();
                if (btSalvarLivro.getText().equals("Salvar Livro")) {
                    JOptionPane.showMessageDialog(null, "Livro Salvo com sucesso!", "Livro Salvo", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!", "Livro Alterado", 1);
                }
            } catch (Exception e) {
                System.err.println("Erro a salvar Livro - Causa: " + e);
            } finally {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todas os campos corretamente", "Campos em Branco", 1);
        }
    }

    private void setarLivro() {
        livro.setTitulo(tfTitulo.getText());
        livro.setAutor(tfAutor.getText());
        livro.setEditora(tfEditora.getText());
        livro.setEdicao(tfEdicao.getText());
        livro.setIsbn(tfIsbn.getText());
    }

    private void carregarLivro() {
        tfTitulo.setText(livro.getTitulo());
        tfAutor.setText(livro.getAutor());
        tfEditora.setText(livro.getEditora());
        tfEdicao.setText(livro.getEdicao());
        tfIsbn.setText(livro.getIsbn());
        popularTabelaExemplar();
    }

    private void salvarExemplar() {
        if (!validarExemplar()) {
            try {
                exemplar = new Exemplar();
                exemplar.setStatus(true);
                exemplar.setCondicao(true);
                exemplar.setCodigoLivro(tfCodigoLivro.getText());
                exemplar.setLivro(livro);

                if (exemplar.getLivro().getId() != null) {
                    sessao = HibernateUtil.abrirConexao();
                    exemplarDao.salvarOuAlterar(exemplar, sessao);
                    sessao.close();
                    popularTabelaExemplar();

                    if (btSalvarExemplar.getText().equals("Salvar Exemplar")) {
                        JOptionPane.showMessageDialog(null, "Exemplar salvo com sucesso!", "Exemplar Salvo", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Exemplar adicionado com sucesso!", "Exemplar Adicionado", 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Precisa salvar o livro primeiro", "Salvar Livro", 0);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Código do exemplar já cadastrado.\n\nCadastre um novo código!", "Verfique Código Exemplar", 0);
                System.err.println("Erro a salvar Exemplar - Causa: " + e);
            } finally {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente", "Verfique campos vazios", 0);
        }
    }

    private boolean validarLivro() {
        boolean erro = false;

        String tituloLivro = tfTitulo.getText().trim();
        if (tituloLivro.length() < 1) {
            erro = true;
        }

        String autorLivro = tfAutor.getText().trim();
        if (autorLivro.length() < 1) {
            erro = true;
        }

        String editoraLivro = tfEditora.getText().trim();
        if (editoraLivro.length() < 1) {
            erro = true;
        }

        String isbnLivro = tfIsbn.getText().trim();
        if (isbnLivro.length() < 1) {
            erro = true;
        }

        return erro;
    }

    private boolean validarExemplar() {
        boolean erro = false;

        String codigoLivro = tfCodigoLivro.getText().trim();
        if (codigoLivro.length() < 1) {
            erro = true;

        }

        return erro;
    }

    private void limparLivro() {
        livro = null;
        tfTitulo.setText("");
        tfAutor.setText("");
        tfEdicao.setText("");
        tfEditora.setText("");
        tfIsbn.setText("");
        tfCodigoLivro.setText("");
    }

    private void limparExemplar() {
        exemplar = null;
        tfCodigoLivro.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvarExemplar;
    private javax.swing.JButton btSalvarLivro;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbCodigoLivro;
    private javax.swing.JTextField tfAutor;
    private javax.swing.JTextField tfCodigoLivro;
    private javax.swing.JTextField tfEdicao;
    private javax.swing.JTextField tfEditora;
    private javax.swing.JTextField tfIsbn;
    private javax.swing.JTextField tfTitulo;
    private javax.swing.JLabel tfTituloCadastrarLivro;
    private javax.swing.JLabel txAutor;
    // End of variables declaration//GEN-END:variables
}
