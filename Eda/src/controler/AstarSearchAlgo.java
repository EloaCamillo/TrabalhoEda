package controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import model.*;

public class AstarSearchAlgo {

	public static List<Node> printPath(Node target) {
		List<Node> path = new ArrayList<Node>();

		for (Node node = target; node != null; node = node.parent) {
			path.add(node);
		}

		Collections.reverse(path);

		return path;
	}

	public static void AstarSearch(Node s, Node t) {

		Set<Node> explored = new HashSet<Node>();

		PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {
			public int compare(Node i, Node j) {
				if (i.f > j.f) {
					return 1;
				} else if (i.f < j.f) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		s.g = 0;

		queue.add(s);

		boolean found = false;

		while ((!queue.isEmpty()) && (!found)) {

			Node current = queue.poll();

			explored.add(current);

			if (current.value.equals(t.value)) {
				found = true;
			}

			for (Edge e : current.adjacencies) {
				Node node = e.target;
				double cost = e.cost;
				double aux_g = current.g + cost;
				double aux_f = aux_g + node.h;

				if ((explored.contains(node)) && (aux_f >= node.f)) {
					continue;
				} else if ((!queue.contains(node)) || (aux_f < node.f)) {

					node.parent = current;
					node.g = aux_g;
					node.f = aux_f;

					if (queue.contains(node)) {
						queue.remove(node);
					}
					queue.add(node);
				}
			}
		}
	}
}
