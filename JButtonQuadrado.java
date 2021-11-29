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
    private Quadrado quadrado;
    private Tela tela;

    public Quadrado getQuadrado() {
        return quadrado;
    }

    public JButtonQuadrado(Quadrado quadrado, Tela tela) {
        this.tela = tela;
        this.quadrado = quadrado;
        this.addActionListener((java.awt.event.ActionEvent evt) -> {
            acaoBotao(evt);
        });
    }

    private void acaoBotao(java.awt.event.ActionEvent evt) {
        //se for minado

        //se não for minado
        this.clicar();

    }

    public void clicar() {
        int vizinhosMinados = this.quadrado.revelar();
        if (vizinhosMinados == -1) {
            this.tela.revelarMinas();
            return;
        }
        if (vizinhosMinados == 0) {
            for (Quadrado vizinho : quadrado.getVizinhos()) {
                revelar(Integer.toString(vizinhosMinados));
                if (!vizinho.isClicado()) {
                    vizinho.getBotaoFisico().clicar();
                }

            };
        }
        revelar(Integer.toString(vizinhosMinados));

    }

    public void setPos(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void revelar(String n) {

        this.setText(n);
        this.setEnabled(false);
        quadrado.clicar();
    }

}
