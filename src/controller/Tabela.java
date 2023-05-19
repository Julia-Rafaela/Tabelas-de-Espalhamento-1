package controller;

import java.util.LinkedList;

public class Tabela {


	 private static final int TAMANHO_TABELA = 10;
	    private LinkedList<moradores>[] tabela;

	    @SuppressWarnings("unchecked")
	    public Tabela() {
	        tabela = new LinkedList[TAMANHO_TABELA];
	        for (int i = 0; i < TAMANHO_TABELA; i++) {
	            tabela[i] = new LinkedList<>();
	        }
	    }

	    private int calcularHash(int numeroApartamento) {
	    	// le o primeiro numero do aparatamento Ex: ap 506, então o ardar é 5
	        int andar = numeroApartamento / 100;
	        return andar % TAMANHO_TABELA;
	    }

	    public void cadastrarMorador(moradores morador) {
	        int indice = calcularHash(morador.getNumeroApartamento());
	        tabela[indice].add(morador);
	    }

	    public moradores  consultarMorador(int numeroApartamento) {
	        int indice = calcularHash(numeroApartamento);
	        LinkedList<moradores > listaMoradores = tabela[indice];
	        for (moradores morador : listaMoradores) {
	            if (morador.getNumeroApartamento() == numeroApartamento) {
	                return morador;
	            }
	        }
	        return null;
	    }

	    public void excluirMorador(int numeroApartamento) {
	        int indice = calcularHash(numeroApartamento);
	        LinkedList<moradores > listaMoradores = tabela[indice];
	        for (moradores  morador : listaMoradores) {
	            if (morador.getNumeroApartamento() == numeroApartamento) {
	                listaMoradores.remove(morador);
	                return;
	            }
	        }
	    }

	    public LinkedList<moradores > listarMoradoresAndar(int andar) {
	        LinkedList<moradores > moradoresAndar = new LinkedList<>();
	        int numeroApartamentoInicial = (andar * 100) + 1;
	        int numeroApartamentoFinal = (andar + 1) * 100;
	        for (int numeroApartamento = numeroApartamentoInicial; numeroApartamento <= numeroApartamentoFinal; numeroApartamento++) {
	            int indice = calcularHash(numeroApartamento);
	            LinkedList<moradores > listaMoradores = tabela[indice];
	            for (moradores  morador : listaMoradores) {
	                if (morador.getNumeroApartamento() == numeroApartamento) {
	                    moradoresAndar.add(morador);
	                }
	            }
	        }
	        return moradoresAndar;
	    }
	}