package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting_2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int N[] = new int[n + 1];
		int dp[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			N[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = N[1];
		
		if(n == 1) {
			System.out.println(dp[1]);
			return;
		}
			
		
		dp[2] = N[1] + N[2];
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(Math.max(dp[i-1], dp[i-2] + N[i]), dp[i-3] + N[i] + N[i-1]);
		}

		System.out.println(dp[n]);

	}

}
