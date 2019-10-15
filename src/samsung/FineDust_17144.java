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
	static int[] cw = { 3, 1, 2, 0 };
	static int[] ccw = { 3, 0, 2, 1 };
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

			// map 바꾸기
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					map[i][j] = tempMap[i][j];
				}
			}

			// 공기청정기 작동
			operateAirCleaner(tempMap, airCleaner);

		}

		int count = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] > 0) {
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
		int uy = up.getY();
		int dx = down.getX();
		int dy = down.getY();
		map[ux][uy] = -1;
		map[dx][dy] = -1;

		// 위의 공기청정기가 작동하도록
		int k = 0;
		ux += ax[ccw[k]];
		uy += ay[ccw[k]];
		map[ux][uy] = 0;

		while (true) { // 원래 위치로 돌아갈때까지
			int unx = ux + ax[ccw[k]];
			int uny = uy + ay[ccw[k]];
			

			if (unx > 0 && unx <= R && uny > 0 && uny <= C) {
				if(map[unx][uny] == -1)
					break;
				
				map[unx][uny] = tempMap[ux][uy];
				ux = unx;
				uy = uny;
			} else {
				k++;
				continue;
			}

		}

		// 아래의 공기청정기가 작동하도록
		k = 0;
		dx += ax[cw[k]];
		dy += ay[cw[k]];
		map[dx][dy] = 0;
		
		while (true) { // 원래 위치로 돌아갈때까지
			int dnx = dx + ax[cw[k]];
			int dny = dy + ay[cw[k]];
			

			if (dnx > 0 && dnx <= R && dny > 0 && dny <= C) {
				if(map[dnx][dny] == -1)
					break;
				
				map[dnx][dny] = tempMap[dx][dy];
				dx = dnx;
				dy = dny;
			} else {
				k++;
				continue;
			}

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
