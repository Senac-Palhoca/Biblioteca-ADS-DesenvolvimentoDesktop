/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view.funcionario;

import br.com.dao.AlunoDaoImpl;
import br.com.dao.EmprestimoDao;
import br.com.dao.EmprestimoDaoImpl;
import br.com.dao.HibernateUtil;
import br.com.dao.TurmaDao;
import br.com.dao.TurmaDaoImpl;
import br.com.model.Aluno;
import br.com.model.Turma;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Felipe
 */
public class PnRankingLeitura extends javax.swing.JPanel {

    private DefaultTableModel tabelaModelo;
    private Session sessao;
    private List<Turma> turmas;
    private AlunoDaoImpl alunoDao;
    private TurmaDao turmaDao;
    private EmprestimoDao emprestimoDao;

    public PnRankingLeitura() {
        initComponents();
        cbMes.setSelectedIndex(0);
        txAno.setText("2021");
        tabelaModelo = (DefaultTableModel) tbRanking.getModel();
        popularListaTurma();
    }

    private void popularListaTurma() {
        List<String> strList = new ArrayList<>();
        strList.add("Todas Turmas");
        strList.add("Todos Alunos");

        listarTurma();
        for (Turma tu : turmas) {
            strList.add(tu.getCurso().getNome() + " - " + tu.getNome());
        }
        DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(strList.toArray());
        cbTurma.setModel(defaultComboBox);
    }

    private void listarTurma() {
        turmaDao = new TurmaDaoImpl();
        sessao = HibernateUtil.abrirConexao();
        turmas = turmaDao.listarTodos(sessao);
        sessao.close();
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
        cbTurma = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRanking = new javax.swing.JTable();
        txAno = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setText("Ranking Leitura");

        cbTurma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas Turmas" }));
        cbTurma.setMinimumSize(new java.awt.Dimension(120, 20));

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        cbMes.setMinimumSize(new java.awt.Dimension(120, 20));

        jLabel3.setText("Mês:");

        jLabel4.setText("Ano:");

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltrarActionPerformed(evt);
            }
        });

        tbRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aluno", "Turma", "Curso", "Qtd. Emprestimos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRanking.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbRanking);

        txAno.setText("2020");
        txAno.setMaximumSize(new java.awt.Dimension(100, 20));
        txAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txAnoKeyPressed(evt);
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
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txAno, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(btFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btFiltrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
        tabelaModelo.setNumRows(0);
        String mes = Integer.toString(cbMes.getSelectedIndex());
        if (mes.length() == 1) {
            mes = "0" + mes;
        }
        switch (cbTurma.getSelectedIndex()) {
            case 0:
                if (cbMes.getSelectedIndex() == 0) {
                    todasTurmasTodosMeses();
                } else {
                    todasTurmasNoMes(mes);
                }
                break;
            case 1:

                if (cbMes.getSelectedIndex() == 0) {
                    todosAlunosTodosMeses();
                } else {
                    todosAlunosNoMes(mes);
                }
                break;
            default:
                if (cbMes.getSelectedIndex() == 0) {
                    turmaTodosMeses();
                } else {
                    alunosTurmaMes(mes);
                }
                break;
        }
    }//GEN-LAST:event_btFiltrarActionPerformed

    private void alunosTurmaMes(String mes) throws HibernateException {
        turmaDao = new TurmaDaoImpl();
        emprestimoDao = new EmprestimoDaoImpl();
        sessao = HibernateUtil.abrirConexao();
        List<Aluno> alunos = turmaDao.pesquisarPorId(turmas.get(cbTurma.getSelectedIndex() - 2).getId(), sessao).getAlunos();
        for (Aluno alun : alunos) {
            alun.setEmprestimos(emprestimoDao.pesquisarPorAlunoMes(alun, mes, txAno.getText(), sessao));
        }
        alunos.sort((s1, s2) -> Integer.compare(s2.getEmprestimos().size(), s1.getEmprestimos().size()));
        for (Aluno aluno : alunos) {
            tabelaModelo.addRow(new Object[]{aluno.getNome(),
                aluno.getTurma().getNome(),
                aluno.getTurma().getCurso().getNome(),
                aluno.getEmprestimos().size()});
        }
        sessao.close();
    }

    private void turmaTodosMeses() throws HibernateException {
        sessao = HibernateUtil.abrirConexao();
        Turma turma = turmaDao.pesquisarPorId(turmas.get(cbTurma.getSelectedIndex() - 2).getId(), sessao);
        List<Aluno> alunosTurma = turma.getAlunos();
        alunosTurma.sort((s1, s2) -> Integer.compare(s2.getEmprestimos().size(), s1.getEmprestimos().size()));
        for (Aluno aluno : alunosTurma) {
            tabelaModelo.addRow(new Object[]{aluno.getNome(),
                aluno.getTurma().getNome(),
                aluno.getTurma().getCurso().getNome(),
                aluno.getEmprestimos().size()});
        }
        sessao.close();
    }

    private void todosAlunosNoMes(String mes) throws HibernateException {
        alunoDao = new AlunoDaoImpl();
        sessao = HibernateUtil.abrirConexao();
        List<Aluno> alunos = alunoDao.listarTodos(sessao);
        for (Aluno aluno : alunos) {
            aluno.setEmprestimos(emprestimoDao.pesquisarPorAlunoMes(aluno, mes, txAno.getText(), sessao));
        }
        alunos.sort((s1, s2) -> Integer.compare(s2.getEmprestimos().size(), s1.getEmprestimos().size()));
        for (Aluno aluno : alunos) {
            tabelaModelo.addRow(new Object[]{aluno.getNome(),
                aluno.getTurma().getNome(),
                aluno.getTurma().getCurso().getNome(),
                aluno.getEmprestimos().size()});
        }
        sessao.close();
    }

    private void todosAlunosTodosMeses() throws HibernateException {
        alunoDao = new AlunoDaoImpl();
        sessao = HibernateUtil.abrirConexao();
        List<Aluno> alunos = alunoDao.listarTodos(sessao);
        sessao.close();
        alunos.sort((s1, s2) -> Integer.compare(s2.getEmprestimos().size(), s1.getEmprestimos().size()));
        for (Aluno aluno : alunos) {
            tabelaModelo.addRow(new Object[]{aluno.getNome(),
                aluno.getTurma().getNome(),
                aluno.getTurma().getCurso().getNome(),
                aluno.getEmprestimos().size()});
        }
    }

    private void todasTurmasNoMes(String mes) throws HibernateException {
        emprestimoDao = new EmprestimoDaoImpl();
        sessao = HibernateUtil.abrirConexao();
        List<Turma> turmaMes = turmas;
        for (Turma turmaMe : turmaMes) {
            turmaMe.setQuantidadeEmprestimo(emprestimoDao.pesquisarPorTurmaMes(turmaMe.getId(), mes, txAno.getText(), sessao).size());
        }
        sessao.close();
        turmaMes.sort((t1, t2) -> Integer.compare(t2.getQuantidadeEmprestimo(), t1.getQuantidadeEmprestimo()));
        for (Turma turma : turmaMes) {
            tabelaModelo.addRow(new Object[]{"        ------",
                turma.getNome(),
                turma.getCurso().getNome(),
                turma.getQuantidadeEmprestimo()});
        }
    }

    private void todasTurmasTodosMeses() throws HibernateException {
        turmaDao = new TurmaDaoImpl();
        sessao = HibernateUtil.abrirConexao();
        List<Turma> turmasRanking = turmaDao.listarRanking(sessao);
        sessao.close();
        for (Turma turma : turmasRanking) {
            tabelaModelo.addRow(new Object[]{"        ------",
                turma.getNome(),
                turma.getCurso().getNome(),
                turma.getQuantidadeEmprestimo()});
        }
    }

    private void txAnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAnoKeyPressed
        JTextField jtf = (JTextField) evt.getComponent();
        int i = jtf.getText().length();
        if (i > 3)
            jtf.setText(jtf.getText().substring(0, --i));
    }//GEN-LAST:event_txAnoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFiltrar;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JComboBox<String> cbTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbRanking;
    private javax.swing.JTextField txAno;
    // End of variables declaration//GEN-END:variables
}
