package src.BitManipulation;

public class powerof4 {

	public static void main(String[] args) {
		System.out.println(isPowerOf4(16));
		System.out.println(isPowerOf4(8));
	}

	private static boolean isPowerOf4(int n) {
		return (n>0) && (n & (n-1))==0 && (n & 0x55555555)!=0;
        //1. if n is less than 0  -> false
        //2. if number is not power of 2 it cannot be power of 4 
        //3. distinguish numbers that are power of 2 but not power of 4;
        //using trick that 0x55555555 is 010101010101010101010101010101 in binary with a length of 32. 
		//To make sure the 1 locates in the odd location.
	}

}
