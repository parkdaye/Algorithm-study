package programmers.kakao.blind2020;

public class LockAndKey {

	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		System.out.println(solution(key, lock));
	}

	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;

		int M = key.length;
		int N = lock.length;

		for (int k = 0; k < 3; k++) {
			for (int i = 0; i <= 3 * N - M; i++) {
				for (int j = 0; j <= 3 * N - M; j++) {

					int back[][] = new int[3 * N][3 * N];
					for (int x = N; x < 2 * N; x++) {
						for (int y = N; y < 2 * N; y++) {
							back[x][y] = lock[x - N][y - N];
						}
					}

					for (int x = i; x < i + M; x++) {
						for (int y = j; y < j + M; y++) {
							back[x][y] += key[x - i][y - j];
						}
					}

					if (checkKey(back, N))
						return true;
				}
			}

			int[][] copy = new int[M][M];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					copy[j][i] = key[M - i - 1][j];
				}
			}
			
			key = copy.clone();
		}
		return answer;
	}

	private static boolean checkKey(int[][] back, int N) {
		for (int x = N; x < 2 * N; x++) {
			for (int y = N; y < 2 * N; y++) {
				if (back[x][y] != 1) {
					return false;
				}
			}
		}

		return true;
	}
}
