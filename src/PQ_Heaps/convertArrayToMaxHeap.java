package PQ_Heaps;
public class convertArrayToMaxHeap {
	static int heap_size;
	public static void main(String[] args) {
		int[] a=new int[]{1,5,6,8,12,14,16};
		heap_size=a.length;
		System.out.println("\n--------------------------------------------------------");
		convertMaxHeap(a);
	
		System.out.println("converting array to max heap");
		for(int i=0;i<heap_size;i++)
				System.out.print(a[i]+ " ");
		System.out.println("\n--------------------------------------------------------");
		System.out.println("Max element is:"+extractMax(a));
		System.out.println("printing array after extracting max:");
		for(int i=0;i<heap_size;i++)
			System.out.print(a[i]+ " ");
		System.out.println("\n--------------------------------------------------------");
		System.out.println("Increasing the vaule of 5 to 15");
		incVal(a,4,15);	//incVal(heap,index,new value)
		System.out.println("printing array after increasing the value:");
		for(int i=0;i<heap_size;i++)
			System.out.print(a[i]+ " ");
		System.out.println("\n--------------------------------------------------------");
		System.out.println("decreasing the value of 12 to 10");
		decVal(a,1,5);	//decVal(heap,index,new value)
		System.out.println("printing array after decreasing the value: ");
		for(int i=0;i<heap_size;i++)
			System.out.print(a[i]+ " ");
		System.out.println("\n--------------------------------------------------------");
		System.out.println("Inserting 20 in the heap");
		insert(a,20);
		System.out.println("printing array after insertion of the value: ");
		for(int i=0;i<heap_size;i++)
			System.out.print(a[i]+ " ");
		
		System.out.println("\n--------------------------------------------------------");
		
		
	}

	private static void insert(int[] a, int val) {
		a[heap_size-1]=val;
		int i=heap_size-1;
		while(i>=0 && a[i]> a[(i-1)/2])
		{
			System.out.println("changing:" + a[(i-1)/2] + ">> " + a[i]);
			int temp=a[i];
			a[i]=a[(i-1)/2];
			a[(i-1)/2]=temp;
			
			i=(i-1)/2;
		}
	}

	private static void decVal(int[] a, int ind, int val) {
		if(a[ind] < val)
		{
			System.out.println("Error!!!!\nthe new value is greater than old one\nCannot decrease value!!!!");
		}
		a[ind]=val;
		maxHeapify(a,ind);
	}

	private static void incVal(int[] a, int ind, int val) {
		
		if(a[ind] > val)
		{
			System.out.println("Error!!!!\nthe new value is less than old one\nCannot Increase value!!!!");
		} 
		a[ind]=val;
		int i=ind;
		while(i>0 && a[i]> a[(i-1)/2])
		{
			
			System.out.println("changing:" + a[(i-1)/2] + ">> " + a[i]);
			int temp=a[i];
			a[i]=a[(i-1)/2];
			a[(i-1)/2]=temp;
			
			i=(i-1)/2;
		}
	}

	private static int extractMax(int[] a) {
			if(heap_size<1)
				System.out.println("UnderFloww!!!!");
			int max=a[0];
			a[0]=a[heap_size-1];
			heap_size--;
			maxHeapify(a,0);
			return max;
	}

	private static void convertMaxHeap(int[] a) {
		int len=heap_size;
		for(int i=len/2 -1;i>=0;i--)
		{
			maxHeapify(a,i);
		}
	}
	
	private static void maxHeapify(int[] a, int index) {
		int l=2*index+1;
		int r=l+1;
		int max =index;
		if(l<=heap_size-1 && a[l] > a[max])
				max=l;
		if(r<=heap_size-1 && a[r] > a[max])
				max=r;
		if(max!=index)
		{
			System.out.println("changing:" + a[index] + ">> " + a[max]);
			int temp=a[index];
			a[index]=a[max];
			a[max]=temp;
			maxHeapify(a,max);
		}
	}

	
}
