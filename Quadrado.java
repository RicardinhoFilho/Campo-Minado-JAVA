/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CampoMinado;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Quadrado {

    private boolean possui_mina;
    private boolean revelado;
    private boolean marcado;
    private boolean clicado;

    private ArrayList<Quadrado> vizinhos;

    public Quadrado() {
        this.possui_mina = false;
        this.revelado = false;
        this.marcado = false;
        this.clicado = false;
        this.vizinhos = new ArrayList();

    }

    public boolean plantar_mina() {
        //Solcuionando problema de sortear duas vezes a mesma posição para a mina!
        if (this.possui_mina) {
            return false;
        }
        this.possui_mina = true;
        return true;
    }

    //marcando e desmarcando com a mesma função
    public boolean marcar_desmarcar() {
        this.marcado = !this.marcado;
        return this.marcado;
    }

    //-1 codigo de erro cliccou em uma bomba!
    //0 - sem bombas em seus vizinhos
    //n - quantidade de bomas
    public int revelar() {
        if (this.possui_mina) {
            return -1;
        }
        return this.getNumeroDeminasVizinhas();

    }

    public void adicionar_vizinho(Quadrado novoVizinho) {
        this.vizinhos.add(novoVizinho);

    }

    public boolean getMina() {
        return this.possui_mina;
    }

    public int getNumeroDeminasVizinhas() {
        int n = 0;
        for (Quadrado v : this.vizinhos) {
            if (v.getMina()) {
                n++;
            }
        }
        return n;
    }

    public void resetar() {
        this.possui_mina = false;
        this.revelado = false;
        this.marcado = false;
        this.clicado = false;
    }
    
    @Override
    public String toString(){
        if(this.possui_mina)
            return "-1";
        
        return " " + this.getNumeroDeminasVizinhas();
    }

}
