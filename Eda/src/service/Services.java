package service;

import model.Adjacente;
import model.Cidade;

public class Services {
	public Cidade CriaCidade(String nome, int valor) {
		Cidade a = new Cidade();
		a.setNome(nome);
		a.setDistanciaObjetivo(valor);
		return a;
	}
	
	public Adjacente CriaAdjacente(Cidade cidade) {
		Adjacente a = new Adjacente();
		a.setCidade(cidade);
		return a;
	}
	public void addCidadeAdjacente(Cidade c1, Cidade c2) {
        c1.getAdjacentes().add(CriaAdjacente(c2));
    }
	public double calculaDistancia()
	{
		double valor=0;
		return valor;
	}

}
