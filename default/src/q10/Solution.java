package q10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	public class Node {

		Map<Node, Boolean> connections;

		public Node() {
			connections = new HashMap<>();
		}

		public void addConnection (Node node) {
			connections.put (node, true);
		}
		
		public void reset() {
			for (Entry<Node, Boolean> connection : connections.entrySet())
				connection.setValue(true);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
