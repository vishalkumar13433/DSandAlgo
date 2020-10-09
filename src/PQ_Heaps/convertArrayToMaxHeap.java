package PQ_Heaps;
public class convertArrayToMaxHeap {
	int heap_size;

	public convertArrayToMaxHeap(int heap_size){
		this.heap_size = heap_size;
	}

	public static void main(String[] args) {
		int[] a=new int[]{1,5,6,8,12,14,16,19,0,0};
		convertArrayToMaxHeap hi = new convertArrayToMaxHeap(a.length-2);
		System.out.println("\n--------------------------------------------------------");
		hi.convertMaxHeap(a);
		System.out.println("converting array to max heap");
		printHeap(a, hi.heap_size);
		System.out.println("\n--------------------------------------------------------");


		System.out.println("Max element is:"+ hi.extractMax(a));
		System.out.println("printing array after extracting max:");
		printHeap(a, hi.heap_size);
		System.out.println("\n--------------------------------------------------------");

		System.out.println("Increasing the vaule of 1 to 19");
		hi.incVal(a,4,19);	//incVal(heap,index,new value)
		System.out.println("printing array after increasing the value:");
		printHeap(a, hi.heap_size);
		System.out.println("\n--------------------------------------------------------");

		System.out.println("decreasing the value of 16 to 7");
		hi.decVal(a,1,7);	//decVal(heap,index,new value)
		System.out.println("printing array after decreasing the value: ");
		printHeap(a, hi.heap_size);
		System.out.println("\n--------------------------------------------------------");

		System.out.println("Inserting 20 in the heap");
		hi.insert(a,20);
		System.out.println("printing array after insertion of the value: ");
		printHeap(a, hi.heap_size);
		System.out.println("\n--------------------------------------------------------");
	}
	// O(N)
	private void convertMaxHeap(int[] arr) {
		int size = this.heap_size;
		if(size <= 1) return;
		// starting with i = size/2 -1 as this is the highest index that can be a parent in BT
		for(int i= size/2 -1 ; i>=0 ; i--){
			max_heapify(arr , i);
		}
	}

	// this assumes that tree rooted at left and right child of node are max heaps
	// 0(logN) as comparison and swapping is constant time and with re- maxheapify it we have to traverse
	// upto the height of BT , which in case of nearly complete BT is 0(log N)
	private void max_heapify(int[] arr, int node) {
		int size = this.heap_size;
		int leftChild = node * 2 + 1;
		int rightChild = node * 2 + 2;
		if(leftChild >= size) return; // child are empty tree which are max heaps by default
		int max = node;
		if(arr[node] < arr[leftChild]){
			max = leftChild;
		}
		if(rightChild< size &&  arr[max] < arr[rightChild]){
			max = rightChild;
		}
		if(max != node){
			swap(arr , max , node);
			// subtree might be affected after shuffling , hence, heapifying it
			max_heapify(arr,max);
		}

	}

	private void swap(int[] arr, int node1, int node2) {
		int  temp = arr[node1];
		arr[node1] = arr[node2];
		arr[node2] = temp;
	}

	private static void printHeap(int[] a, int len ) {
		for(int i=0;i<len;i++)
			System.out.print(a[i]+ " ");
	}

	private void insert(int[] arr, int value) {
		if(heap_size >= arr.length -1){
			System.out.println("Overflow !!");
			return;
		}
		int index = heap_size;
		arr[index] = value;
		heap_size++;

		int parent = (index - 1)/2;
		while (parent < index && arr[parent] < arr[index]){
			swap(arr,parent,index);
			index = parent;
			parent = (index - 1)/2;
		}
	}

	private void decVal(int[] arr, int index, int newValue) {
		if(index<0 || index >= this.heap_size){
			System.out.println("Invalid position !!");
			return;
		}

		if(newValue >= arr[index]){
			System.out.println("new value is not smaller than the current value !!");
			return;
		}
		arr[index] = newValue;
		// only children heaps will be affected
		max_heapify(arr,index);
	}

	private void incVal(int[] arr, int index, int newValue) {
		if(index<0 || index >= this.heap_size){
			System.out.println("Invalid position !!");
			return;
		}

		if(newValue <= arr[index]){
			System.out.println("new value is not greater than the current value !!");
			return;
		}
		// increase the value
		arr[index] = newValue;

		// as key has increased , it can affect its parent's heaps only
		// if parent is less than child , swap it
		int parent = (index - 1)/2;
		while (parent < index && arr[parent] < arr[index]){
			swap(arr,parent,index);
			index = parent;
			parent = (index - 1)/2;
		}
	}

	private int extractMax(int[] a) {
		if(heap_size <= 0){
			System.out.println("Underflow !!!");
			return -1;
		}

		int currentMax = a[0];
		//1. swap max element with last element in heap
		swap(a,0,this.heap_size-1);

		//2. reduce heap size
		this.heap_size--;

		//3. max heapify root of heap
		this.max_heapify(a,0);
		return currentMax;
	}

}
