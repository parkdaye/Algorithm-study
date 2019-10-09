package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Easy2048_12100 {
	static int[] ax = { -1, 1, 0, 0 };
	static int[] ay = { 0, 0, -1, 1 };
	static int N;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		play(map, 0);

		System.out.println(max);
	}

	private static void play(int[][] map, int count) {

		// 5번 돌았으면
		if (count == 5) {
			// 현재 맵에서 최대값 뽑아내기
			int temp = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (temp < map[i][j])
						temp = map[i][j];
				}
			}

			max = Math.max(temp, max);
			return;
		}

		for (int k = 0; k < 4; k++) { // 4방향 모두 돌면서

			// map deepCopy
			int[][] copyMap = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					copyMap[i][j] = map[i][j];

			//이미 합쳐진 블록인지 확인할 배열
			boolean[][] isMerged = new boolean[N+1][N+1];

			switch (k) {
			case 0:
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (copyMap[j][i] != 0) {
							swipe(copyMap, isMerged, j, i, k);
						}
					}
				}
				break;
			case 1:
				for (int i = 1; i <= N; i++) {
					for (int j = N; j > 0; j--) {
						if (copyMap[j][i] != 0) {
							swipe(copyMap, isMerged, j, i, k);
						}
					}
				}
				break;
			case 2:
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (copyMap[i][j] != 0) {
							swipe(copyMap, isMerged, i, j, k);
						}
					}
				}
				break;
			case 3:
				for (int i = 1; i <= N; i++) {
					for (int j = N; j > 0; j--) {
						if (copyMap[i][j] != 0) {
							swipe(copyMap, isMerged, i, j, k);
						}
					}
				}
				break;
			}

			play(copyMap, count + 1);
		}
	}

	private static void swipe(int[][] map, boolean[][] isMerged, int i, int j, int dir) {
		if (map[i][j] != 0) {
			int value = map[i][j];
			int nx = i + ax[dir];
			int ny = j + ay[dir];

			while (nx > 0 && nx <= N && ny > 0 && ny <= N) {

				if (map[nx][ny] != 0) {
					int currentX = nx - ax[dir];
					int currentY = ny - ay[dir];

					// 같을 경우 합침
					if (map[nx][ny] == value && !isMerged[nx][ny]) {
						map[currentX][currentY] = 0;
						isMerged[nx][ny] = true;
						map[nx][ny] = value * 2;
					} else { // 다를 경우 뒤로
						map[currentX][currentY] = value;
					}

					break;
				}
				
				map[nx - ax[dir]][ny - ay[dir]] = 0;
				map[nx][ny] = value;
				nx += ax[dir];
				ny += ay[dir];

			}
		}

	}

}
