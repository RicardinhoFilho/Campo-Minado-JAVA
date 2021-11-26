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

    public CampoDeJogo(int nivel) {
        int linhas = 0;
        int colunas = 0;
        int minas = 0;
        if (nivel == 0) {
            linhas = 9;
            colunas = 9;
            minas = 10;
        }
        
        
         this.matriz = new Quadrado[linhas][colunas];

        for (int lin = 0; lin < linhas; lin++) {
            for (int col = 0; col < colunas; col++) {
                this.matriz[lin][col] = new Quadrado();
            }
        }
       
        for (int lin = 0; lin < linhas; lin++) {
            for (int col = 0; col < colunas; col++) {

                if (lin > 0) {
                    if (col > 0) {
                        matriz[lin][col].adicionar_vizinho(matriz[lin - 1][col - 1]);
                    }
                    matriz[lin][col].adicionar_vizinho(matriz[lin - 1][col]);
                    if (col < colunas - 1) {
                        matriz[lin][col].adicionar_vizinho(matriz[lin - 1][col + 1]);
                    }
                }

                if (col > 0) {
                    matriz[lin][col].adicionar_vizinho(matriz[lin][col - 1]);
                }
                if (col < colunas - 1) {
                    matriz[lin][col].adicionar_vizinho(matriz[lin][col + 1]);
                }

                if (lin < linhas - 1) {
                    if (col > 0) {
                        matriz[lin][col].adicionar_vizinho(matriz[lin + 1][col - 1]);
                    }
                    matriz[lin][col].adicionar_vizinho(matriz[lin + 1][col]);
                    if (col < colunas - 1) {
                        matriz[lin][col].adicionar_vizinho(matriz[lin + 1][col + 1]);
                    }

                }

            }
        }

        this.adicionar_minas(linhas, colunas, minas);
    }

    public void adicionar_minas(int linhas, int colunas, int minas) {
        int n = minas;
        Random rand = new Random();
        while (n > 0) {

            int l = rand.nextInt(linhas);
            int c = rand.nextInt(colunas);

            boolean teste_minar = this.matriz[l][c].plantar_mina();

            if (teste_minar) {
                n--;
            }

        }
    }
    
    
    
         @Override
    public String toString() {
        String str = "";
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                str += this.matriz[i][j] + " ";
            }
            str += "\n";
        }
        return str;        
    }
    
}
