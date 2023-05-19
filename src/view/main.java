package view;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import controller.Tabela;
import controller.moradores;

public class main {


	public static void main(String[] args) {
		
        Tabela tabelaEspalhamento = new Tabela();

        // Cadastrar moradores
        moradores morador1 = new moradores (101, "João", "Fiat", "Prata", "ABC-1234");
        tabelaEspalhamento.cadastrarMorador(morador1);

        moradores  morador2 = new moradores (202, "Maria", "Volkswagen", "Azul", "DEF-5678");
        tabelaEspalhamento.cadastrarMorador(morador2);

        moradores  morador3 = new moradores (701, "Pedro", "Chevrolet", "Preto", "GHI-9012");
        tabelaEspalhamento.cadastrarMorador(morador3);
        
        moradores  morador4 = new moradores (201, "Carla", "Audi", "Preto", "HTI-9672");
        tabelaEspalhamento.cadastrarMorador(morador4);

        // Consulta os moradoradores por numero de apartamento
     
        int numeroApartamento = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do apartamento:"));
        moradores  moradorConsultado = tabelaEspalhamento.consultarMorador(numeroApartamento);
        if (moradorConsultado != null) {
            System.out.println("Morador encontrado: " + moradorConsultado.getNomeMorador());
        } else {
            System.out.println("Morador não encontrado");
        }

        // exclui morador por numero de apartamento
        
       numeroApartamento = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do apartamento que deseja excluir:"));
        tabelaEspalhamento.excluirMorador(numeroApartamento);

        // Listar moradores de um determinado andar
       int andar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do Andar:"));
        LinkedList<moradores> moradoresAndar = tabelaEspalhamento.listarMoradoresAndar(andar);
        if (moradoresAndar.isEmpty()) {
            System.out.println("Não há moradores no andar " + andar);
        } else {
            System.out.println("Moradores do andar " + andar + ":");
            for (moradores  morador : moradoresAndar) {
                System.out.println("Apartamento " + morador.getNumeroApartamento() + ": " + morador.getNomeMorador());
            }
        }
    }
}
