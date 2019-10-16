package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino_14500 {
	static int N;
	static int M;
	static int max;
	static int[][] paper;
	static boolean[][] checked;
	static int[] ax = { -1, 1, 0, 0 };
	static int[] ay = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
		paper = new int[N + 1][M + 1];
		checked = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				count(i, j, 0, paper[i][j]);
				checked[i][j] = false;
				
				countSpecial(i, j, paper[i][j]);
			}
		}
		
		System.out.println(max);
	}

	private static void count(int x, int y, int count, int sum) {
		if (count == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int k = 0; k <= 3; k++) {
			int nx = x + ax[k];
			int ny = y + ay[k];

			if (nx > 0 && nx <= N && ny > 0 && ny <= M && !checked[nx][ny]) {
				checked[x][y] = true;
				count(nx, ny, count + 1, sum + paper[nx][ny]);
				checked[nx][ny] = false;
			} else {
				continue;
			}
		}
	}

	private static void countSpecial(int x, int y, int sum) {
		int ux = x - 1;
		int dx = x + 1;
		int ly = y - 1;
		int ry = y + 1;
		
		if(ux > 0 && ux <= N && dx > 0 && dx <= N) {
			int vertical = sum + paper[ux][y] + paper[dx][y];
			if(ly > 0 && ly <= M) 
				max = Math.max(max, vertical + paper[x][ly]);
			if(ry > 0 && ry <= M) 
				max = Math.max(max, vertical + paper[x][ry]);
		}
		
		if(ly > 0 && ly <= M && ry > 0 && ry <= M) {
			int horizontal = sum + paper[x][ly] + paper[x][ry];
			if(ux > 0 && ux <= N) 
				max = Math.max(max, horizontal + paper[ux][y]);
			if(dx > 0 && dx <= N) 
				max = Math.max(max, horizontal + paper[dx][y]);
		}
		
	}

}
