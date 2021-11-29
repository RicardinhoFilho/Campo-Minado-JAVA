/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CampoMinado;

import java.util.Random;

/**
 *
 * @author User
 */
public class CampoDeJogo {

    private Quadrado[][] matriz;
    private Integer linhas = 0;
    private Integer colunas = 0;
    private Integer minas = 0;
    
    
    public Integer getLinhas(){
        return this.linhas;
    }

    public Integer getColunas(){
        return this.colunas;
    }

    public CampoDeJogo(int nivel) {

        System.out.println("Nivel: " + nivel);

        if (nivel == 0) {
            this.linhas = 9;

            this.colunas = 9;

            this.minas = 10;
        } else if (nivel == 1) {
            this.linhas = 16;
            this.colunas = 16;
            this.minas = 40;
        } else if (nivel == 2) {
            this.linhas = 30;
            this.colunas = 16;
            this.minas = 99;
        }

        this.matriz = new Quadrado[linhas][colunas];

        for (int lin = 0; lin < this.linhas; lin++) {
            for (int col = 0; col < this.colunas; col++) {
                this.matriz[lin][col] = new Quadrado();
            }
        }

        for (int lin = 0; lin < this.linhas; lin++) {
            for (int col = 0; col < this.colunas; col++) {

                if (lin > 0) {
                    if (col > 0) {
                        matriz[lin][col].adicionar_vizinho(matriz[lin - 1][col - 1]);
                    }
                    matriz[lin][col].adicionar_vizinho(matriz[lin - 1][col]);
                    if (col < this.colunas - 1) {
                        matriz[lin][col].adicionar_vizinho(matriz[lin - 1][col + 1]);
                    }
                }

                if (col > 0) {
                    matriz[lin][col].adicionar_vizinho(matriz[lin][col - 1]);
                }
                if (col < this.colunas - 1) {
                    matriz[lin][col].adicionar_vizinho(matriz[lin][col + 1]);
                }

                if (lin < this.linhas - 1) {
                    if (col > 0) {
                        matriz[lin][col].adicionar_vizinho(matriz[lin + 1][col - 1]);
                    }
                    matriz[lin][col].adicionar_vizinho(matriz[lin + 1][col]);
                    if (col < this.colunas - 1) {
                        matriz[lin][col].adicionar_vizinho(matriz[lin + 1][col + 1]);
                    }

                }

            }
        }

        this.adicionar_minas();
    }

    public void adicionar_minas() {
        int n = this.minas;
        Random rand = new Random();
        while (n > 0) {

            int l = rand.nextInt(this.linhas);
            int c = rand.nextInt(this.colunas);

            boolean teste_minar = this.matriz[l][c].plantar_mina();

            if (teste_minar) {
                n--;
            }

        }
    }

    
    
    public int clicar(int linha, int coluna){
        return this.matriz[linha][coluna].revelar();
    }
    
    
    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                str += this.matriz[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

}
