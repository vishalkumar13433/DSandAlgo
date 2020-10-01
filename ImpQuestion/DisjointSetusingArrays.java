
public class DisjointSetusingArrays {
	int[] parent;
	int[] rank;
	DisjointSetusingArrays(int num)
	{
		parent=new int[num];
		rank=new int[num];
		
		makeSet(num);
	}
	public static void main(String[] args) {
		DisjointSetusingArrays ds = new DisjointSetusingArrays(8);
		
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

	private int findSet(int val1) {
		if(parent[val1] == val1)
			return val1;
		//Find the representative recursively and does path
	    //compression as well.
		int temp=findSet(parent[val1]);
		parent[val1]=temp;
		return temp;
	}

	private void union(int val1, int val2) {
		int parent1=findSet(val1);
		int parent2=findSet(val2);
		
		if(parent1==parent2)
			return;
		//if parent1 set is larger
		if(rank[parent1] > rank[parent2])
		{
			parent[parent2]=parent1;
		}
		//if parent2 set is larger
		else if(rank[parent1] < rank[parent2])
		{
			parent[parent1]=parent2;
		}
		//if both are of same height
		else
		{
			parent[parent1]=parent2;
			rank[parent2]++;	//increment rank only if both sets have same rank
		}
	}

	private void makeSet(int n) {
		
		for(int i=1;i<n;i++)
		{
			parent[i]=i;
		}
	}

}
