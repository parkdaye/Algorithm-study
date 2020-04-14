package kickstart2020.rounda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Workout {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] M = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				M[i] = Integer.parseInt(st.nextToken());
			}

			int[] diff = new int[N];
			int max = 0;
			for (int i = 1; i <= N - 1; i++) {
				diff[i] = M[i + 1] - M[i];
				max = Math.max(max, diff[i]);
			}

			int answer = 0;
			int mid = 0;
			int left = 1;
			int right = max;
			
			while(right >= left) {
				mid = (right + left) / 2;
				
				int[] added = new int[N];
				int sum = 0;
				
				for (int i = 1; i <= N - 1; i++) {
					added[i] = (int) Math.ceil((double)diff[i] / mid) - 1;
					sum += added[i];
				}
				
				if(sum <= K) {
					answer = mid;
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			System.out.println("Case #" + t + ": " + answer);
		}
	}

}
