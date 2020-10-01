package GraphRepresentation;

public class DriverClass {

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
	   
	    // print the adjacency list representation of  
	    // the above graph 
		graph.printGraph(graph); 
	}
	
}
