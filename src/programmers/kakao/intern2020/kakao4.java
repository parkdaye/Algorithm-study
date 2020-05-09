package programmers.kakao.intern2020;

public class kakao4 {

	static int ax[] = { -1, 1, 0, 0 };
	static int ay[] = { 0, 0, -1, 1 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		//int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
		//int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		
		int[][] board ={{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		//int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		boolean[][] checked = new boolean[board.length][board.length];
		checked[0][0] = true;
		dfs(board, checked, 0, 0, 0, 0);
		return min;
	}

	public static void dfs(int[][] board, boolean[][] checked, int sum, int x, int y, int d) {
		if(x == board.length - 1 && y == board.length - 1) {
			min = Math.min(min, sum - 500);
			return;
		}
		
		for(int k = 0; k <= 3; k++) {
			int nx = x + ax[k];
			int ny = y + ay[k];
			
			if(nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) {
				continue;
			}
			
			if(checked[nx][ny] || board[nx][ny] == 1)
				continue;
			
			int tmp = 0;
			if(k == d)
				tmp += 100;
			else
				tmp += 600;
			
			checked[nx][ny] = true;
			dfs(board, checked, sum + tmp, nx, ny, k);
			checked[nx][ny] = false;
		}
	}
}
