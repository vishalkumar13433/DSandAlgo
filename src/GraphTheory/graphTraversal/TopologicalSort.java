package GraphTheory.graphTraversal;

import java.util.Collections;
import java.util.Stack;

import GraphTheory.GraphRepresentation.GraphUsingAdjacencyList;

public class TopologicalSort {

	public static void main(String[] args) {
		// Create a graph given in the above diagram 
        GraphUsingAdjacencyList g = new GraphUsingAdjacencyList(6); 
        g.addEdgeDirected(5, 2); 
        g.addEdgeDirected(5, 0); 
        g.addEdgeDirected(4, 0); 
        g.addEdgeDirected(4, 1); 
        g.addEdgeDirected(2, 3); 
        g.addEdgeDirected(3, 1); 
  
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        topologicalSort(g);
        
	}

	private static void topologicalSort(GraphUsingAdjacencyList g) {
		// for topological sort , this graph should be a DAG
		Stack<Integer> order = new Stack<>();
		boolean[] visited = new boolean[g.getV()];
		for(int i=0;i<g.getV();i++) {
			if(!visited[i])
				topologicalSortUtil(g , i , visited , order);
		}
		System.out.println(order);
	}

	private static void topologicalSortUtil(GraphUsingAdjacencyList g, int cur, boolean[] visited, Stack<Integer> order) {
	
		visited[cur] = true;
		for(Integer neighbour:g.getAdj()[cur]) {
			if(!visited[neighbour]) {
				topologicalSortUtil(g, neighbour, visited, order);
			}
		}
		//after visiting all its neighbours mark this as completed
		order.add(cur);
	}

}
