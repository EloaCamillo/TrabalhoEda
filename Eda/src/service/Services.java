package service;

import java.util.ArrayList;
import java.util.List;

import mb.AdjacenteMB;
import mb.CidadeMB;
import model.Adjacente;
import model.Cidade;
import model.Edge;
import model.Graph;
import model.Node;

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
	public Graph populaGrafo()
	{
		CidadeMB getCidadeBanco = new CidadeMB();
		
		//Dados dados = new Dados();
		Graph grafo = new Graph();
		List<Cidade> cidades = getCidadeBanco.getCidades();

		for (Cidade cidade : cidades) {
			grafo.nodes.add(new Node(cidade));
			
			Edge arestas[] = new Edge[cidade.getAdjacentes().size()];
			for (int j = 0; j < arestas.length; j++) {				
				arestas[j] = new Edge(grafo.Find(cidade.getAdjacentes().get(j).getCidade().getNome()), cidade.getDistanciaObjetivo());
			}
			grafo.nodes.get(grafo.nodes.size()-1).adjacencies = arestas;

		}

		return grafo;
	}
}
