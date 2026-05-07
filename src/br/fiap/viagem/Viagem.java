package br.fiap.viagem;

import br.fiap.carga.Carga;

public class Viagem {
    private double capacidade;
    private int index;
    private Carga[] carga;

    public Viagem() {
        this.capacidade = 10000;
        this.index = 0;
        this.carga = new Carga[20];
    }//Viagem

    public Carga pesquisar(int id){
        int i = pesquisarId(id);
        if (i != -1){
            return carga[i];
        }//if
        return null;
    }//pesquisar

    public boolean cancelar(int id){
        int i = pesquisarId(id);
        if (i != -1){
            carga[i] = carga[index - 1];
            index--;
            return true;
        }//if
        return false;
    }//cancelar

    private int pesquisarId(int id) {
        for (int i = 0; i < index; i++) {
            if (carga[i].getId() == id){
                return i;
            }//if
        }//for
        return -1;
    }//pesquisarId

    public double capacidadeReservada() {
        double total = 0;
        for(int i = 0; i < index; i++) {
            total += carga[i].getPeso();
        }//for
        return total;
    }//capacidadeReservada

    public boolean permitidoReservar(double peso) {
        if(index < carga.length && capacidadeReservada() + peso <= capacidade) {
            return true;
        }//if
        return false;
    }//permitidoReservar

    public boolean reservar(Carga carga) {
        if(permitidoReservar(carga.getPeso())) {
            this.carga[index] = carga;
            index++;
            return true;
        }//if
        return false;
    }//reservar

    public String getDados() {
        String aux = "";
        for(int i = 0; i < index; i++) {
            aux += carga[i].getDados() + "\n";
            aux += "############################\n";
        }//for
        return aux;
    }//getDados

    public int getIndex() {
        return index;
    }//getIndex

    public void setIndex(int index) {
        this.index = index;
    }//setIndex
}