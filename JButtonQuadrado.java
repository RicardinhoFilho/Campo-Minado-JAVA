/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CampoMinado;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

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
            this.setText("M");
        } else {
            this.setText("");
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
            System.out.println("Perdeu");
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
