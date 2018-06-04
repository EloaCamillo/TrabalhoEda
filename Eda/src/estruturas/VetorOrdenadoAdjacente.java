package estruturas;

import cidadegrafo.Adjacente;
import cidadegrafo.Cidade;
import cidadegrafo.Mapa;

public class VetorOrdenadoAdjacente {
	private Adjacente[] adjacentes;
	private int numeroElementos;
	
private VetorOrdenadoAdjacente data = new VetorOrdenadoAdjacente();

public VetorOrdenadoAdjacente(int tamanho) {
	adjacentes = new Adjacente[tamanho];
	numeroElementos = 0;

}

public Adjacente getPrimeiro() {
	return data.adjacentes[0];
}

public void inserir(Adjacente adjacente) {
	int posicao;
	for(posicao=0;posicao<data.numeroElementos;posicao++) {
		if(data.adjacentes[posicao].getDistanciaAEstrela()> adjacente.getDistanciaAEstrela()) { //Estou comparando o dado que esta no vetor com o dado que quero inserir
		break;
			
		}
		
	}
	for (int x = data.numeroElementos; x>posicao; x--) {
		data.adjacentes[x]= data.adjacentes[x-1];
		
		
	}
	data.adjacentes[posicao] = adjacente;
	data.numeroElementos++;
}
public void mostrar() {
	for(int i = 0;i<data.numeroElementos;i++ ) {
		System.out.println(data.adjacentes[i].getNome() + " - " +data.adjacentes[i].getDistanciaObjetivo());
	}
}
public static void main(String[] args) {
	
	Mapa mapa= new Mapa();
	VetorOrdenadoAdjacente vetor = new VetorOrdenadoAdjacente(5); 
	vetor.inserir(mapa.getPortoUniao());//203
	vetor.inserir(mapa.getPauloFrontin());//172
	vetor.inserir(mapa.getBalsaNova());//41
	vetor.inserir(mapa.getPalmeira());//59
	vetor.mostrar();
	
}


}



