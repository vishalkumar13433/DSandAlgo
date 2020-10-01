package graphTraversal;

import GraphRepresentation.GraphUsingAdjacencyList;

public class DFS {

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

		doDFS(graph,0); 
		
	}

	private static void doDFS(GraphUsingAdjacencyList graph, int start) {
		boolean[] visited = new boolean[graph.getV()];
		doDFSUtil(graph , start , visited);
	}

	private static void doDFSUtil(GraphUsingAdjacencyList graph, int start , boolean[] visited) {
		if(visited[start]) return;
		System.out.print(start + " ");
		visited[start] = true;
		for(Integer cur : graph.getAdj()[start]) {
			doDFSUtil(graph , cur , visited);
		}
	}


}
