package src.GraphTheory.graphTraversal;

import src.GraphTheory.GraphRepresentation.GraphUsingAdjacencyList;

import java.util.LinkedList;
import java.util.Queue;


public class BFS {

	public static void main(String[] args) {
		int V = 5; 
		GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(V);
		graph.addEdge(0, 1); 
		graph.addEdge(0, 4); 
		graph.addEdge(1, 2); 
		graph.addEdge(1, 3); 
		graph.addEdge(1, 4); 
		graph.addEdge(2, 3); 
		graph.addEdge(3, 4); 
		
		
		System.out.println("Following is Breadth First Traversal "+ 
                "(starting from vertex 2)"); 

		doBFS(graph,0); 
		
	}

	private static void doBFS(GraphUsingAdjacencyList graph, int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[graph.getV()];
		q.add(start);
		
		while(!q.isEmpty()) {
			Integer cur = q.poll();
			System.out.print(cur + " ");
			visited[cur] = true;
			for(Integer adj : graph.getAdj()[cur]) {
				if(!visited[adj])
					q.add(adj);
			}
		}
	}
	
}
