package GraphTheory;

import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgoUsingAdjacencyList {
	int V;
	List<Edge> [] adj;
	
	public DijkstrasAlgoUsingAdjacencyList(int v) {
		this.V = v;
		adj=new LinkedList[v];
		for(int i=0 ; i<v;i++) {
			adj[i] = new LinkedList<Edge>();
		}
		
	}
	
	public static void main(String[] args) {
		DijkstrasAlgoUsingAdjacencyList da = new DijkstrasAlgoUsingAdjacencyList(9);
		da.addEdge( 0, 1, 4); 
		da.addEdge( 0, 7, 8); 
		da.addEdge( 1, 2, 8); 
		da.addEdge( 1, 7, 11); 
		da.addEdge( 2, 3, 7); 
		da.addEdge( 2, 8, 2); 
		da.addEdge( 2, 5, 4); 
		da.addEdge( 3, 4, 9); 
		da.addEdge( 3, 5, 14); 
		da.addEdge( 4, 5, 10); 
		da.addEdge( 5, 6, 2); 
		da.addEdge( 6, 7, 1); 
		da.addEdge( 6, 8, 6); 
		da.addEdge( 7, 8, 7); 
		
		da.dijkstra(0); 
	}

	private void dijkstra(int start) {
		Integer[] d = new Integer[this.V];
		boolean[] visited = new boolean[this.V];
		
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start]= 0;
		PriorityQueue<PQEntry> pq = new PriorityQueue<>();
		PQEntry e1 = new PQEntry(d[start] , start);
		pq.offer(e1);
		while(!pq.isEmpty()){
			PQEntry temp = pq.poll();
			Integer cur = temp.getValue();
			visited[cur] = true;
			for(Edge e : this.adj[cur]) {
				if(!visited[e.getDestination()]) {
					d[e.getDestination()] = Integer.min(d[e.getDestination()], d[cur] + e.getWeight());
					PQEntry newEntry = new PQEntry(d[e.getDestination()], e.getDestination());
					pq.offer(newEntry);
				}
			}
		}
		 printDijkstra(d, start);
	}

	public void printDijkstra(Integer[] distance, int sourceVertex){
        System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
        for (int i = 0; i <this.V ; i++) {
            System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                    " distance: " + distance[i]);
        }
    }
	
	private void addEdge(int src, int dest, int weight) {
		this.adj[src].add(new Edge(src,dest, weight));
		this.adj[dest].add(new Edge(dest,src, weight));
	}

}
