package programmers.skillcheck.level2;

public class Solution5 {
	static int[] ax = { 0, 0, 1, 1 };
	static int[] ay = { 0, 1, 0, 1 };

	public static void main(String[] args) {
		String[] board = {"DD", "CC", "AA", "AA", "CC", "DD"};

		System.out.println(solution(6, 2, board));
	}

	public static int solution(int m, int n, String[] board) {
		int answer = 0;

		char[][] b = new char[m][n];
		for (int i = 0; i < m; i++) {
			String s = board[i];
			for (int j = 0; j < n; j++) {
				b[i][j] = s.charAt(j);
			}
		}
		
		while (true) {
			boolean[][] checked = new boolean[m][n];
			boolean isContinue = pop(b, checked, m, n);
			
			if(!isContinue)
				break;
			
			answer = count(b, checked, m, n, answer);
			downBlock(b, n, m);
		}
		
		return answer;
	}

	private static int count(char[][] b, boolean[][] checked, int m, int n, int answer) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(checked[i][j]) {
					b[i][j] = 0;
					answer++;
				}
			}
		}
		
		return answer;
	}

	private static void downBlock(char[][] b, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = m - 2; j >= 0; j--) {
				int tmp = j;
				while(tmp != m-1 && b[tmp + 1][i] == 0) {
					b[tmp + 1][i] = b[tmp][i];
					b[tmp][i] = 0;
					tmp++;
				}
			}
		}
	}

	private static boolean pop(char[][] b, boolean[][] checked, int m, int n) {

		boolean isContinue = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char c = b[i][j];

				int cnt = 0;
				for (int k = 0; k <= 3; k++) {
					int nx = i + ax[k];
					int ny = j + ay[k];

					if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
						if (c == b[nx][ny] && c != 0)
							cnt++;
					}
				}

				if (cnt == 4) {
					for (int k = 0; k <= 3; k++) {
						int nx = i + ax[k];
						int ny = j + ay[k];

						if (!checked[nx][ny]) {
							checked[nx][ny] = true;
							isContinue = true;
						}
					}
				}

			}
		}
		
		return isContinue;
	}
}
