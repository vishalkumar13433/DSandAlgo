package GraphTheory;

import java.util.Arrays;

public class DijkstrasAlgorithm {
	int V;
	public DijkstrasAlgorithm(int v) {
		this.V = v;
	}
	
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
            DijkstrasAlgorithm t = new DijkstrasAlgorithm(9); 
            t.dijkstra(graph, 0); 
	}

	private void dijkstra(int[][] graph, int start) {
		int[] distance = new int[this.V];
		boolean[] shortestpathIncluded = new boolean[this.V];
		int parent[] = new int[this.V]; 

		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(shortestpathIncluded, false);
		distance[0] = 0;
		for (int count = 0; count < V - 1; count++) {
			int nextIndex = findMinimum(distance, shortestpathIncluded);
			shortestpathIncluded[nextIndex] = true;
			for (int i = 0; i < this.V; i++) {
				if (!shortestpathIncluded[i] && graph[nextIndex][i] != 0
						&& distance[i] >= distance[nextIndex] + graph[nextIndex][i]) {
					// relaxing edge (nextIndex , i)
					distance[i] = distance[nextIndex] + graph[nextIndex][i];
					//update Parent
					parent[i] = nextIndex;
				}
			}
		}
		// print the constructed distance array 
        printSolution(distance);
        //follow parent pointers to print shortest path
	}
	
	int findMinimum(int[] dist, boolean[] sptSet) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    // A utility function to print the constructed distance array 
    void printSolution(int dist[]) 
    { 
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    } 
  
}
