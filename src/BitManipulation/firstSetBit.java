package src.BitManipulation;

public class firstSetBit {

	public static void main(String[] args) {
		System.out.println(findFirstSetBit(18));
		System.out.println(findFirstSetBit(19));
		System.out.println(findFirstSetBit(1));
		System.out.println(findFirstSetBit(2));
		System.out.println(findFirstSetBit(0));
		System.out.println(findFirstSetBit(16));
	}

	private static int findFirstSetBit(int num) {
		int temp=num,cnt=0;
		while(temp!=0)
		{
			if((temp & 1) == 1)
			{
				break;
			}
			cnt++;
			temp=temp>>1;
		}
		return cnt;
	}

}
