import java.util.Arrays;

public class KnapsackZeroOne {

	public static void main(String[] args) {
		KnapsackZeroOne k = new KnapsackZeroOne();
	        int val[] = {1,4,5,7};
	        int wt[] = {1,3,4,5};
	        int r = k.bottomUpDP(val, wt, 7);
	        int rm = k.bottomUpMemoizedDP(val, wt, 7,wt.length-1);
	        System.out.println(r);
	        System.out.println(rm);
	}

/*
 *	Recursive Solution
	private int bottomUpMemoizedDP(int[] val, int[] wt, int capacity,int cur) {
		
		if(cur< 0)
				return 0;
		if(wt[cur] > capacity)
				return this.bottomUpMemoizedDP(val, wt, capacity,cur-1);
		return Integer.max(val[cur] + this.bottomUpMemoizedDP(val, wt, capacity-wt[cur],cur-1), this.bottomUpMemoizedDP(val, wt, capacity, cur-1));
	}
*/

	private int bottomUpMemoizedDP(int[] val, int[] wt, int capacity, int len) {
		int[][] memo=new int[len+1][capacity+1];
		for(int i=0;i<=len;i++)
			Arrays.fill(memo[i], -1);
		return memoizedDPKP(val,wt,capacity,len,memo);
	}

	private int memoizedDPKP(int[] val, int[] wt, int capacity, int len, int[][] memo) {
		if(len<0)
			return 0;
		
		if(memo[len][capacity] != -1)
			return memo[len][capacity];
		int v=0;
		if(wt[len] > capacity)	//if not selected
			v=memoizedDPKP(val,wt,capacity,len-1,memo);
		else				//if selected														//if not selected
			v=Integer.max(val[len]+memoizedDPKP(val,wt,capacity-wt[len],len-1,memo), memoizedDPKP(val,wt,capacity,len-1,memo));
		memo[len][capacity]=v;
		return v;
	}

	private int bottomUpDP(int[] val, int[] wt, int max) {
		
		int[][]temp=new int[val.length+1][max+1];
		
		int i,j=0;
		for(i=0;i<=val.length;i++)
		{
			for(j=0;j<max+1;j++)
			{
				if(i == 0 || j == 0){
                    temp[i][j] = 0;
                    continue;
                }
				if(wt[i-1] > j)
				{
					temp[i][j]=temp[i-1][j];
				}
				else
				{
					temp[i][j]=Math.max(temp[i-1][j], val[i-1]+ temp[i-1][j-wt[i-1]]);
				}
			}
		}
		System.out.println("-------------------------------");
		for(i=0;i<=val.length;i++)
		{
			for(j=0;j<=max;j++)
			{
				System.out.print(temp[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.println("-------------------------------");
		printItemsPicked(temp,val,wt);
		return temp[i-1][j-1];
	}

	private void printItemsPicked(int[][] temp, int[] val, int[] wt) {
		
		int i=val.length,j=temp[0].length-1;
		
		while(i!=0 && j!=0)
		{
			if(temp[i][j]==temp[i-1][j])
			{
				i--;
			}
			else
			{
				System.out.println("Selected item with weight:"+wt[i-1]+" and value:"+val[i-1]);
				j=j-wt[i-1];
				i--;
			}
		}
	}

}
