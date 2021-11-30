/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CampoMinado;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 *
 * @author User
 */
public class Tela extends JFrame {

    private JPanel panel;
    private JButtonQuadrado botao[][];
    private CampoDeJogo campo;
    JButton resetButton;
    JButton facilButton;
    JButton medioButton;
    JButton dificilButton;
    int tamanhoBotao = 45;

    private void resetarMatriz(int nivel) {
       
        this.campo = new CampoDeJogo(nivel);
        int linhas = campo.getLinhas();
        int colunas = campo.getColunas();
        renderizaQuadrados(linhas, colunas);
    }

    private void renderizaQuadrados(int linhas, int colunas) {
        this.botao = new JButtonQuadrado[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {

                this.botao[i][j] = new JButtonQuadrado(campo.getQuadrado(i, j), this);
                campo.getQuadrado(i, j).setButton(this.botao[i][j]);
                this.botao[i][j].setPos(i, j);
                this.botao[i][j].setSize(tamanhoBotao, tamanhoBotao);
                this.botao[i][j].setLocation(tamanhoBotao * j, tamanhoBotao * i + 100);
                //this.botao[i][j].setText(Integer.toString(n++));

                this.panel.add(this.botao[i][j]);

            }

        }
    }

    private void reiniciarPorNivel(int nivel) {
        CampoMinado.hardReset(nivel);
        this.dispose();
      
    }

    public Tela(int nivel) {
        this.panel = new JPanel();
        this.add(panel);
        this.panel.setLayout(null);
        int n = 0;
        this.campo = new CampoDeJogo(nivel);
        int linhas = campo.getLinhas();
        int colunas = campo.getColunas();
        renderizaQuadrados(linhas, colunas);

        this.resetButton = new JButton();
        this.resetButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            this.resetar();
        });
        this.setSize(20 * this.tamanhoBotao, 20 * this.tamanhoBotao + 100);
        this.resetButton.setLocation(5, 100 / 2);
        panel.add(this.resetButton);

        this.facilButton = new JButton("F");
        this.facilButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            this.reiniciarPorNivel(0);

        });
        this.facilButton.setSize(this.tamanhoBotao, this.tamanhoBotao);
        this.facilButton.setLocation(this.tamanhoBotao / 4, 0);
        panel.add(this.facilButton);

        this.medioButton = new JButton("M");
        this.medioButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            this.reiniciarPorNivel(1);

        });
        this.medioButton.setSize(this.tamanhoBotao, this.tamanhoBotao);
        this.medioButton.setLocation(this.tamanhoBotao / 4 * 10, 0);
        panel.add(this.medioButton);

        this.dificilButton = new JButton("D");
        this.dificilButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            this.reiniciarPorNivel(2);
        });
        this.dificilButton.setSize(this.tamanhoBotao, this.tamanhoBotao);
        this.dificilButton.setLocation(this.tamanhoBotao / 4 * 20, 0);
        panel.add(this.dificilButton);
        configuracoesPadrao(20, 20);
    }

    private void resetar() {
        for (int i = 0; i < this.campo.getLinhas(); i++) {
            for (int j = 0; j < this.campo.getLinhas(); j++) {
                JButtonQuadrado botao = this.botao[i][j];

                botao.setEnabled(true);
                botao.setText("");
                //this.campo = new CampoDeJogo(0); 
            }
        }
    }

    private void configuracoesPadrao(int linhas, int colunas) {
        System.out.println(linhas + " - " + colunas);

        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.resetButton.setSize(tamanhoBotao, tamanhoBotao);

    }

    public void revelarMinas() {
        for (int i = 0; i < this.campo.getLinhas(); i++) {
            for (int j = 0; j < this.campo.getLinhas(); j++) {
                JButtonQuadrado botao = this.botao[i][j];
                if (botao.getQuadrado().getMina()) {
                    botao.revelar("-1");
                }
            }

        }
    }

    public void desativarBotoes() {
        for (int i = 0; i < this.campo.getLinhas(); i++) {
            for (int j = 0; j < this.campo.getLinhas(); j++) {
                JButtonQuadrado botao = this.botao[i][j];

                botao.setEnabled(false);
            }
        }
    }

    public void checkIsFinalizado() {
        System.out.println("Verificando Ganhador");
        if (this.campo.ganhou()) {
            System.out.println("Venceu");
        }

    }
}
