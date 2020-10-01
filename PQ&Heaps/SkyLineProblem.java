import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class SkyLineProblem {

	public static void main(String[] args) {
//		int[][] buildings= { {1,3,3} , {2,4,4} , {5,8,2} , {6,7,4} , {8,9,4}};
		
		//BOUNDARY CASES FOR THIS PROBLEM
		int[][] buildings= { {0,3,2},{1,3,1}};//if both building end at same point 
		//int[][] buildings= { {0,2,3},{0,3,4}}; //if both building start at same point 
		//int[][] buildings= { {0,2,3},{2,5,3}}; //if one building ends and another building of same height is starting from there 
		
		List<int[]> ans=new ArrayList();
		getSkyline(buildings,ans);
	
		for(int[] i :ans)
		{
			System.out.println(i[0] + " " + i[1]);
		}
	}

	private static void getSkyline(int[][] buildings, List<int[]> ans) {
		
		BuildingPoints[] build=new BuildingPoints[buildings.length * 2];
		int k=0;
		for(int i=0;i<buildings.length;i++)
		{
			build[k]=new BuildingPoints();
			build[k].x=buildings[i][0];
			build[k].height=buildings[i][2];
			build[k].isStart=true;
			
			build[k+1]=new BuildingPoints();
			build[k+1].x=buildings[i][1];
			build[k+1].height=buildings[i][2];
			build[k+1].isStart=false;
			k+=2;
		}
	
		Arrays.sort(build);
		
		for(int i=0;i<build.length;i++)
		{
			BuildingPoints element=build[i];
			System.out.println(element.x);
			System.out.println(element.height);
			System.out.println(element.isStart);
			System.out.println("\n-----------------");
		}
		
		PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
		pq.add(0);
		for(int i=0;i<build.length;i++)
		{
			BuildingPoints element=build[i];
			if(element.isStart)
			{
				if(pq.peek() < element.height)
				{
					ans.add(new int[] {element.x,element.height});
				}
				pq.add(element.height);
			}
			else
			{
				int x=pq.peek();
				if(x == element.height)
				{
					int temp=pq.poll();	
					if(temp!=pq.peek())	//to handle case where if one building ends and another building of same height is starting from there 
					ans.add(new int[] {element.x,pq.peek()});
				}
				else
				{
					pq.remove(element.height);
				}
			}
				
		}
	}

	

}
