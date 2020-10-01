package ImpQuestion;

public class RangeSumQuery {
	int[] segmentArr;
	int seg_size;
	
	public RangeSumQuery(int[] input) {
		
		int pow = (int) (Math.ceil(Math.log(input.length) / Math.log(2)));  
		seg_size= (int) Math.pow(2, pow+1) -1;
		System.out.println("Len:" + seg_size);
		this.segmentArr=new int[seg_size];
		this.fillSegArray(input,0,0,input.length-1);
	}


	private int fillSegArray(int[] input,int pos,int start,int end) {
		if(start > end)
			return 0;
		if(start==end)
			{
				segmentArr[pos]=input[start];
				return input[start];
			}
		int mid=(start+end)/2;
		int n1=fillSegArray(input,2*pos+1,start,mid);
		int n2=fillSegArray(input,2*pos+2,mid+1,end);
		segmentArr[pos]=n1+n2;
		return n1+n2;
	}


	public static void main(String[] args) {
		int[] input= {-2, 0, 3, -5, 2, -1};
		int n=input.length;
		RangeSumQuery r= new RangeSumQuery(input);
		for(int i=0;i<r.seg_size;i++)
			System.out.print(r.segmentArr[i] + " ");
		System.out.println("Sum of values in given range = " + 
                r.getSum(0,n-1, 0, 2,0)); 
		System.out.println("Sum of values in given range = " + 
                r.getSum(0,n-1, 2, 5,0)); 
		System.out.println("Sum of values in given range = " + 
                r.getSum(0,n-1, 0, 5,0)); 
		
	}


	private int getSum(int start, int end,int range_s,int range_e,int pos) {
		if(range_s > end || range_e < start)
			return 0;
		if(range_s <= start && range_e >=end)
			return this.segmentArr[pos];
		int mid=(start+end)/2;
		return  this.getSum(start, mid, range_s, range_e, 2*pos+1) + this.getSum( mid+1,end, range_s, range_e, 2*pos+2);
	}

}
