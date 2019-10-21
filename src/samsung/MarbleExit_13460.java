package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MarbleExit_13460 {
	static char[][] map;
	static int N;
	static int M;
	static int[] ax = { -1, 1, 0, 0 };
	static int[] ay = { 0, 0, -1, 1 };
	static boolean[][][][] checked;
	static int min;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		map = new char[N + 1][M + 1];
		checked = new boolean[10][10][10][10];

		int rx = 0, ry = 0, bx = 0, by = 0;

		for (int i = 1; i <= N; i++) {
			String temp = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = temp.charAt(j - 1);
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				}
				if (map[i][j] == 'B') {
					bx = i;
					by = j;
				}

			}
		}

		play(new Point(rx, ry, bx, by, 0));

		System.out.println(min);
	}

	private static void play(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(point);
		checked[point.getRx()][point.getRy()][point.getBx()][point.getBy()] = true;

		while (!q.isEmpty()) {

			Point front = q.remove();

			int count = front.getDepth();
			if (count > 10) {
				min = -1;
				break;
			}

			if (map[front.getRx()][front.getRy()] == 'O') {
				min = count;
				break;
			}

			for (int i = 0; i < 4; i++) { // 방향
				int rx = front.getRx();
				int ry = front.getRy();
				int bx = front.getBx();
				int by = front.getBy();

				// red 이동
				while (true) {
					rx += ax[i];
					ry += ay[i];

					if (map[rx][ry] == '#' || map[rx][ry] == 'O') {
						if (map[rx][ry] == '#') {
							rx -= ax[i];
							ry -= ay[i];
						}
						break;
					}

				}

				// blue 이동
				while (true) {
					bx += ax[i];
					by += ay[i];
					if (map[bx][by] == '#' || map[bx][by] == 'O') {
						if (map[bx][by] == '#') {
							bx -= ax[i];
							by -= ay[i];
						}
						break;
					}
				}

				// 이동한 blue가 구멍이면 다른 길 탐색
				if (map[bx][by] == 'O') {
					continue;
				}

				// 빨간색과 파란색이 같은 선상에 있을 경우 위치 조정
				if (rx == bx && ry == by) {
					switch (i) {
					// 위로 올리갈 경우
					case 0:
						if (front.getRx() < front.getBx())
							bx++;
						else
							rx++;
						break;

					// 밑으로 내려갈 경우
					case 1:
						if (front.getRx() < front.getBx())
							rx--;
						else
							bx++;
						break;
					// 왼쪽으로 갈 경우
					case 2:
						if (front.getRy() < front.getBy())
							by++;
						else
							ry++;
						break;
					// 오른쪽으로 갈 경우
					case 3:
						if (front.getRy() < front.getBy())
							ry--;
						else
							by--;
						break;
					}
				}

				// 방문하지 않은 경우에만 카운트
				if (checked[rx][ry][bx][by]) {
					continue;
				} else {
					checked[rx][ry][bx][by] = true;
					q.offer(new Point(rx, ry, bx, by, front.getDepth() + 1));
				}
			}
		}

		if (min == Integer.MAX_VALUE)
			min = -1;

	}

}

class Point {
	int rx;
	int ry;
	int bx;
	int by;
	int depth;

	public Point(int rx, int ry, int bx, int by, int depth) {
		super();
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.depth = depth;
	}

	public int getRx() {
		return rx;
	}

	public int getRy() {
		return ry;
	}

	public int getBx() {
		return bx;
	}

	public int getBy() {
		return by;
	}

	public int getDepth() {
		return depth;
	}
}