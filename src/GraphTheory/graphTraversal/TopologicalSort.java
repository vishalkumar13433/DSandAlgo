package src.GraphTheory.graphTraversal;


import src.GraphTheory.GraphRepresentation.GraphUsingAdjacencyList;

import java.util.Collections;
import java.util.Stack;

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

	public static void topologicalSort(GraphUsingAdjacencyList g) {
		// for topological sort , this graph should be a DAG
		Stack<Integer> order = new Stack<>();
		boolean[] visited = new boolean[g.getV()];
		for(int i=0;i< g.getV();i++){
			topologicalSortUtil(g,i,visited,order);
		}
		Collections.reverse(order);
		System.out.println(order);
	}

	private static void topologicalSortUtil(GraphUsingAdjacencyList g, int cur, boolean[] visited, Stack<Integer> order) {
		if(visited[cur]){
			return;
		}
		for(Integer v : g.getAdj()[cur]){
			topologicalSortUtil(g,v,visited,order);
		}
		visited[cur] = true;
		order.push(cur);
	}

}
