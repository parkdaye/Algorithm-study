package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewGame_17837 {

	static int N;
	static int K;
	static int map[][];
	static Loc[] horses;
	static int[] ax = { 0, 0, 0, -1, 1 };
	static int[] ay = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		horses = new Loc[K + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			horses[i] = new Loc(x, y, d);
		}

		int count = 1;
		boolean isEnd = false;
		while (count <= 1000) {
			// 턴 돌기 i는 현재 말 번호
			for (int i = 1; i <= K; i++) {
				int now = i;
				int d = horses[i].getDir();
				int nx = horses[i].getLow() + ax[d];
				int ny = horses[i].getCol() + ay[d];

				//다음 칸이 벽이거나 파란칸일 때 방향을 바꿔줌
				int c = 0;
				if (nx <= 0 || nx > N || ny <= 0 || ny > N || map[nx][ny] == 2) {
					switch (d) {
					case 1:
						horses[now].setDir(2);
						break;
					case 2:
						horses[now].setDir(1);
						break;
					case 3:
						horses[now].setDir(4);
						break;
					case 4:
						horses[now].setDir(3);
						break;
					}
					d = horses[i].getDir();
					nx = horses[i].getLow() + ax[d];
					ny = horses[i].getCol() + ay[d];
				} 
				
				
				// 다음 칸의 색깔 설정
				if ((nx <= 0 || nx > N || ny <= 0 || ny > N) || map[nx][ny] == 2) 
					continue;
				else
					c = map[nx][ny];

				// 다음 좌표에 존재하는 가장 위의 말 찾아주기
				int nextUp = 0;
				for (int j = 1; j <= K; j++) {
					if (nx == horses[j].getLow() && ny == horses[j].getCol() && horses[j].getUp() == 0) {
						nextUp = j;
					}
				}

				
				//옮길 말 밑에 깔려 있는 말과의 연결 해제
				for (int h = 1; h < horses.length; h++) {
					if(horses[h].getUp() == now) {
						horses[h].setUp(0);
					}
				}
				
				// 다음 칸 색깔에 따라 이동시킴
				switch (c) {
				// 흰색
				case 0:
					if (nextUp != 0)
						horses[nextUp].setUp(now);

					//아래쌓여 있는 말부터 위로 올라가며 말을 옮긴다
					while (now != 0) {
						horses[now].setLow(nx);
						horses[now].setCol(ny);
						now = horses[now].getUp();
					}
					break;

				// 빨간색
				case 1:
					int pre = 0;
					//이전 위치에서 위에 있는 말
					int preUp = horses[now].getUp();
					
					//말들 순서 뒤집기
					while (now != 0) {
						//밑에서부터 뒤집기 (preUp을 통해 이전 순서의 윗부분을 기억시킴)
						horses[now].setLow(nx);
						horses[now].setCol(ny);
						horses[now].setUp(pre);
						
						pre = now;
						now = preUp;
						if(now == 0)
							break;
						preUp = horses[now].getUp();
					}
					
					if (nextUp != 0)
						horses[nextUp].setUp(pre);
					break;


				}

				// 말이 네개 이상 쌓였는지 검사
				for (int j = 1; j < horses.length; j++) {
					int cnt = 0;
					int n = j;
					while(n != 0) {
						cnt++;
						n = horses[n].getUp();
					}
					
					if (cnt >= 4) {
						isEnd = true;
						break;
					}
				}
				

			}

			if (isEnd) {
				System.out.println(count);
				break;
			}
			count++;
		}

		if (!isEnd)
			System.out.println(-1);
	}

	static class Loc {
		int low;
		int col;
		int dir;
		int up;

		public Loc(int low, int col, int dir) {
			super();
			this.low = low;
			this.col = col;
			this.dir = dir;
		}

		public int getLow() {
			return low;
		}

		public void setLow(int low) {
			this.low = low;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

		public int getDir() {
			return dir;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		public int getUp() {
			return up;
		}

		public void setUp(int up) {
			this.up = up;
		}

	}
}
