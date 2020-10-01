package ImpQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DishOwner {
	int[] parent;
	int[] rank;
	int num;
	DishOwner(int num)
	{
		parent=new int[num];
		rank=new int[num];
		
	}
	private void makeSet() {	
			for(int i=1;i<this.num;i++)
			{
				parent[i]=i;
			}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++)
		{
				int n=Integer.parseInt(br.readLine());
				DishOwner d=new DishOwner(n+1);
				d.num=n+1;
				d.makeSet();
				String s=br.readLine();
				StringTokenizer st=new StringTokenizer(s);
				
				int k=1;
				while(st.hasMoreTokens())
				{
					d.rank[k++]=Integer.parseInt(st.nextToken());
				}
				
				int q=Integer.parseInt(br.readLine());
				while(q>0)
				{
					StringTokenizer t=new StringTokenizer(br.readLine());
					int x=Integer.parseInt(t.nextToken());
					if(x==0)
					{
						boolean b=d.union(Integer.parseInt(t.nextToken()),Integer.parseInt(t.nextToken()));
						if(b)
						{
							System.out.println("Invalid query!");
						}
					}
					else
					{
						int ans=d.findSet(Integer.parseInt(t.nextToken()));
						System.out.println(ans);
					}
					q--;
				}
				
		}
		
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
	
	private boolean union(int val1, int val2) {
		int parent1=findSet(val1);
		int parent2=findSet(val2);
		
		if(parent1==parent2)
			return true;
		//if parent1 set is larger
		if(rank[parent1] > rank[parent2])
		{
			parent[parent2]=parent1;
			rank[parent1]+=rank[parent2];
		}
		//if parent2 set is larger
		else if(rank[parent1] < rank[parent2])
		{
			parent[parent1]=parent2;
			rank[parent2]+=rank[parent1];
		}
		return false;
	}

	

}
