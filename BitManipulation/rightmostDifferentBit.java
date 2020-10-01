
public class rightmostDifferentBit {

	public static void main(String[] args) {
		System.out.println("For 11 & 9");
		System.out.println(rightMostDifferent(11,9));
		System.out.println("For 52 & 4");
		System.out.println(rightMostDifferent(52,4));
	}

	private static int rightMostDifferent(int num1, int num2) {
	
		int cnt=0;
		while(num1!=0 || num2!=0)
		{
			int bit1=(num1&1) , bit2=(num2&1);
			System.out.println("Bit1 : " + bit1);
			System.out.println("Bit2 : " + bit2);
			
			cnt++;
			int xor=(bit1 ^ bit2);
			if(xor == 1)
				break;
			
			
			num1=num1 >> 1;
			num2=num2 >>1;
		}
		System.out.println("\n--------------------------------------");
		return cnt;
	}

}
