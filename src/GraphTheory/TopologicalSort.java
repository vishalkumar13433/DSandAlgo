package GraphTheory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Graph g = new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
  
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
//        topologicalSort(g); 
        kahnSAlgorithm(g);
    }

	private static void kahnSAlgorithm(Graph g) {
		Queue<Integer> order = new LinkedList();
		boolean[] visited = new boolean[g.V];
		Arrays.fill(visited, false);
		int[] indegree = new int[g.V];
		int[] outdegree = new int[g.V];
		Arrays.fill(indegree, 0);
		Arrays.fill(outdegree, 0);
		for(int i=0 ; i< g.V ; i++) {
			for(Integer neighbour : g.adj[i]) {
				outdegree[i]++;
				indegree[neighbour]++;
			}
		}

		for(int i=0; i< indegree.length ; i++) {
			if(indegree[i] == 0) {
				visited[i] = true;
				order.add(i);
			}
		}
        kahnSAlgorithmUtil(g, order , visited , indegree , outdegree);
	}

	private static void kahnSAlgorithmUtil( Graph g, Queue<Integer> order, boolean[] visited, int[] indegree,
			int[] outdegree) {
		while(!order.isEmpty()) {
			Integer cur  = order.poll();
			System.out.print(cur + " ");
			for(Integer i :g.adj[cur]) {
				if(--indegree[i] == 0) {
					visited[i] = true;
					order.add(i);
				}
			}
			
		}
	}

	public static void topologicalSort(Graph g) {
		Stack<Integer> order = new Stack<>();
		boolean[] visited = new boolean[g.V];
		Arrays.fill(visited, false);
		for (int i = 0; i < g.V; i++) 
            if (visited[i] == false) 
                topologicalSortUtil(i, visited, order , g); 
		
		while(!order.isEmpty()) {
			System.out.print(order.peek() + " ");
			order.pop();
		} 
		
	}

	private static void topologicalSortUtil(int cur, boolean[] visited, Stack<Integer> order, Graph g) {
		visited[cur] = true;
		for(Integer next : g.adj[cur]) {
			if(!visited[next.intValue()]) {
				topologicalSortUtil(next.intValue() , visited , order , g);
			}
		}
		order.add(cur);
	} 
	
}
