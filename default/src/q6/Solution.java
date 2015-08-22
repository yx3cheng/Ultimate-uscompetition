package q6;

import java.util.Scanner;

public class Solution {

	public class Node {
		public int weight;
		public int sum_weight = -1;
		public int d_left;
		public int d_right;
		public Node node_left;
		public Node node_right;
	}

	public static void next(Node node, Scanner sc) {
		String line = sc.nextLine();
		String[] tokens = line.split(" ");
		node.d_left = Integer.parseInt(tokens[1]);
		node.d_right = Integer.parseInt(tokens[3]);

		Node left = new Solution().new Node();
		node.node_left = left;

		int w_left = Integer.parseInt(tokens[0]);
		if (w_left == 0)
			next(left, sc);
		else
			left.weight = w_left;

		Node right = new Solution().new Node();
		node.node_right = right;

		int w_right = Integer.parseInt(tokens[2]);
		if (w_right == 0)
			next(right, sc);
		else
			right.weight = w_right;
	}

	public static boolean calculate(Node node) {
		if (node.node_left == null && node.node_right == null) {
			node.sum_weight = node.weight;
			return true;
		}

		if (calculate(node.node_left)
				&& calculate(node.node_right)
				&& node.node_left.sum_weight * node.d_left == node.d_right
						* node.node_right.sum_weight) {
			node.sum_weight = node.node_left.sum_weight
					+ node.node_right.sum_weight;
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();
		sc.nextLine();
		sc.nextLine();

		for (int i = 0; i < cases; i++) {
			Node base = new Solution().new Node();
			next(base, sc);
			sc.nextLine();
			if (calculate(base)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

		sc.close();
	}

}
