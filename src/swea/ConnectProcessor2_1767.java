package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConnectProcessor2_1767 {
	static int[] ax = { -1, 1, 0, 0 };
	static int[] ay = { 0, 0, -1, 1 };
	static int[][] map;
	static List<Point> core;
	static int N;
	static int max;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1];
			core = new ArrayList<Point>();
			max = 0;
			answer = 0;
			boolean[][] isChecked = new boolean[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						core.add(new Point(i, j));
					}
				}
			}

			dfs(0, 0, 0, isChecked);

			System.out.println("#" + (t + 1) + " " + answer);
		}
	}

	public static void dfs(int now, int coreCount, int lineSize, boolean[][] isChecked) {
		if (now == core.size()) {
			if (max < coreCount) {
				max = coreCount;
				answer = lineSize;
			} else if (max == coreCount) {
				if (answer > lineSize)
					answer = lineSize;
			}
			return;
		}
		
		if(coreCount + (core.size() - now) < max)
			return;

		Point point = core.get(now);
		int coreX = point.getX();
		int coreY = point.getY();

		// 현재 코어에 이미 전원이 연결
		if (coreX == 1 || coreX == N || coreY == 1 || coreY == N) {
			dfs(now + 1, coreCount + 1, lineSize, isChecked);
			return;
		}

		for (int k = 0; k <= 3; k++) {
			int nx = coreX + ax[k];
			int ny = coreY + ay[k];

			// 가려는 방향에 이미 코어가 있거나 전선이 놓여있는 경우 불가능
			boolean isPossible = true;
			while (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
				if (map[nx][ny] == 1 || isChecked[nx][ny] == true)
					isPossible = false;

				nx += ax[k];
				ny += ay[k];
			}

			// 전선을 놓을 수 있으면 체크
			if (isPossible) {
				nx = coreX + ax[k];
				ny = coreY + ay[k];
				boolean[][] copyChecked = new boolean[N + 1][N + 1];

				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						copyChecked[i][j] = isChecked[i][j];
					}
				}

				int tempLine = 0;
				while (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
					copyChecked[nx][ny] = true;
					tempLine++;

					nx += ax[k];
					ny += ay[k];
				}

				dfs(now + 1, coreCount + 1, lineSize + tempLine, copyChecked);
			} else {
				dfs(now + 1, coreCount, lineSize, isChecked);
			}

		}

	}
}

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

