package src.ImpQuestion;

public class JosephusProblem {

	public static void main(String[] args) {
			int n=1000;
			System.out.println(winner(n));
	}

	private static int winner(int n) {
		int max=getMaxPowerOf2(n);
		int rem=n-max;
		//for the power of 2 no., whoever starts wins. So,converting to max power of 2 and after rem kills, whoever starts wins
		//for 100 people, 64+36 , so after 36 cuts whoever gets the blade wins i.e 2*36+1 = 73
		return 2*rem + 1;	
	}

	private static int getMaxPowerOf2(int n) {
		int p=1;
		while(p*2 < n)
		{
			p=p*2;
		}
		return p;
	}

}
