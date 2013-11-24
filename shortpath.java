import java.util.*;
public class shortpath {
	public static int INF = Integer.MAX_VALUE;
	public static void bellmanFord(Vector<Edge> edges, int nnodes, int source) {
		int[] distance = new int[nnodes]; 
		Arrays.fill(distance, INF); 
		distance[source] = 0; 
		for (int i = 0; i < nnodes; ++i) {
			for (int j = 0; j < edges.size(); ++j) { 
				if (distance[edges.get(j).source] == INF) continue; 
				int newDistance = distance[edges.get(j).source] + edges.get(j).weight; 
				if (newDistance < distance[edges.get(j).destination])
					distance[edges.get(j).destination] = newDistance; 
			}
		}
		for (int i = 0; i < edges.size(); ++i) {
			if (distance[edges.get(i).source] != INF && distance[edges.get(i).destination] > distance[edges.get(i).source] + edges.get(i).weight) { 
				System.out.println("Negative edge weight cycles detected!");
				return;
			}
		}
		for (int i = 0; i < distance.length; ++i) {
			if (distance[i] == INF) 
				System.out.println("There's no path between " + source + " and " + i); 
			else
				System.out.println("The shortest distance between nodes " + source + " and " + i + " is " + distance[i]); 
		}
	}

	static class Edge { 
		int source; // source node 
		int destination; // destination node 
		int weight; // weight of the edge 
		public Edge() {}; // default constructor 
		public Edge(int s, int d, int w) { source = s; destination = d; weight = w; } 
	}
}
