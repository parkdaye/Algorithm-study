package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FineDust_17144 {
	static int R;
	static int C;
	static int T;
	static int[][] map;
	static int[] ax = { -1, 1, 0, 0 };
	static int[] ay = { 0, 0, -1, 1 };
	static List<Points> airCleaner;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R + 1][C + 1];
		int tempMap[][] = new int[R + 1][C + 1];
		airCleaner = new ArrayList<Points>();

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					airCleaner.add(new Points(i, j));
				}
			}
		}

		for (int t = 1; t <= T; t++) {

			// 계산에 쓸 맵 초기화
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					tempMap[i][j] = 0;
				}
			}

			// 미세먼지 퍼뜨리기
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j] > 0) {
						List<Integer> directions = new ArrayList<Integer>();

						for (int k = 0; k <= 3; k++) {
							int nx = i + ax[k];
							int ny = j + ay[k];

							if (nx > 0 && nx <= R && ny > 0 && ny <= C && map[nx][ny] != -1)
								directions.add(k);
						}
						spread(i, j, directions, tempMap);
					}
				}
			}

			// 공기청정기 작동
			operateAirCleaner(tempMap, airCleaner);

			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					map[i][j] = tempMap[i][j];
				}
			}
		}
		
		
		int count = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(map[i][j] > 0) {
					count += map[i][j];
				}
			}
		}

		System.out.println(count);
	}

	private static void operateAirCleaner(int[][] tempMap, List<Points> airCleaner2) {
		Points up = airCleaner.get(0);
		Points down = airCleaner.get(1);
		int ux = up.getX();
		int dx = down.getX();

		// 아래/위쪽으로
		for (int i = ux - 1; i > 0; i--) {
			if (i + 1 == ux)
				continue;

			tempMap[i + 1][1] = tempMap[i][1];
		}

		for (int i = dx + 1; i <= R; i++) {
			if (i - 1 == dx)
				continue;

			tempMap[i - 1][1] = tempMap[i][1];
		}

		// 왼쪽으로
		for (int i = 2; i <= C; i++) {
			tempMap[1][i - 1] = tempMap[1][i];
			tempMap[R][i - 1] = tempMap[R][i];
		}

		// 위로/아래쪽으로
		for (int i = 2; i <= ux; i++) {
			tempMap[i - 1][C] = tempMap[i][C];
		}

		for (int i = R - 1; i >= dx; i--) {
			tempMap[i + 1][C] = tempMap[i][C];
		}

		// 오른쪽으로
		for (int i = C - 1; i >= 1; i--) {
			tempMap[ux][i + 1] = tempMap[ux][i];
			tempMap[dx][i + 1] = tempMap[dx][i];
		}		
	}

	private static void spread(int x, int y, List<Integer> directions, int[][] tempMap) {
		int aroundSize = directions.size();
		int around = map[x][y] / 5;
		int center = map[x][y] - around * aroundSize;

		tempMap[x][y] += center;

		for (int i = 0; i < directions.size(); i++) {
			int k = directions.get(i);
			int nx = x + ax[k];
			int ny = y + ay[k];
			tempMap[nx][ny] += around;
		}
	}

}
