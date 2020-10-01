//import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BribingHackerrank {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }

	private static void minimumBribes(int[] q) {
		
		int ans=0;
		
		for(int i=0;i<q.length;i++)
		{
			int temp=q[i]-i-1;
			if(temp > 0)
			{
				ans+=temp;
			}
		}
	}

}
