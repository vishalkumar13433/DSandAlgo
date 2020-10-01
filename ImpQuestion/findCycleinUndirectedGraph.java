
public class findCycleinUndirectedGraph {
	int V;
	Edge[] edge;
	public findCycleinUndirectedGraph(int v, int e) {
		this.V=v;
		this.edge=new Edge[e];
		for(int i=0;i<e;i++)
			this.edge[i]=new Edge();
	}

	public static void main(String[] args) {
		 int V = 3, E = 3; 
		 findCycleinUndirectedGraph graph = new findCycleinUndirectedGraph(V, E); 
	  
	        // add edge 0-1 
	        graph.edge[0].source = 0; 
	        graph.edge[0].destination = 1; 
	  
	        // add edge 1-2 
	        graph.edge[1].source = 1; 
	        graph.edge[1].destination = 2; 
	  
	        // add edge 0-2 
	        graph.edge[2].source = 0; 
	        graph.edge[2].destination = 2; 
	  
	        if (graph.isCycle(graph)) 
	            System.out.println( "graph contains cycle" ); 
	        else
	            System.out.println( "graph doesn't contain cycle" ); 
	}

	private boolean isCycle(findCycleinUndirectedGraph graph) {
		DisjointSet ds = new DisjointSet();
		for(int i=0;i<this.V;i++)
			ds.makeSet(i);
		for(Edge e:this.edge)
		{
			int parent1=ds.findSet(e.source);
			int parent2=ds.findSet(e.destination);
			if(parent1==parent2)
				return true;
			ds.union(e.source, e.destination);
		}
		return false;
	}

}
