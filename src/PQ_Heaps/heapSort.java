package src.PQ_Heaps;

public class heapSort {
	static int heap_size;
	public static void main(String[] args) {
		int[] a=new int[]{12,11,13,5,6,7};
		
		heap_size=a.length;
		while(heap_size>0)
		{
			constructMaxHeap(a);
			//putting max element at end in order to make array ascending sorted
			int temp=a[heap_size -1];
			a[heap_size -1]=a[0];
			a[0]=temp;
			
			//reducing heap size, so that it will find max element of the remaining unsorted array
			heap_size--;
		}
		System.out.println("After Heap sort");
		for(int i=0;i<a.length;i++)
				System.out.print(a[i]+ " ");
	}
	private static void constructMaxHeap(int[] a) {
		
		for(int i=heap_size/2 -1;i>=0;i--)
		{
			maxHeapify(a,i);
		}
	}
	private static void maxHeapify(int[] a, int ind) {
		
		int l=2*ind +1;
		int r=l+1;
		int max;
		//calculate max of node and its left,right child
		if(l<heap_size && a[ind]<a[l])
			max=l;
		else
			max=ind;
		if(r<heap_size && a[r]>a[max])
			max=r;
		
		if(max!=ind)
		{
			int temp=a[max];
			a[max]=a[ind];
			a[ind]=temp;
			
			maxHeapify(a,max);
			
		}
	}

}
