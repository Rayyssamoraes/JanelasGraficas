package br.fiap.viagem;

import br.fiap.carga.Carga;

public class Viagem {

    private double capacidade;
    private int index;
    private Carga[] carga;

    public Viagem() {
        this.capacidade = 1000;
        this.index = 0;
        this.carga = new Carga[20];
    }//Viagem

    public double capacidadeReservada(){
        double total = 0;
        for (int i=0; i<index; i++){
            total += carga[i].getPeso();
        }//for
        return total;
    }//capacidadeReservada

    public boolean permitidoReservar(double peso){
        if (index < carga.length && capacidadeReservada() + peso <= capacidade){
            return true;
        }
        return false;
    }//permitidoReservado

    public boolean reservar(Carga carga){
        if (permitidoReservar(carga.getPeso())){
            this.carga[index] = carga;
            index++;
            return true;
        }
        return false;
    }//reservar

}//Viagem
