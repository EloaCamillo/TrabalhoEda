package buscas;


import controler.Mapa;
import estruturas.VetorOrdenado;
import model.Adjacente;
import model.Cidade;

public class Gulosa {
	private VetorOrdenado fronteira;
	private Cidade objetivo;
	private boolean achou;
	
	public Gulosa(Cidade objetivo) {
		this.objetivo = objetivo;
		achou = false;
	}
	
	public void buscar(Cidade atual) {
		System.out.println("\n Atual: " + atual.getNome());
		atual.setVisitado(true);
		if(atual == objetivo) {
			achou = true;
		}
		else {
			fronteira = new VetorOrdenado(atual.getAdjacentes().size());//estou espandindo uma nova cidade, o vetor ordenado tem o numero da quantidade de cidades adjacentes
		    for(Adjacente a : atual.getAdjacentes() ) {
		    	if(!a.getCidade().isVisitado()) {//se eu não passei por essa cidade ainda vou setar como viitada
		    		a.getCidade().setVisitado(true);
		    		fronteira.inserir(a.getCidade());//inseri as cidades de forma ordenada
		    	}
		    	
		    }
		    fronteira.mostrar();
		    if(fronteira.getPrimeiro()!=null) {
		    buscar(fronteira.getPrimeiro());
		    }
		}
		
	}
	public static void main(String[] args) {
		Mapa mapa = new Mapa();
		Gulosa g = new Gulosa (mapa.getPortoUniao());//objetivo
		g.buscar(mapa.getCuritiba());//Cidade atual
	}
}
