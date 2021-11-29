/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CampoMinado;

import javax.swing.JButton;

/**
 *
 * @author User
 */
public class JButtonQuadrado extends JButton {
    
    private int linha;
    private int coluna;
    CampoDeJogo campo;
    
    
        public JButtonQuadrado(CampoDeJogo c){
            this.campo = c;
            this.addActionListener((java.awt.event.ActionEvent evt)->{
                acaoBotao(evt);
            });
        }
    
    private void acaoBotao(java.awt.event.ActionEvent evt){
        //System.out.println("POSIÇÃO: " + this.linha + "x" + this.coluna);
    int valor = campo.clicar(this.linha, this.coluna);
    this.setText(Integer.toString(valor));
        //System.out.println("POSIÇÃO: " + this.linha + "x" + this.coluna);
    }
    
    public void setPos(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
    
}
