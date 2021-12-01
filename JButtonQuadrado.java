/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CampoMinado;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.Color;

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
            acaoBotao(false);
        });

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    acaoBotao(true);
                }
            }
        });

    }

    private void acaoBotao(boolean mouseBotaoDireito) {

        if (!mouseBotaoDireito) {

            clicar();
        } else {
            marcar();
        }
        this.tela.checkIsFinalizado();
    }

    public void marcar() {

        if (this.quadrado.isClicado()) {
            return;
        }
        boolean isMarcado = this.quadrado.marcar_desmarcar();
        if (isMarcado) {
            if (this.tela.marcarBandeira() != -1) {

                this.setText("M");
            }

        } else {
            if (this.tela.desmarcarBandeira() != -1) {
                this.setText("");
            }

        }
    }

    public void clicar() {
        if (this.quadrado.isMarcado()) {
            return;
        }

        int vizinhosMinados = this.quadrado.revelar();
        if (vizinhosMinados == -1) {
            this.tela.revelarMinas();
            this.tela.desativarBotoes();
            this.tela.perdeu();
            return;
        }
        if (vizinhosMinados == 0) {
            for (Quadrado vizinho : quadrado.getVizinhos()) {
                revelar(vizinhosMinados);
                if (!vizinho.isClicado()) {
                    vizinho.getBotaoFisico().clicar();
                }

            };
        }
        revelar(vizinhosMinados);

    }

    public void setPos(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void revelar(int n) {
       //System.out.println("N = "+ n);
        if(n==1){
            this.setBackground(new Color(3, 59, 90).brighter());
        }
        
         if(n==2){
            this.setBackground(Color.GREEN.brighter());
        }
         
          if(n==3){
            this.setBackground(Color.ORANGE.brighter());
        }
          
          if(n==4){
            this.setBackground(Color.RED.brighter());
        }
          
          if(n > 4){
                this.setBackground(Color.PINK.brighter());
          }
            
       
        this.setText(Integer.toString(n));
        this.setEnabled(false);
        quadrado.clicar();
    }

}
