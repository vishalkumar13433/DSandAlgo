package BitManipulation;

public class PowerOftwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(16));
	}

	public static boolean isPowerOfTwo(int n) {
        if(n<=0)	// <= fixes problem for 0 and lesser number cannot be power of zero
            return false;
        if(n==1)
            return true;
        return (n & (n-1))==0;
    }
	
}
