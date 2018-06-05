package buscas;

import estruturas.VetorOrdenadoAdjacente;
import cidadegrafo.Cidade;
import cidadegrafo.Adjacente;
import cidadegrafo.Mapa;

public class AEstrela {
	private VetorOrdenadoAdjacente fronteira;
	private Cidade objetivo;
	private boolean achou;
	
	public AEstrela(Cidade objetivo) {
		this.objetivo = objetivo;
	}
	
	public void buscar (Cidade atual) {
		System.out.println("Atual: "+atual.getNome());
		atual.setVisitado(true);
		
		if(atual == objetivo) {
			achou = true;
		} else {
			fronteira = new VetorOrdenadoAdjacente(atual.getAdjacentes().size());
			for (Adjacente a: atual.getAdjacentes()) {
				if(!a.getCidade().isVisitado()) {
					a.getCidade().setVisitado(true);
					fronteira.inserir(a);
				}
			}
			fronteira.mostrar();
			buscar(fronteira.getPrimeiro());
		}
	}
	
	public static void main(String[] args) {
		Mapa mapa = new Mapa();
		AEstrela a = new AEstrela(mapa.getCuritiba());
		a.buscar(mapa.getPortoUniao());
	}
	
}
