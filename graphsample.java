import java.util.*;
public class graphsample {
	static void example() {
		HashMap<String, LinkedList<String>> adjacents = new HashMap<String, LinkedList<String>>();
		adjacents.put("x", new LinkedList<String>());
		adjacents.put("y", new LinkedList<String>());
		adjacents.get("y").add("x");

	}
}
