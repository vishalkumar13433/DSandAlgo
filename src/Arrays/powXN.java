package src.Arrays;

public class powXN {

	 public static void main(String[] args) 
	    { 
	        int x = 2; 
	        int y = 3; 
	  
	        System.out.printf("%d", power(x, y)); 
	    }
	private static int power(int x, int y) {
		if(y==0) return 1;
		if(y==1) return x;
		if(y<0) return power(1/x, -1 * y);
		if(y %2 ==0) {
//			return power(x, y/2) * power(x, y/2);
			int temp = power(x, y/2);
			return temp * temp;
		}
		return x * power(x, y-1);
	} 
}
