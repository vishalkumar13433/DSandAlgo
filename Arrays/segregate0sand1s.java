
public class segregate0sand1s {

	public static void main(String[] args) {

        int arr[] = new int[]{ 1,0, 1, 0, 1, 1, 1 }; 
        int n = arr.length; 
        //Traverses array twice
        System.out.println("Method1:");
        segregate0and1(arr, n); 
        print(arr, n); 
        
        //Traverses once
        System.out.println("\nMethod2:");
        segregate(arr,n);
        print(arr, n);
        
        //Traverses once
        System.out.println("\nMethod3:");
        seg(arr,n);
        print(arr, n);
	}
	
	//Method1
	private static void segregate0and1(int[] arr, int n) {
		int cnt0s=0;
		//1.have the count of 0s in the array
		for(int i=0;i<n;i++)
			 if(arr[i]==0)
				 cnt0s++;
		 //put that many 0s first in array
		 for(int i=0;i<cnt0s;i++)
			 arr[i]=0;
		 //remaining 1s 
		 for(int i=cnt0s;i<n;i++)
			 arr[i]=1;
	}
	//Method2
	private static void segregate(int[] arr, int n) {
		int start=0,end=n-1;
		 
		 while(start<end)
		 {
			 while(arr[start]==0 && start<end)
				 start++;
			 //after previous loop element at start is 1
			 while(arr[end]==1 && start<end)
				 end--;
			 //after previous loop element at end is 0
			 //So,Swap them
			 if(start<end)
			 {
				 arr[start]=0;
				 arr[end]=1;
				 start++;
				 end--;
			 }
		 }
	}
	//Method3
	 private static void seg(int[] arr, int n) {
		 
		 int start=0,end=n-1;
		 while(start<end)
		 {
			 if(arr[start]==1)
			 {
				 //swap start and end .. 
				 int temp=arr[end];
				 arr[end]=arr[start];
				 arr[start]=temp;
				 
				 //meaning end will always have 1 after this . so,end--
				 end--;
			 }
			 else
				 start++;
		 }
	}
	 
	static void print(int arr[], int n) 
	    { 
	        System.out.print("Array after segregation is "); 
	        for (int i = 0; i < n; i++) 
	            System.out.print(arr[i] + " ");     
	    } 
}
