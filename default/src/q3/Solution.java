package q3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public class Node {
		public int id;
		public Node[] neighbors;
		public int distanceToStart;
		public int distanceToEnd;

		public Node(int id, int max) {
			this.id = id;
			this.neighbors = new Node[max];
			this.distanceToEnd = 0;
			this.distanceToStart = 0;
		}

		public void addEdge(Node n) {
			this.neighbors[n.id] = n;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numberOfCases = sc.nextInt();
		for (int i = 0; i < numberOfCases; i++) {
			int numberOfNodes = sc.nextInt();
			int numberOfConnections = sc.nextInt();
			List<Node> nodes = new ArrayList<>();
			for (int j = 0; j < numberOfNodes; j++) {
				nodes.add(new Solution().new Node(j, numberOfNodes));
			}

			for (int j = 0; j < numberOfConnections; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if (x == y)
					continue;
				nodes.get(x).addEdge(nodes.get(y));
				nodes.get(y).addEdge(nodes.get(x));
			}

			int start = sc.nextInt();
			int end = sc.nextInt();

			// BFS

			Queue<Node> inputs = new LinkedList<>();

			inputs.add(nodes.get(start));
			while (!inputs.isEmpty()) {
				Node top = inputs.poll();
				for (Node node : top.neighbors) {
					if (node == null)
						continue;
					if (node.distanceToStart == 0 && node.id != start) {
						node.distanceToStart = top.distanceToStart + 1;
						inputs.add(node);
					}
				}
			}

			inputs.add(nodes.get(end));
			while (!inputs.isEmpty()) {
				Node top = inputs.poll();
				for (Node node : top.neighbors) {
					if (node == null)
						continue;
					if (node.distanceToEnd == 0 && node.id != end) {
						node.distanceToEnd = top.distanceToEnd + 1;
						inputs.add(node);
					}
				}
			}

			int max = 0;
			for (Node node : nodes) {
				int total = node.distanceToEnd + node.distanceToStart;
				if (max < total) {
					max = total;
				}
			}

			System.out.println("Case " + (i + 1) + ": " + max);
		}

		sc.close();
	}

}
