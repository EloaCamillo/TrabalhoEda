package estruturas;

import cidadegrafo.Adjacente;
import cidadegrafo.Cidade;

public class VetorOrdenadoAdjacente {
	private Adjacente[] adjacentes;
	private int numeroElementos;
	
public VetorOrdenadoAdjacente(int tamanho) {
	adjacentes = new Adjacente[tamanho];
	numeroElementos = 0;

}

public Cidade getPrimeiro() {
	return this.adjacentes[0].getCidade();
}

public void inserir(Adjacente adjacente) {
	int posicao;
	for(posicao=0;posicao<this.numeroElementos;posicao++) {
		if(this.adjacentes[posicao].getDistanciaAEstrela()> adjacente.getDistanciaAEstrela()) { //Estou comparando o dado que esta no vetor com o dado que quero inserir
		break;
			
		}
		
	}
	for (int x = this.numeroElementos; x>posicao; x--) {
		this.adjacentes[x]= this.adjacentes[x-1];
		
		
	}
	this.adjacentes[posicao] = adjacente;
	this.numeroElementos++;
}

public void mostrar() {
	for(int i = 0;i<this.numeroElementos;i++ ) {
		System.out.println(this.adjacentes[i].getCidade().getNome() + " - " +this.adjacentes[i].getDistanciaAEstrela());
	}
}


}



