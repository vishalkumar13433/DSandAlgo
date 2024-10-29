package src.Arrays;

public class GenerateAllParanthesis {

	public static void main(String[] args) {
		int n=3;
		printAllParanthesis(n , n , "");
	}

	private static void printAllParanthesis(int open, int close , String finalStr) {
		if(open<0 || open > close) {
			return;
		}
		if(open == 0 && close == 0) {
			System.out.println(finalStr);
			return;
		}
		printAllParanthesis(open-1,close,finalStr+"(");
		printAllParanthesis(open, close-1, finalStr+")");
	}

}
