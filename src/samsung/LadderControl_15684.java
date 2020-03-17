package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LadderControl_15684 {
	static int N;
	static int M;
	static int H;
	static boolean isPossible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		boolean ladder[][] = new boolean[H + 1][N];

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}

		dfs(0, 0, ladder);
		if(isPossible) {
			System.out.println(0);
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			dfs(1, i, ladder);
			if(isPossible) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
	}

	private static void dfs(int count, int n, boolean[][] ladder) {
		if (count > n || count == 0) {
			for (int i = 1; i <= N; i++) {

				int now = i;
				for (int j = 1; j <= H; j++) {
					if (now == 1 && ladder[j][now])
						now++;
					else if (now == N && ladder[j][now - 1])
						now--;
					else if (now > 1 && now < N)
						if (ladder[j][now])
							now++;
						else if(ladder[j][now - 1])
							now--;
				}
				
				if(i != now)
					return;
			}

			isPossible = true;
			return;
		}

		if(isPossible)
			return;

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				
				boolean[][] copy = new boolean[H + 1][N];
				for (int h = 1; h <= H; h++) {
					for (int l = 1; l < N; l++) {
						copy[h][l] = ladder[h][l];
					}
				}
				
				boolean isContinue = false;
				if (!ladder[i][j]) {
					if(N <= 2) {
						copy[i][j] = true;
						dfs(count + 1, n, copy);
						return;
					}
					
					if (j == 1 && ladder[i][j+1])
						isContinue = true;
					else if (j == N - 1 && ladder[i][j - 1])
						isContinue = true;
					else if (j > 1 && j < N - 1 && (ladder[i][j - 1] || ladder[i][j + 1]))
						isContinue = true;

					if (!isContinue) {
						copy[i][j] = true;
						dfs(count + 1, n, copy);
					}
				}
			}
		}
	}

}
