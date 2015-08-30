package q10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public class Edge {
		public int id1;
		public int id2;

		public Edge(int n1, int n2) {
			this.id1 = n1;
			this.id2 = n2;
		}
	}

	public class Node {
		public int id;
		public List<Node> neighbors;

		public boolean visited;

		public Node(int id) {
			this.id = id;
			this.neighbors = new ArrayList<>();
			this.visited = false;
		}

		public void addNode(Node n) {
			this.neighbors.add(n);
		}

		public int bestEdge(Node origin, List<Edge> edgeList) {
			int max = 0;

			test: for (Node node : neighbors) {
				if (origin != null && node == origin) {
					continue;
				}

				for (Edge e : edgeList) {
					if ((this.id == e.id1 && node.id == e.id2)
							|| (this.id == e.id2 && node.id == e.id1)) {
						continue test;
					}
				}

				Edge edge = new Edge(this.id, node.id);
				edgeList.add(edge);
				int temp = 1 + node.bestEdge(this, edgeList);
				edgeList.remove(edge);

				if (temp > max)
					max = temp;
			}
			return max;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int nodeCount = sc.nextInt();
			int edgeCount = sc.nextInt();

			if (nodeCount == 0 && edgeCount == 0) {
				sc.close();
				return;
			}

			List<Node> nodes = new ArrayList<>();
			for (int i = 0; i < nodeCount; i++) {
				nodes.add(new Solution().new Node(i));
			}
			for (int i = 0; i < edgeCount; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				nodes.get(start).addNode(nodes.get(end));
				nodes.get(end).addNode(nodes.get(start));
			}

			int max = 0;
			for (Node node : nodes) {
				int temp = node.bestEdge(null, new ArrayList<Edge>());
				if (temp > max)
					max = temp;
			}
			System.out.println(max);

		}
	}

}
