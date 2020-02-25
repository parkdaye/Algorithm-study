package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Slope_14890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		boolean[][] isChecked = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 가로줄 비교
		int low = 0;
		for (int i = 1; i <= N; i++) {
			int diff = 0;
			boolean isRoute = true;

			for (int j = 2; j <= N; j++) {
				diff = map[i][j] - map[i][j - 1];

				// 오르막
				if (diff == 1) {
					if (j - L < 1) {
						isRoute = false;
						break;
					}
					// 뒤로 가서 체크
					for (int k = j - 1; k >= (j - L); k--) {
						// 이미 체크되어 있다면 경사로가 놓여져있음
						if (isChecked[i][k]) {
							isRoute = false;
							break;
						}

						isChecked[i][k] = true;
					}

				} else if (diff == -1) { // 내리막
					int k = j;
					int c = map[i][k];
					int tmp = 0;

					// 앞으로 가서 경사로 놓을 수 있는지 확인
					while (k <= N && map[i][k] == c) {
						tmp++;
						k++;
					}

					if (tmp < L) {
						isRoute = false;
						break;
					} else {
						// 앞으로 가서 체크
						for (int t = j; t < j + L; t++)
							isChecked[i][t] = true;
					}

				} else if (diff != 0) {
					isRoute = false;
					break;
				}
			}

			if (isRoute)
				low++;
		}

		
		// check배열 초기화
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				isChecked[i][j] = false;
			}
		}

		
		// 세로줄 비교
		int col = 0;
		for (int i = 1; i <= N; i++) {
			int diff = 0;
			int cnt = 1;
			boolean isRoute = true;

			for (int j = 2; j <= N; j++) {
				diff = map[j][i] - map[j - 1][i];

				// 오르막
				if (diff == 1) {
					// 뒤로 가서 체크
					if (j - L < 1) {
						isRoute = false;
						break;
					}
					for (int k = j - 1; k >= (j - L); k--) {
						if (isChecked[k][i]) {
							isRoute = false;
							break;
						}

						isChecked[k][i] = true;
					}

				} else if (diff == -1) { // 내리막
					int k = j;
					int c = map[k][i];
					int tmp = 0;

					// 앞으로 가서 경사로 놓을 수 있는지 확인
					while (k <= N && map[k][i] == c) {
						tmp++;
						k++;
					}

					if (tmp < L) {
						isRoute = false;
						break;
					} else {
						// 앞으로 가서 체크
						for (int t = j; t < j + L; t++)
							isChecked[t][i] = true;
					}

				} else if (diff != 0) {
					isRoute = false;
					break;
				}
			}

			if (isRoute)
				col++;
		}

		System.out.println(low + col);
	}

}
