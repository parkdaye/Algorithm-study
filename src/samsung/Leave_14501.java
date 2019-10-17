package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Leave_14501 {
	static int N;
	static int T[];
	static int P[];
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		max = 0;
		T = new int[N + 1];
		P = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		//시작점
		for (int i = 1; i <= N; i++) {
			dfs(i, 0);
		}
		
		System.out.println(max);
	}

	private static void dfs(int now, int sum) {
		
		int next = now + T[now];
		
		//오버해서 맨 마지막 합계를 넣을 수 없는 경우
		if(next > N + 1) {
			max = Math.max(max, sum);
			return;
		}
		
		if(next == N + 1) {
			max = Math.max(max, sum + P[now]);
			return;
		}
		
		for (int i = next; i <= N; i++) {
//			if (nnext > N + 1) {
//				max = Math.max(max, sum);
//				continue;
//			}
//			
//			if (nnext == N + 1) {
//				continue;
//			}
//			
			dfs(i, sum + P[now]);
		}
	}

}
