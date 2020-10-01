package GraphTheory.graphTraversal;

import GraphTheory.GraphRepresentation.GraphUsingAdjacencyList;

public class CheckForCycleInAGraph {

	public static void main(String[] args) {
		int V = 4;
		GraphUsingAdjacencyList directedGraph = new GraphUsingAdjacencyList(V); 
		directedGraph.addEdgeDirected(0, 1); 
		directedGraph.addEdgeDirected(0, 2); 
		directedGraph.addEdgeDirected(1, 2); 
		directedGraph.addEdgeDirected(2, 0); 
		directedGraph.addEdgeDirected(2, 3); 
		directedGraph.addEdgeDirected(3, 3); 
//		directedGraph.printGraph(graph);
        if(isCyclic(directedGraph)) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't "
                                    + "contain cycle"); 
        
        
        	V= 5;
        	GraphUsingAdjacencyList undirectedGraph = new GraphUsingAdjacencyList(V);
        	undirectedGraph.addEdge(1, 0); 
//        	undirectedGraph.addEdge(0, 2); 
        	undirectedGraph.addEdge(2, 1); 
        	undirectedGraph.addEdge(0, 3); 
        	undirectedGraph.addEdge(3, 4); 
            if (isCyclicUndirected(undirectedGraph)) 
                System.out.println("Graph contains cycle"); 
            else
                System.out.println("Graph doesn't contains cycle");
        } 
        
	private static boolean isCyclicUndirected(GraphUsingAdjacencyList graph) {
		boolean[] visited = new boolean[graph.getV()];
		for(int i=0;i<graph.getV();i++) {
			if(!visited[i]) {
				if(isCyclicUndirectedUtil(graph,visited,i,-1))
					return true;
			}
		}
		return false;
	}

	private static boolean isCyclicUndirectedUtil(GraphUsingAdjacencyList graph, 
			boolean[] visited, int cur, int parent) {
		visited[cur] = true;
		for(Integer neighbour:graph.getAdj()[cur]) {
			//if not visited , Visit it
			if(!visited[neighbour]) {
				if(isCyclicUndirectedUtil(graph,visited,neighbour,cur))
					return true;
			}else if(neighbour != parent){ // if visited, and node is other than parent , that means cycle exists
				return true;
			}
		}
		return false;
	}

	private static boolean isCyclic(GraphUsingAdjacencyList graph) {
		for(int i=0;i<graph.getV();i++) {
			boolean[] visited = new boolean[graph.getV()];
			if(isCyclicUtil(graph , 0 , visited)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCyclicUtil(GraphUsingAdjacencyList graph, int cur, boolean[] visited) {
		if(visited[cur]) return true;
		visited[cur] = true;
		for(Integer neighbour: graph.getAdj()[cur]) {
			if(isCyclicUtil(graph , neighbour, visited))
				return true;
		}
		visited[cur] = false;
		return false;
	}

}
