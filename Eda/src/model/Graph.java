package model;

import java.util.ArrayList;

public class Graph {
	public ArrayList<Node> nodes = new ArrayList<Node>();

	public Node Find(String str) {
		for (Node n : this.nodes) {
			if ((n.value.trim().compareTo(str)) == 0) {
				System.out.println(n.value);
				return n;
			}
		}
		return null;
	}
	/*
	 * public void Edge(Node targetNode, double costVal){ target = targetNode; cost
	 * = costVal; }
	 */
	public void addEdge(Cidade a, Edge[] edges) {
		Node nFrom = Find(a.getNome());
		if (nFrom != null) {
			nFrom.AddEdge(edges);
		}
	}
}
