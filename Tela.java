/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CampoMinado;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Tela extends JFrame {
    
    private JPanel panel;
    private JButtonQuadrado botao[][];
    private CampoDeJogo campo;
    
    
    public Tela(CampoDeJogo campo) {
        int linhas = campo.getLinhas();
        int colunas = campo.getColunas();
        this.campo = campo;
        this.panel = new JPanel();
        this.add(panel);
        this.panel.setLayout(null);
        int n = 0;
        
        this.botao = new JButtonQuadrado[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                
                this.botao[i][j] = new JButtonQuadrado(campo.getQuadrado(i, j), this);
                campo.getQuadrado(i, j).setButton(this.botao[i][j]);
                this.botao[i][j].setPos(i, j);
                this.botao[i][j].setSize(50, 50);
                this.botao[i][j].setLocation(50 * j, 50 * i);
                //this.botao[i][j].setText(Integer.toString(n++));

                this.panel.add(this.botao[i][j]);
            }
            
        }
        
        configuracoesPadrao(linhas, colunas);
    }
    
    private void configuracoesPadrao(int linhas, int colunas) {
        
        this.setVisible(true);
        this.setSize(linhas * 55, colunas * 55);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void revelarMinas(){
            for (int i = 0; i < this.campo.getLinhas(); i++) {
            for (int j = 0; j < this.campo.getLinhas(); j++) {
               JButtonQuadrado botao = this.botao[i][j];
                if(botao.getQuadrado().getMina()){
                    botao.revelar("-1");
                }
            }
            
        } 
    }
    
    
    public void checkIsFinalizado(){
        this.campo.finalizado();
    }
}
