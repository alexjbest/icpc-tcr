import java.util.*;

// This is wrapped up real nice in a class so it's super duper easy to use
// and because typing code of any length is O(1)
public class Graph {
    HashMap<String, LinkedList<String>> adjacents = new HashMap<String, LinkedList<String>>();
    
    public static void main(String[] args) {
        Graph g = new Graph(); // K3 + K2 + K1
        g.add("1", "2");
        g.add("1", "3");
        g.add("2", "3");
        g.add("4", "5");
        g.add("7", "7");
        g.print();
    }
    
    // Add an edge (u, v)
    public void add(String u, String v,) {
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
        if (adjacents.containsKey(u)) {
            if (adjacents.get(u).contains(v)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    // Returns the degree of node u
    public int degree(String u) {
        if (adjacents.containsKey(u)) {
            return adjacents.get(u).size();
        } else {
            return -1;
        }
    }
    
    // Pretty-print self
    public void print() {
        System.out.println(adjacents);
    }
    
    // BFS
    public void bfs(String root) {
        LinkedList<String> processed = new LinkedList<String>();
        String current = root;
        while (adjacents.get(current)) {
            // ...
        }
    }
}