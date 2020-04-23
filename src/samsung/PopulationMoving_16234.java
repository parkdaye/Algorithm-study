package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PopulationMoving_16234 {
	static int N;
	static int L;
	static int R;
	static int map[][];
	static int ax[] = { -1, 1, 0, 0 };
	static int ay[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		while (true) {
			boolean[][] checked = new boolean[N + 1][N + 1];
			
			int count = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					List<Pair> list = new ArrayList<>();
					if (!checked[i][j]) {
						dfs(checked, list, i, j);
						count++;
					}
					
					int sum = 0;
					for(int l = 0; l < list.size(); l++) {
						Pair p = list.get(l);
						sum += map[p.getX()][p.getY()];
					}
					
					for(int l = 0; l < list.size(); l++) {
						Pair p = list.get(l);
						map[p.getX()][p.getY()] = sum / list.size();
					}
				}
			}
			
			if(count == N * N)
				break;
			
			answer++;
		}

		System.out.println(answer);
	}

	private static void dfs(boolean[][] checked, List<Pair> list, int i, int j) {
		checked[i][j] = true;
		list.add(new Pair(i , j));

		for (int k = 0; k < 4; k++) {
			int nx = i + ax[k];
			int ny = j + ay[k];

			if (nx <= N && nx > 0 && ny <= N && ny > 0 && !checked[nx][ny]) {
				int diff = Math.abs(map[nx][ny] - map[i][j]);

				if (diff >= L && diff <= R) {
					dfs(checked, list, nx, ny);
				}
			}
		}
	}

}
