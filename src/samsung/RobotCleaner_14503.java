package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner_14503 {
	static int[] ax = { -1, 0, 1, 0 };
	static int[] ay = { 0, 1, 0, -1 };
	static int[] ccw = { 3, 0, 1, 2 };
	static int[] back = { 2, 3, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] check = new boolean[N][M];

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		Pair p = new Pair(x, y);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 1;
		check[x][y] = true;
		
		while (true) {
			x = p.getX();
			y = p.getY();

			boolean canMove = false;
			for (int k = 0; k < 4; k++) {
				d = ccw[d];
				int nx = x + ax[d];
				int ny = y + ay[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !check[nx][ny] && map[nx][ny] == 0) {
					if (!check[nx][ny]) {
						check[nx][ny] = true;
						p.setX(nx);
						p.setY(ny);
						
						canMove = true;
						answer++;
						break;
					}
				}
			}
			
			//네 방향 모두 청소못하는 경우
			if(!canMove) {
				int nx = x + ax[back[d]];
				int ny = y + ay[back[d]];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
					p.setX(nx);
					p.setY(ny);
				} else {
					break;
				} 
			}
		}

		System.out.println(answer);
	}

}
