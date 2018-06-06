package main;

import controler.MapaControler;
import model.Cidade;

public class VetorOrdenado {
private  Cidade[] cidades;
private int numeroElementos;//vai contar  quantos elementos tem no vetor

public VetorOrdenado(int tamanho) {
	cidades = new Cidade [tamanho];
	numeroElementos = 0;

}
public Cidade getPrimeiro() {
	return cidades[0];
}

public void inserir(Cidade cidade) {
	int posicao;
	for(posicao=0;posicao<numeroElementos;posicao++) {
		if(cidades[posicao].getDistanciaObjetivo()> cidade.getDistanciaObjetivo()) {//Estou comparando o dado que esta no vetor com o dado que quero inserir
		break;
			
		}
		
	}
	for (int x = numeroElementos; x>posicao; x--) {
		cidades[x]= cidades[x-1];
		
		
	}
	cidades[posicao] = cidade;
	numeroElementos++;
}
public void mostrar() {
	for(int i = 0;i<numeroElementos;i++ ) {
		System.out.println(cidades[i].getNome() + " - " +cidades[i].getDistanciaObjetivo());
	}
}
/*
public static void main(String[] args) {
	
	MapaControler mapa= new MapaControler();
	VetorOrdenado vetor = new VetorOrdenado(5); 
	vetor.inserir(mapa.getPortoUniao());//203
	vetor.inserir(mapa.getPauloFrontin());//172
	vetor.inserir(mapa.getBalsaNova());//41
	vetor.inserir(mapa.getPalmeira());//59
	vetor.mostrar();
	
}
*/

}



