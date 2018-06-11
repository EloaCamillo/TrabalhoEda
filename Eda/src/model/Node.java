package model;

public class Node {

	public String value;
	public double g;
	public final double h;
	public double f = 0;
	public Edge[] adjacencies;
	public Node parent;

	public Node(Cidade c) {
		value = c.getNome();
		h = c.getDistanciaObjetivo();
	}

	public Node(String val, double hVal) {
		value = val;
		h = hVal;
	}

	public String toString() {
		return value;
	}

	public void AddEdge(Node to, double cost) {
		/*
		 * if (adjacencies.length-1) {
		 * 
		 * }
		 */
		adjacencies[adjacencies.length] = new Edge(to, cost);
	}

	public void AddEdge(Edge[] edges) {

		adjacencies = edges;
	}

}