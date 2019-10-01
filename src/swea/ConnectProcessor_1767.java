package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConnectProcessor_1767 {
	private static int ax[] = { -1, 1, 0, 0 };
	private static int ay[] = { 0, 0, -1, 1 };
	private static int[][] map;
	private static int N;
	private static int min = Integer.MAX_VALUE;
	private static int max = 0;
	private static int count = 0;
	private static int coreCount = 0;
	private static boolean isConnectable = false;
	private static List<Point> core;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1];
			core = new ArrayList<Point>();

			// 입력
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] == 1)
						core.add(new Point(i, j));
				}
			}

			dfs(0);

			System.out.println("#" + (t + 1) + " " + min);

		}

	}

	public static void dfs(int now) {
		if (now == core.size()) {
			if (max <= coreCount) {
				max = coreCount;
				min = Math.min(min, count);
			}
			return;
		}

		Point point = core.get(now);
		int x = point.getX();
		int y = point.getY();

		if (x == 1 || x == N || y == 1 || y == N) { // 모서리에 있을 경우
			coreCount++;
			dfs(now + 1);
		}

		if (map[x][y] == 1) {
			checkAround(now, x, y);
		}

	}

	public static void checkAround(int now, int x, int y) {
		for (int i = 0; i <= 3; i++) { // 4면 검사
				
			int nextX = x + ax[i];
			int nextY = y + ay[i];

			isConnectable = true;
			int tempCount = 0;

			while (nextX > 0 && nextX <= N && nextY > 0 && nextY <= N) {
				if (map[nextX][nextY] != 1 && map[nextX][nextY] != 2) {
					map[nextX][nextY] = 2;
					nextX += ax[i];
					nextY += ay[i];
					tempCount++;
				} else {
					isConnectable = false;

					// 연결할 수 없으면 돌려놓기
					int preX = nextX - ax[i];
					int preY = nextY - ay[i];
					while (preX != x || preY != y) {
						map[preX][preY] = 0;
						preX -= ax[i];
						preY -= ay[i];
					}
					break;
				}

			}

			if (isConnectable) {
				coreCount++;
				count += tempCount;
				
			} else if (!isConnectable && i != 0) {
				coreCount--;
			}
			dfs(now + 1); // 현재위치 옆에 있는 core 위치

			if (isConnectable) {
				int preX = nextX - ax[i];
				int preY = nextY - ay[i];
				while (preX != x || preY != y) {
					map[preX][preY] = 0;
					preX -= ax[i];
					preY -= ay[i];
				}
				count -= tempCount;
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
