package src.ImpQuestion;

public class SegmentTree extends Thread{
	
	int[] segmentArr;
	
	SegmentTree(int[] input)
	{
		//calculate next power of 2 and calculate no of elements in Segment Tree Array
		int x = (int) (Math.ceil(Math.log(input.length) / Math.log(2)));   
        int max_size =(int) Math.pow(2, x+1) - 1; 
        
        // allocate memory 
        this.segmentArr = new int[max_size];
        System.out.println("Len:" + max_size);
        
        
        //Filling elements with Infinity
        for(int i=0;i<this.segmentArr.length;i++)
        	this.segmentArr[i]=Integer.MAX_VALUE;
        
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		 int input[] = {0,3,4,2,1,6,-1};
		 SegmentTree st=new SegmentTree(input);
		 st.FillSegmentTree(input,0,input.length-1 , 0);
		 for(int i=0;i<st.segmentArr.length;i++)
			 System.out.print(st.segmentArr[i] + " ");
		 
		 System.out.println("\nMin from 0 - 3 is ==> " +  st.rangeMinimumQuery(input, 0, 3, 0,input.length-1,0));
		 System.out.println("\nMin from 1 - 5 is ==> " +  st.rangeMinimumQuery(input, 1, 5, 0,input.length-1,0));
	}
	private int rangeMinimumQuery(int[] input, int range_s, int range_e, int start, int end, int pos) throws InterruptedException {
		
		System.out.println("At element : "+start + " - > "+ end);
		
		Thread.sleep(1000);
		
		//1. No Overlap
			
			if(range_s > end || range_e< start)
					return Integer.MAX_VALUE;
			
		//2. Total Overlap
		
			if(range_s <= start && end <=range_e)
					return this.segmentArr[pos];
			
		//3. Partial Overlap
		int mid=(start+end)/2;
			
		return Math.min(rangeMinimumQuery(input,range_s,range_e,start,mid,2*pos + 1), rangeMinimumQuery(input,range_s,range_e,mid+1,end,2*pos + 2));
		
	}

	private void FillSegmentTree(int[] input, int start, int end, int pos) {
		if(start==end)
			{
				segmentArr[pos]=input[start];
				return;
			}
		int mid=(start+end)/2;
		FillSegmentTree(input,start,mid,2*pos + 1);
		FillSegmentTree(input,mid+1,end,2*pos + 2);
		segmentArr[pos]=Integer.min(segmentArr[2*pos + 1], segmentArr[2*pos + 2]);
	}


}
