import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallestElementInUnsortedArray {
	static int heap_size;
	public static void main(String[] args) {
		int arr[]=new int[] {7,10,4,3,20,15};
		int k=3;
		//creating min heap of array element
		/*heap_size=arr.length;
		create_Heap(arr);
		
		
		//calling extract_min for k-1 times i.e removing k-1 smallest elements So, The result is kth smallest number 
		for(int i=0;i<k-1;i++)
			extract_min(arr);
			*/
		
		//using Collection Class Priority Queue , MAX HEAP OF SIZE K
		PriorityQueue<Integer> max=new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<k;i++)
				max.add(arr[i]);
		for(int i=k;i<arr.length;i++)
		{
			if(arr[i] < max.peek())
			{
				max.poll();
				max.offer(arr[i]);
			}
		}
		System.out.println(k +" smallest element is:" +max.peek());	
	}

	private static void extract_min(int[] arr) {
		
		arr[0]=arr[heap_size -1];
		heap_size--;
		minHeapify(arr,0);
	}

	private static void create_Heap(int[] arr) {
		int n=arr.length;
		for(int i=(heap_size-1)/2;i>=0;i--)
			minHeapify(arr,i);
	}

	private static void minHeapify(int[] arr, int i) {
		
		int left=i*2 +1;
		int right=i*2 +2;
		
		int min=i;
		if(left<heap_size-1 && arr[left] < arr[i])
			min=left;
		if(right<heap_size-1 && arr[right] < arr[min])
			min=right;
		
		if(min!=i)
		{
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
			
			minHeapify(arr,min);
		}
	}

}
