package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertingOperator_14888 {
	static int N;
	static int[] num;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		num = new int[N + 1];
		int[] operator = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());

		dfs(1, num[1], operator);

		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int count, int sum, int[] operator) {
		if (count > N - 1) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int[] copy = operator.clone();
			int temp = sum;

			if (copy[i] > 0) {
				copy[i]--;
				switch (i) {
				case 0:
					temp += num[count + 1];
					break;
				case 1:
					temp -= num[count + 1];
					break;
				case 2:
					temp *= num[count + 1];
					break;
				case 3:
					if (sum < 0)
						temp = -(Math.abs(temp) / num[count + 1]);
					else
						temp /= num[count + 1];
					break;
				}

				dfs(count + 1, temp, copy);
			}
		}
	}
}
