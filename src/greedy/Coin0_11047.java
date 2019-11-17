package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin0_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int A[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		int count = 0;
		int sum = 0;

		while (sum < K) {
			int remains = K - sum;
			for (int i = N; i > 0; i--) {
				if(A[i] <= remains) {
					sum += A[i];
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}
}
