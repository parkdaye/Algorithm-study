package kickstart2020.rounda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Plates_Test1 {
	static int N;
	static int K;
	static int P;
	static int[][] plates;
	static int sum[][];
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			max = 0;
			plates = new int[N + 1][K + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= K; j++) {
					plates[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sum = new int[N + 1][K + 1];
			
			for(int i = 1; i <= N; i++) {
				sum[i][1] = plates[i][1];
				for(int j = 2; j <= K; j++) {
					sum[i][j] = sum[i][j-1] + plates[i][j];
				}
			}

			dfs(0, 1, 0);

			System.out.println("Case #" + t + ": " + max);
		}
	}

	public static void dfs(int count, int n, int bsum) {
		if (count > P) {
			return;
		} else if (count == P) {
			max = Math.max(max, bsum);
		}

		if (n > N)
			return;

		for (int i = 0; i <= K; i++) {
			dfs(count + i, n + 1, bsum + sum[n][i]);
		}
	}

}
