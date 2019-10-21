package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FishingKing_17143 {
	static int R;
	static int C;
	static int M;
	static Shark[][] sharkMap;
	static boolean[][] isSharkExist;
	static int[] ax = { 0, -1, 1, 0, 0 };
	static int[] ay = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sharkMap = new Shark[R + 1][C + 1];
		isSharkExist = new boolean[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharkMap[r][c] = new Shark(s, d, z);
			isSharkExist[r][c] = true;
		}

		int catchCount = 0;

		// f가 C까지 이동할 동안
		for (int f = 1; f <= C; f++) {
			// 가장 가까운 곳에서 상어를 발견하면 잡음
			for (int i = 1; i <= R; i++) {
				if (isSharkExist[i][f]) {
					catchCount += sharkMap[i][f].getZ();
					sharkMap[i][f] = null;
					isSharkExist[i][f] = false;
					break;
				}
			}

			// 상어의 이동 + 같은 자리에 상어가 오게 되면 잡아먹음
			boolean[][] copy = new boolean[R + 1][C + 1];
			Shark[][] copyMap = new Shark[R + 1][C + 1];

			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (isSharkExist[i][j]) {
						Shark shark = sharkMap[i][j];
						int s = shark.getS();
						int d = shark.getD();
						int x = i;
						int y = j;
						for (int t = 0; t < s; t++) {
							int nx = x + ax[d];
							int ny = y + ay[d];

							// 경계에 있으면 방향을 바꿈
							if (nx < 1 || nx > R || ny < 1 || ny > C) {
								if (d % 2 == 0)
									d--;
								else
									d++;
							}

							x += ax[d];
							y += ay[d];
						}

						shark.setD(d);

						// 이미 이곳에 와있는 상어가 없다면
						if (!copy[x][y]) {
							copyMap[x][y] = shark;
							copy[x][y] = true;
						} else {
							int preShark = copyMap[x][y].getZ();
							int nowShark = shark.getZ();
							if (preShark < nowShark) {
								copyMap[x][y] = shark;
							}
						}

					}
				}
			}
			isSharkExist = copy;
			sharkMap = copyMap;
		}

		System.out.println(catchCount);
	}

}

class Shark {
	int s;
	int d;
	int z;

	public Shark(int s, int d, int z) {
		super();
		this.s = s;
		this.d = d;
		this.z = z;
	}

	public int getS() {
		return s;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getD() {
		return d;
	}

	public int getZ() {
		return z;
	}
}