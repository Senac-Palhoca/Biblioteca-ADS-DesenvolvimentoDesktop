/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view.aluno;

import br.com.dao.EmprestimoDao;
import br.com.dao.EmprestimoDaoImpl;
import br.com.dao.HibernateUtil;
import br.com.model.Aluno;
import br.com.model.Emprestimo;
import br.com.view.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author Felip
 */
public class PnMeuEmprestimo extends javax.swing.JPanel {
    private Session sessao;
    private EmprestimoDao emprestimoDao;
    private List<Emprestimo> emprestimosAberto;
    private DefaultTableModel tabelaModelo;
    private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/YYYY");
    private Aluno aluno;
    /**
     * Creates new form PnEmprestimo
     */
    public PnMeuEmprestimo() {
        initComponents();
        if(Principal.usuario instanceof Aluno){
            this.aluno = (Aluno)Principal.usuario;
        }else{
            JOptionPane.showMessageDialog(null, "O Método de login deve estar implementado para a tela MeuEmprestimo funcionar.");
            this.aluno = new Aluno();
        }
        
        emprestimoDao = new EmprestimoDaoImpl();
        listarLivrosAbertos();
        livrosAtradados();
        popularTabela();
    }

    private void listarLivrosAbertos(){
        sessao = HibernateUtil.abrirConexao();
        emprestimosAberto = emprestimoDao.pesquisarPorAlunoAbertoId(aluno.getId(), sessao);
        sessao.close();
    }
    
    private void livrosAtradados(){
        int i = 0;
        for (Emprestimo emprestimo : emprestimosAberto) {
            if(emprestimo.getDataDevolucao() == null && emprestimo.getDataPrevista().before(new Date())){
                i++;
            }
        }        
        if(i == 0){
            lbAtrasado.setText("Você não possui livros em atraso.");
            pnAtraso.setVisible(false);
        }else{
            pnAtraso.setVisible(true);
            lbAtrasado.setText("Você possui "+ i + " livro(s) atrasado(s).");
        }
    }
    
    private void popularTabela(){
        tabelaModelo = (DefaultTableModel) tbEmprestimo.getModel();
        tabelaModelo.setNumRows(0);
        for (Emprestimo emprestimo : emprestimosAberto) {
            tabelaModelo.addRow(new Object[]{
                emprestimo.getExemplar().getLivro().getTitulo(),
                emprestimo.getExemplar().getLivro().getAutor(),
                dataFormatada.format(emprestimo.getDataRetirada()),
                dataFormatada.format(emprestimo.getDataPrevista())});
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
        pnAtraso = new javax.swing.JPanel();
        lbAtrasado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmprestimo = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setText("Meus Empréstimos");

        pnAtraso.setBackground(new java.awt.Color(249, 224, 224));

        lbAtrasado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbAtrasado.setForeground(new java.awt.Color(153, 0, 0));
        lbAtrasado.setText("Atenção! Você possui 3 livros atrasados.");

        javax.swing.GroupLayout pnAtrasoLayout = new javax.swing.GroupLayout(pnAtraso);
        pnAtraso.setLayout(pnAtrasoLayout);
        pnAtrasoLayout.setHorizontalGroup(
            pnAtrasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAtrasoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbAtrasado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnAtrasoLayout.setVerticalGroup(
            pnAtrasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAtrasado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        tbEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título", "Autor", "Data Retirada", "Data Prevista para Devolução"
            }
        ));
        jScrollPane1.setViewportView(tbEmprestimo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnAtraso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAtrasado;
    private javax.swing.JPanel pnAtraso;
    private javax.swing.JTable tbEmprestimo;
    // End of variables declaration//GEN-END:variables
}
