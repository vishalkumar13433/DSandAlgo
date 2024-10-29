package src.BitManipulation;

public class findNumberAppearOnceOthersAppearTwice {

	public static void main(String[] args) {

		int[] arr= {3,5,4,7,5,3,4};
		System.out.println(findSingleOccurence(arr));
	}

	private static int findSingleOccurence(int[] arr) {
		
		int xor=0;
		for(int i=0;i<arr.length;i++)
		{
			xor=xor^arr[i];
		}
		return xor;
	}

}
