package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gerrymandering2_17779 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int answer = Integer.MAX_VALUE;
		int sum = 0;
		int[][] map = new int[N + 1][N + 1];
		Point[] p = new Point[5];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				p[1] = new Point(i, j);

				// 1. 좌표를 구한다
				// 오른쪽으로 내려가기
				for (int r = 1; i + r <= N && j + r <= N; r++) {
					p[2] = new Point(i + r, j + r);

					// 왼쪽으로 내려가기
					for (int l = 1; p[2].getX() + l <= N && p[2].getY() - l >= 1; l++) {
						p[3] = new Point(p[2].getX() + l, p[2].getY() - l);

						// 오른쪽으로 올라가기
						if (p[3].getX() - r >= 1 && p[3].getY() - r >= 1)
							p[4] = new Point(p[3].getX() - r, p[3].getY() - r);
						else
							continue;

						int[] population = new int[6];
						// 1번 구역
						int temp = p[1].getY();
						for (int k = 1; k < p[4].getX(); k++) {
							if (k >= p[1].getX())
								temp--;

							for (int t = 1; t <= temp; t++) {
								population[1] += map[k][t];
							}
						}

						// 2번 구역
						temp = N - p[1].getY();
						for (int k = 1; k <= p[2].getX(); k++) {
							if (k > p[1].getX())
								temp--;

							for (int t = N; t > N - temp; t--) {
								population[2] += map[k][t];
							}
						}

						// 3번 구역
						temp = p[3].getY() - 1;
						for (int k = N; k >= p[4].getX(); k--) {
							if (k < p[3].getX())
								temp--;

							for (int t = 1; t <= temp; t++) {
								population[3] += map[k][t];
							}
						}

						// 4번 구역
						temp = N - (p[3].getY() - 1);
						for (int k = N; k > p[2].getX(); k--) {
							if (k <= p[3].getX())
								temp--;

							for (int t = N; t > N - temp; t--) {
								population[4] += map[k][t];
							}
						}
						
						population[5] = sum
								- (population[1] + population[2] + population[3] + population[4]);

						int min = Integer.MAX_VALUE;
						int max = 0;
						for (int k = 1; k <= 5; k++) {
							min = Math.min(min, population[k]);
							max = Math.max(max, population[k]);
						}

						answer = Math.min(answer, max - min);
					}
				}
			}

		}

		System.out.println(answer);
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
