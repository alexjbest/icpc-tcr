import java.util.*;

// This is wrapped up real nice in a class so it's super duper easy to use
// and because typing code of any length is O(1)
public class Graph {
	HashMap<String, LinkedList<String>> adjacents = new HashMap<String, LinkedList<String>>();

	// Add an edge (u, v)
	public void add(String u, String v) {
		if (u.equals(v)) {
			if (!adjacents.containsKey(u)) {
				LinkedList<String> newList = new LinkedList<String>();
				adjacents.put(u, newList);
				return;
			}
		}

		if (adjacents.containsKey(u)) {
			if (!adjacents.get(u).contains(v)) {
				adjacents.get(u).add(v);
			}
		} else {
			LinkedList<String> newList = new LinkedList<String>();
			newList.add(v);
			adjacents.put(u, newList);
		}

		if (adjacents.containsKey(v)) {
			if (!adjacents.get(v).contains(u)) {
				adjacents.get(v).add(u);
			}
		} else {
			LinkedList<String> newList = new LinkedList<String>();
			newList.add(u);
			adjacents.put(v, newList);
		}
	}

	// Tests whether (u, v) is an edge
	public boolean edge(String u, String v) {
		return (adjacents.containsKey(u) && adjacents.get(u).contains(v));
	}

	// Returns the degree of node u
	public int degree(String u) {
		return adjacents.containsKey(u) ? adjacents.get(u).size(): -1;
	}

	// BFS
	public void bfs(String root) {
		LinkedList<String> processed = new LinkedList<String>();
		String current = root;
		//while (adjacents.get(current)) {
			// ...
		//}
	}
}
