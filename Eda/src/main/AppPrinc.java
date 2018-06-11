package main;

import java.security.Provider.Service;
import java.util.List;

import controler.AstarSearchAlgo;
import controler.MapaControler;
import mb.AdjacenteMB;
import mb.CidadeMB;
import model.Cidade;
import model.Edge;
import model.Graph;
import model.Node;
import service.Services;

public class AppPrinc {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = true;
		MapaControler m;
		System.out.println("Iniciado programa");
		
		if (!b) 
			m = new MapaControler();
		else{

			Services a = new Services();
			Graph grafo = a.populaGrafo();

			for (Node n : grafo.nodes) {
				System.out.println("value: " + n.value);
				for (Edge e : n.adjacencies)
					if (e.target != null)
						System.out.println("Adjacente: " + e.target.value);

				System.out.println("\n");
			}

			Node cidadeA = grafo.Find("Balsa Nova");
			Node cidadeB = grafo.Find("Irati");
			if (cidadeA == null) {
				System.out.println("CidadeA nao existem");
			}
			
			if(cidadeB == null) {
				System.out.println("CidadeB nao existem");
			}
			
			if(cidadeA!=null && cidadeB!=null) {
				AstarSearchAlgo.AstarSearch(cidadeA, cidadeB);

				List<Node> path = AstarSearchAlgo.printPath(cidadeB);

				System.out.println("Caminho:" + path);
			}
		}
		System.out.println("Finalizado programa");
	}
}
