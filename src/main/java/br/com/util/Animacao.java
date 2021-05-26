/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.awt.Dimension;

/**
 *
 * @author Felip
 */
public class Animacao extends Thread{
    private javax.swing.JPanel painel;
    private Boolean _isVisible;
    
    public Animacao(javax.swing.JPanel panel, Boolean isVisible){
        painel = panel;
        _isVisible = isVisible;
    }
    @Override
    public void run() {
        if(_isVisible){
            abrir();
        }else{
            fechar();
        }
    }
    
    private void fechar(){
        Dimension menuDimension = painel.getPreferredSize();
        int widthMenu = menuDimension.width;
        for (int i = widthMenu; i >= 0; i--) { 
            if(i > 2){
                i = i - 2;
            }

            try {
                painel.setPreferredSize(new java.awt.Dimension(i, menuDimension.height));
                painel.repaint();
                painel.revalidate();
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                //Logger.getLogger(ErroEfeito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void abrir(){
        Dimension menuDimension = painel.getPreferredSize();
        int widthMenu = 312;
        for (int i = 0; i <= widthMenu; i++) {
            if(i < (widthMenu - 2)){
                i = i + 2;
            }
            try {
                painel.setPreferredSize(new java.awt.Dimension(i, menuDimension.height));
                painel.repaint();
                painel.revalidate();
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                //Logger.getLogger(ErroEfeito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
