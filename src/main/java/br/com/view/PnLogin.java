/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.dao.HibernateUtil;
import br.com.dao.PessoaDao;
import br.com.dao.PessoaDaoImpl;
import br.com.model.Aluno;
import br.com.model.Funcionario;
import br.com.model.Pessoa;
import br.com.view.admin.PnCursoTurma;
import br.com.view.aluno.PnMeuEmprestimo;
import br.com.view.funcionario.PnEmprestimo;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Felip
 */
public class PnLogin extends javax.swing.JPanel {

    private PessoaDao pessoaDao;
    private Session sessao;

    /**
     * Creates new form PnLogin
     */
    public PnLogin() {
        pessoaDao = new PessoaDaoImpl();
        initComponents();
    }

    private void abrir(String perfil, javax.swing.JPanel panelInicial) {
        PnPrincipal pnPrincipal = new PnPrincipal(perfil);
        Principal.pnPrincipal = pnPrincipal;
        Principal.pnPrincipal.AbrirPanel(panelInicial);
        Principal.principal.setContentPane(pnPrincipal);
        Principal.principal.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        lbEsqueciSenha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txSenha = new javax.swing.JPasswordField();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setBackground(new java.awt.Color(59, 50, 135));

        jPanel1.setBackground(new java.awt.Color(59, 50, 135));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Senha");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/imagem/senac_logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Sitka Subheading", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login Biblioteca");

        btLogin.setText("Logar");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        lbEsqueciSenha.setForeground(new java.awt.Color(204, 204, 255));
        lbEsqueciSenha.setText("Esqueci a senha");
        lbEsqueciSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbEsqueciSenhaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbEsqueciSenhaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbEsqueciSenhaMousePressed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");

        txSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txUsuario)
                    .addComponent(btLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEsqueciSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)))
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbEsqueciSenha)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addGap(13, 13, 13))
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262)
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(filler5, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler6, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        validarLogin();
        btLogin.setText("Aguarde...");
        btLogin.setEnabled(false);
    }//GEN-LAST:event_btLoginActionPerformed

    private void lbEsqueciSenhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEsqueciSenhaMouseEntered
        lbEsqueciSenha.setForeground(new java.awt.Color(204, 255, 255));
    }//GEN-LAST:event_lbEsqueciSenhaMouseEntered

    private void lbEsqueciSenhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEsqueciSenhaMouseExited
        lbEsqueciSenha.setForeground(new java.awt.Color(204, 204, 255));
    }//GEN-LAST:event_lbEsqueciSenhaMouseExited

    private void lbEsqueciSenhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEsqueciSenhaMousePressed
        JOptionPane.showMessageDialog(null, "Azar o seu! Método não implementado.");
    }//GEN-LAST:event_lbEsqueciSenhaMousePressed

    private void validarLogin() {
        new Thread() {
            public void run() {
                try {
                    sessao = HibernateUtil.abrirConexao();
                    Pessoa pessoa = pessoaDao.login(txUsuario.getText(), new String(txSenha.getPassword()), sessao);

                    if (pessoa != null) {
                        Principal.usuario = pessoa;
                        if (pessoa instanceof Aluno) {
                            abrir("aluno", new PnMeuEmprestimo());
                        } else if (pessoa instanceof Funcionario) {
                            if (pessoa.getPerfil().getFuncao().toLowerCase().equals("admin") || pessoa.getPerfil().getFuncao().toLowerCase().equals("administrador")) {
                                abrir("admin", new PnCursoTurma());
                            } else {
                                abrir("funcionario", new PnEmprestimo());
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário/senha inválido ou inexistente.");
                        txSenha.setText("");
                        btLogin.setText("Logar");
                        btLogin.setEnabled(true);
                    }
                } catch (Exception e) {
                } finally{
                    //sessao.close();
                }
            }
        }.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbEsqueciSenha;
    private javax.swing.JPasswordField txSenha;
    private javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables
}
