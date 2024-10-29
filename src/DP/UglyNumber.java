package src.DP;

public class UglyNumber {

	public static void main(String[] args) {
		int n=150;
		System.out.println(printUglyNumber(n));
	}

	private static int printUglyNumber(int n) {
		int i=1;
		int count = 1;
		while(count< n) {
			i++;
			count = isUgly(i) ? count+1 : count;
		}
		return i;
	}

	private static boolean isUgly(int number) {
		
		number =divideByPrime(number , 2);
		number = divideByPrime(number , 3);
		number = divideByPrime(number , 5);
		
		return (number == 1)? true : false;
	}

	private static int divideByPrime(int a, int b) {
		while(a%b == 0) {
			a= a/b;
		}
		return a;
	}

}
