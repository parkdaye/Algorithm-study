package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreakOut_5656 {
	static int[] ax = { -1, 1, 0, 0 };
	static int[] ay = { 0, 0, -1, 1 };
	static int[][] map;
	static int N;
	static int W;
	static int H;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		min = Integer.MAX_VALUE;
		map = new int[H + 1][W + 1];
		boolean checked[][] = new boolean[H + 1][W + 1];
		int remains = 0;

		for (int i = 1; i <= H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0)
					remains++;
			}
		}

		for (int i = 1; i <= N; i++) {
			dfs(i, remains, checked);
		}

		System.out.println(min);
	}

	public static void dfs(int count, int remains, boolean[][] checked) {
		if (count == N) {
			min = Math.min(min, remains);
			return;
		}

		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= H; j++) { // map을 내려가며 탐색
				if (map[j][i] != 0) {
					remove(j, i, remains, checked);
					break;
				}
			}
			dfs(count + 1, remains, checked);
		}

	}

	public static void remove(int x, int y, int remains, boolean[][] checked) {

		checked[x][y] = true;
		
		if (map[x][y] == 0) {
			return;
		}

		int brickNumber = map[x][y]; // 깰 벽돌의 수

		for (int k = 0; k <= 3; k++) { // 주위의 4면
			int nX = x + ax[k];
			int nY = y + ay[k];

			for (int b = 0; b < brickNumber; b++) { // 깰 벽돌만큼

				if (nX > 0 && nX <= H && nY > 0 && nY <= W) {
					if (checked[nX][nY] == true) {
						b--; // 이미 체크가 되어있으면 스킵한다. 과연 checked는 스택 반환에 바뀔 것인가???
						nX += ax[k];
						nY += ay[k];
						continue;
					}

					if (map[nX][nY] != 0) {
						remains--;
						checked[nX][nY] = true;
						remove(nX, nY, remains, checked);
					}
				}
			}
		}
	}

}
