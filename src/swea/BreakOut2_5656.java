package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreakOut2_5656 {
	static int N;
	static int W;
	static int H;
	static int[] ax = { -1, 1, 0, 0 };
	static int[] ay = { 0, 0, -1, 1 };
	static int map[][];
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H + 1][W + 1];

			for (int i = 1; i <= H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						count++;
				}
			}

			for (int n = 1; n <= W; n++) {
				shoot(n, 1, map);
			}
		}

	}

	private static void shoot(int c, int count, int[][] map) {
		if (count == N) {

			return;
		}

		int copyMap[][] = new int[H + 1][W + 1];
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		boolean[][] checked = new boolean[H + 1][W + 1];
		for (int i = 1; i <= H; i++) {
			if (map[i][c] != 0) {
				removeBricks(i, c, copyMap, checked);
			}
		}
		
		//블록 내려주기
		for(int i = 1; i <= W; i++) {
			int now = copyMap[0][i];
			for(int j = H; j > 1; j--) {
				int next = copyMap[j-1][i];
				
				while(now == 0) {
					next = now;
				}
			}
		}

		for (int n = 1; n <= W; n++) {
			shoot(n, count + 1, copyMap);
		}

	}

	private static void removeBricks(int x, int y, int[][] copyMap, boolean[][] checked) {
		if (map[x][y] == 1) {
			copyMap[x][y] = 0;
			checked[x][y] = true;
			count--;
			return;
		}

		for (int i = 1; i < map[x][y]; i++) {
			for (int k = 0; k < 3; k++) {
				int nx = x + i * ax[k];
				int ny = y + i * ay[k];

				if (nx > 0 && nx <= H && ny > 0 && ny <= W) {
					if (!checked[nx][ny] && map[nx][ny] != 0) {
						copyMap[nx][ny] = 0;
						checked[nx][ny] = true;
						removeBricks(nx, ny, copyMap, checked);
					}
				}
			}

		}
	}
}
