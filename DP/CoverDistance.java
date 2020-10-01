import java.util.Arrays;

public class CoverDistance {

	public static void main (String[] args)  
    { 
        int dist = 4; 
        System.out.println(printCount(dist)); 
        int[] dp = new int[dist+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        System.out.println(printCountDP(dist,dp)); 
    }

	private static int printCountDP(int dist, int[] dp) {
		if(dist <0) return 0;
		if(dp[dist] != -1) {
			return dp[dist];
		}
		dp[dist] = printCountDP(dist-1 , dp) + printCountDP(dist-2 , dp) + 
				printCountDP(dist-3 , dp);
		return dp[dist];
	}

	private static int printCount(int dist) {
		if(dist == 0) return 1;
		if(dist <0) return 0;
		return printCount(dist-1) + printCount(dist-2) + printCount(dist-3);
	} 
}
