package GraphTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	    public int V;
	    public LinkedList<Integer> adj[];
	  
	    // Constructor 
	    Graph(int v) 
	    { 
	        this.V = v; 
	        adj = new LinkedList[v]; 
	        for (int i=0; i<v; ++i) 
	            adj[i] = new LinkedList(); 
	    } 
	  
	    // Function to add an edge into the graph 
	    void addEdge(int v,int w) 
	    { 
	        adj[v].add(w); 
	    } 
	    
	    public static void main(String args[]) 
	    { 
	        Graph g = new Graph(4); 
	  
	        g.addEdge(0, 1); 
	        g.addEdge(0, 2); 
	        g.addEdge(1, 2); 
	        g.addEdge(2, 0); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 3); 
	  
	        System.out.println("Following is Breadth First Traversal "+ 
	                           "(starting from vertex 2)"); 
	  
	        g.BFS(2); 
	        System.out.println();
	        g.DFS(2);
	    }

		private void DFS(int start) {
			boolean visited[] = new boolean[V]; 
			  
	        // Call the recursive helper function to print DFS traversal 
	        DFSUtil(start, visited); 
			
		}

		private void DFSUtil(int start, boolean[] visited) {
			visited[start] = true; 
	        System.out.print(start +" "); 
			for(Integer cur : this.adj[start]) {
				if(!visited[cur]) {
					DFSUtil(cur , visited);
				}
			}
		}

		private void BFS(int start) {
			boolean visited[] = new boolean[V]; 
			Arrays.fill(visited, false);
			Queue<Integer> next = new LinkedList<>();
			next.add(start);
			while(!next.isEmpty()) {
				Integer cur = next.poll();
				visited[cur] = true;
				System.out.print(cur + " ");
				for(Integer neighbour : this.adj[cur]) {
					if(!visited[neighbour]) {
						visited[neighbour] = true;
						next.add(neighbour);
					}
				}
			}
		} 
}
