package kickstart2020.rounda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Plates_Test2 {
	static int N;
	static int K;
	static int P;
	static int[][] plates;
	static int sum[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			plates = new int[N + 1][K + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= K; j++) {
					plates[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sum = new int[N + 1][K + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= K; j++) {
					sum[i][j] = sum[i][j - 1] + plates[i][j];
				}
			}

			int d[][] = new int[N + 1][P + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= P; j++) {

					for (int x = 0; x <= Math.min(j, K); x++) {
						d[i][j] = Math.max(d[i][j], sum[i][x] + d[i - 1][j - x]);
					}
				}
			}

			System.out.println("Case #" + t + ": " + d[N][P]);
		}
	}

}
