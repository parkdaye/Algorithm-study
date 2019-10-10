package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Snake_3190 {
	static int N;
	static int K;
	static int map[][];
	static int ax[] = { -1, 1, 0, 0 };
	static int ay[] = { 0, 0, -1, 1 };
	static int time = 0;
	static boolean isGameOver = false;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}

		int k = 3; // k는 방향
		int x = 1;
		int y = 1;
		Queue<Location> q = new LinkedList<>();
		q.add(new Location(x, y));
		map[x][y] = 2;

		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());

			// 시간 X만큼 이동
			while (time < X) {
				int nx = x + ax[k];
				int ny = y + ay[k];

				// 다음 좌표가 벽일거나 자기자신을 만났을 경우
				if (nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny] == 2) {
					isGameOver = true;
					break;
				}

				q.add(new Location(nx, ny));
				x = nx;
				y = ny;
				time++;

				// 다음 좌표가 사과일 경우
				if (map[nx][ny] == 1) {
					map[nx][ny] = 2;
					continue;
				}

				// 사과가 아니면 이전 좌표는 0으로 다시 바꿔줌
				Location tail = q.remove();
				int tailx = tail.getX();
				int taily = tail.getY();
				map[tailx][taily] = 0;
				map[nx][ny] = 2;
			}

			if (isGameOver) {
				break;
			}

			// 방향 바꿔주기
			char C = st.nextToken().charAt(0);
			switch (C) {
			case 'L':
				if (k == 0) {
					k = 2;
				} else if (k == 1) {
					k = 3;
				} else if (k == 2) {
					k = 1;
				} else {
					k = 0;
				}
				break;
			case 'D':
				if (k == 0) {
					k = 3;
				} else if (k == 1) {
					k = 2;
				} else if (k == 2) {
					k = 0;
				} else {
					k = 1;
				}
				break;
			}
		}

		// 주어진 방향대로 돌았는데 끝이 안남
		if (!isGameOver) {
			int nx = x + ax[k];
			int ny = y + ay[k];
			while (nx > 0 && nx <= N && ny > 0 && ny <= N && map[nx][ny] != 2) {
				time++;
				nx += ax[k];
				ny += ay[k];
			}
		}

		System.out.println(time+1);

	}
}

class Location {
	int x;
	int y;

	public Location(int x, int y) {
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
