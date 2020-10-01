package ImpQuestion;

import java.util.LinkedHashMap;

public class DisjointSet {
	//contains Node for the given val
	LinkedHashMap<Integer, Node> hm;
	DisjointSet()
	{
		hm=new LinkedHashMap();
	}
	
	 public static void main(String args[]) {
	        DisjointSet ds = new DisjointSet();
	        ds.makeSet(1);
	        ds.makeSet(2);
	        ds.makeSet(3);
	        ds.makeSet(4);
	        ds.makeSet(5);
	        ds.makeSet(6);
	        ds.makeSet(7);
	        
	        ds.union(1, 2);
	        ds.union(2, 3);
	        ds.union(4, 5);
	        ds.union(6, 7);
	        ds.union(5, 6);
	        //ds.union(3, 7);
	       
	        System.out.println(ds.findSet(1));
	        System.out.println(ds.findSet(2));
	        System.out.println(ds.findSet(3));
	        System.out.println(ds.findSet(4));
	        System.out.println(ds.findSet(5));
	        System.out.println(ds.findSet(6));
	        System.out.println(ds.findSet(7));
	}
	 public int findSet(int val) {
			return findSet(hm.get(val)).data;
		}

		 public Node findSet(Node node) {
			if(node.parent==node)
				return node;
			//Find the representative recursively and does path
		    //compression as well.
			Node temp=findSet(node.parent);
			node.parent=temp;
			return temp;
		}

		 public void union(int val1, int val2) {
			int parent1=findSet(val1);
			int parent2=findSet(val2);
			
			//if they are part of same set do nothing
			if(parent1==parent2)
				return;
			
			Node p1=hm.get(parent1);
			Node p2=hm.get(parent2);
			 //else whoever's rank is higher becomes parent of other
			if( p1.rank >= p2.rank)
			{
				//increment rank only if both sets have same rank
				p1.rank = (p1.rank == p2.rank) ? p1.rank += 1 : p1.rank;
				p2.parent=p1;
			}
			else
				p1.parent=p2;
		}

		 public void makeSet(int val) {
			Node n=new Node();
			n.data=val;
			n.parent=n;
			n.rank=0;
			this.hm.put(val, n);
		}
	 
	 
	 //FOR DEBBUGING
/*
	int findSet(int val) {
		return findSet(hm.get(val)).data;
	}

	private Node findSet(Node node) {
		if(node.parent==node)
			return node;
		Node temp=findSet(node.parent);
		System.out.println("Setting "+node.data + " 's parent to " + temp.data);
		node.parent=temp;
		return temp;
	}

	void union(int val1, int val2) {
		int parent1=findSet(val1);
		int parent2=findSet(val2);
		System.out.println("parent1:"+parent1);
		System.out.println("parent2:"+parent2);
		//already in the same set
		if(parent1==parent2)
			return;
		Node p1=hm.get(parent1);
		System.out.println("p1:"+p1.data);
		Node p2=hm.get(parent2);
		System.out.println("p2:"+p2.data);
		if(p1.rank >= p2.rank)
		{
			p1.rank=(p1.rank==p2.rank)?p1.rank+1:p1.rank;
			System.out.println("Setting "+p2.data + " 's parent to " + p1.data);
			p2.parent=p1;
		}
		else
		{
			System.out.println("Setting "+p1.data + " 's parent to " + p2.data);
			p1.parent=p2;
		}
	}

	void makeSet(int val) {
		Node n=new Node();
		n.data=val;
		n.parent=n;
		n.rank=0;
		hm.put(val, n);
	}

	*/
}
