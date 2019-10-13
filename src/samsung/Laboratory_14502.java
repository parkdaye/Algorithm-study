package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory_14502 {
	static int map[][];
	static int N;
	static int M;
	static int max;
	static int[] ax = { -1, 1, 0, 0 };
	static int[] ay = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		max = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		generateWall();

		System.out.println(max);
	}

	private static void generateWall() {
		int size = N * M;
		// 방번호 조합
		for (int i = 1; i <= size; i++) {
			for (int j = i + 1; j <= size; j++) {
				for (int k = j + 1; k <= size; k++) {

					// 좀더 예쁘게 풀 수 없나...
					int ix = (int) Math.ceil((double) i / M);
					int iy = i % M == 0 ? M : i % M;
					int jx = (int) Math.ceil((double) j / M);
					int jy = j % M == 0 ? M : j % M;
					int kx = (int) Math.ceil((double) k / M);
					int ky = k % M == 0 ? M : k % M;

					// 벽을 놓을 수 없는 위치이면
					if (map[ix][iy] == 1 || map[ix][iy] == 2 || map[jx][jy] == 1 || map[jx][jy] == 2 || map[kx][ky] == 1
							|| map[kx][ky] == 2)
						continue;

					List<Points> walls = new ArrayList<Points>();
					walls.add(new Points(ix, iy));
					walls.add(new Points(jx, jy));
					walls.add(new Points(kx, ky));

					int safeSize = countSafe(map, walls);
					max = Math.max(max, safeSize);
				}
			}
		}
	}

	private static int countSafe(int[][] map, List<Points> walls) {
		int count = 0;
		int[][] copyMap = new int[N + 1][M + 1];
		boolean[][] visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}

		// 벽을 표시해줌
		for (int i = 0; i < walls.size(); i++) {
			Points wall = walls.get(i);
			copyMap[wall.getX()][wall.getY()] = 1;
		}

		Queue<Points> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (copyMap[i][j] == 2) {
					q.add(new Points(i, j));
					visited[i][j] = true;

					while (!q.isEmpty()) {
						Points head = q.remove();
						int x = head.getX();
						int y = head.getY();

						for (int k = 0; k < 4; k++) {
							int nx = x + ax[k];
							int ny = y + ay[k];

							if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
								if (!visited[nx][ny] && copyMap[nx][ny] != 1) {
									q.add(new Points(nx, ny));
									visited[nx][ny] = true;
									copyMap[nx][ny] = 2;
								}
							}
						}
					}

				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (copyMap[i][j] == 0)
					count++;
			}
		}
		return count;
	}

}

class Points {
	int x;
	int y;

	public Points(int x, int y) {
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
