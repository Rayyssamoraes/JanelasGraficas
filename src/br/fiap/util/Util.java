package br.fiap.util;
import br.fiap.carga.Carga;
import br.fiap.cliente.Cliente;
import br.fiap.viagem.Viagem;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class Util {

    private Viagem viagem = new Viagem();

    public void menu() {
        int opcao;
        String aux = "Reserva de Cargas Boa Viagem\n";
        aux += "[1] Reservar\n";
        aux += "[2] Pesquisar\n";
        aux += "[3] Exibir\n";
        aux += "[4] Capacidade reservada\n";
        aux += "[5] Cancelar\n";
        aux += "[6] Finalizar\n";

        do {
            opcao = parseInt(showInputDialog(aux));
            switch(opcao) {
                case 1 -> reservar();
                case 2 -> pesquisar();
                case 3 -> exibir();
                case 5 -> cancelar();
                case 6 -> showMessageDialog(null, "Até breve");
                default -> showMessageDialog(null, "Opção inválida");
            }
        } while(opcao != 6);

    }//menu

    private void cancelar() {
        int id = parseInt(showInputDialog("ID para busca"));
        if (viagem.cancelar(id)){
            showMessageDialog(null,"Carga cancelada com sucesso");
        }//if
        else {
            showMessageDialog(null, "Erro aoo cancelar carga");
        }
    }//cancelar

    private void pesquisar() {
        int id = parseInt(showInputDialog("ID para busca"));
        Carga carga = viagem.pesquisar(id);
        if (carga == null){
            showMessageDialog(null, "Carga não encontrada");
        }
        else {
            showMessageDialog(null, carga.getDados());
        }
    }//pesquisar


        private void exibir() {
            showMessageDialog(null, viagem.getDados());
        }//exibir

        private void reservar() {
            int cnpj;
            String destino, nomeCliente;

            cnpj = parseInt(showInputDialog("CNPJ"));
            destino = showInputDialog("Destino");
            nomeCliente = showInputDialog("Nome do cliente");

            Cliente cliente = new Cliente(cnpj, nomeCliente);
            Carga carga = new Carga(destino, cliente);

            if(viagem.reservar(carga)) {
                showMessageDialog(null, "Carga reservada com sucesso");
            }
            else {
                showMessageDialog(null, "ERRO! Entre em contato no 0800");
            }


        }//reservar
    }//Util