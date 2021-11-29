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

    public Tela(Integer linhas, Integer colunas,CampoDeJogo campo) {
        this.campo = campo;
        this.panel = new JPanel();
        this.add(panel);
        this.panel.setLayout(null);
         int n = 0;

        this.botao = new JButtonQuadrado[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
               
                this.botao[i][j] = new JButtonQuadrado(campo);
                this.botao[i][j].setPos(i,j);
                this.botao[i][j].setSize(80, 80);
                this.botao[i][j].setLocation(80 * j, 80 * i);
                 this.botao[i][j].setText(Integer.toString(n++));
                
                this.panel.add(this.botao[i][j]);
            }

        }

        configuracoesPadrao(linhas, colunas);
    }

    private void configuracoesPadrao(int linhas, int colunas) {

        this.setVisible(true);
        this.setSize(linhas  * 80 + 200, colunas * 80 + 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
