package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting_2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int N[] = new int[n+2];
		int dp[][] = new int[n+2][2];
		
		for(int i = 1; i <= n; i++) {
			N[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][0] = N[1];
		dp[1][1] = N[1];
		dp[2][0] = N[2];
		dp[2][1] = N[1] + N[2];
		for(int i = 3; i <= n + 1; i++) {
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + N[i];
			dp[i][1] = dp[i-1][0] + N[i];
		}
		
		System.out.println(Math.max(dp[n +1][0], dp[n+1][1]));
		
	}

}
