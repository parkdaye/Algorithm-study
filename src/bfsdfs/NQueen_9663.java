package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_9663 {
	static int sum;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sum = 0;

		for (int i = 1; i <= N; i++) {
			int[] q = new int[N + 1];
			q[1] = i;
			dfs(q, 2);
		}


		System.out.println(sum);
	}
 
	private static void dfs(int[] q, int row) {
		if (row > N) {
			sum++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			q[row] = i;
			if (isValid(q, row))
				dfs(q, row + 1);
			
		}
	}

	private static boolean isValid(int[] q, int row) {
		for (int i = 1; i < row; i++) {
			if (q[row] == q[i])
				return false;
			if (q[row] - q[i] == row - i)
				return false;
			if (q[i] - q[row] == row - i)
				return false;
		}

		return true;
	}

}
