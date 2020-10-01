
public class numberOf1Bits {

	public static void main(String[] args) {
		System.out.println(hammingWeight(00000000000000000000000000001011));
		System.out.println(hammingWeight(00000000000000000000000010000000));
		System.out.println(hammingWeight(56));
		System.out.println(hammingWeight(15));
		
		//METHOD 2;
		
		System.out.println(noOfBits(15));
		System.out.println(noOfBits(00000000000000000000000000001011));
	}
	
	
	private static int noOfBits(int i) {
		return Integer.bitCount(i);
	}
	
	
	public static int hammingWeight(int num) {
        int temp=num,cnt=0;
		while(temp!=0)
		{
			if((temp & 1) == 1)
			{
				cnt++;
			}
			temp=temp>>>1;	//n = n>>>1;
				//We need to use bit shifting unsigned operation >>> (while >> depends on sign extension)
		}
		return cnt;
    }
}
