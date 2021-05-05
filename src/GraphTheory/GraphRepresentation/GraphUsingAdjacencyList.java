package GraphTheory.GraphRepresentation;

import java.util.LinkedList;
import java.util.List;

public class GraphUsingAdjacencyList {
	private int V;
	private LinkedList<Integer>[] adj;

	public GraphUsingAdjacencyList(int numOfVertices) {
		this.V = numOfVertices;
		adj = new LinkedList[numOfVertices];
		for(int i=0;i<this.V;i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public LinkedList<Integer>[] getAdj() {
		return adj;
	}

	public void setAdj(LinkedList<Integer>[] adj) {
		this.adj = adj;
	}

	public void addEdge(int src, int dest) {
		this.adj[src].add(dest);
		this.adj[dest].add(src);
	}

	public void addEdgeDirected(int src, int dest) {
		this.adj[src].add(dest);
	}

	public void printGraph(GraphUsingAdjacencyList graph) {
		for(int i=0;i<graph.getV();i++) {
			System.out.print(i + "---->");
			for(Integer temp:graph.getAdj()[i]) {
				System.out.print(temp.intValue() + " ");
			}
			System.out.println();
		}
	}

}
