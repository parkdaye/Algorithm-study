package kickstart2019.rounda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Training_Test2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			Integer[] s = new Integer[N];
			int[] sum = new int[N - P + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(s, Collections.reverseOrder());

			for (int i = 1; i < P; i++) {
				sum[0] += s[i];
			}

			for (int i = 1; i <= N - P; i++) {
				sum[i] = sum[i - 1] - s[i] + s[i + P - 1];
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i <= N - P; i++) {
				int r = (P - 1) * s[i];
				min = Math.min(min, r - sum[i]);
			}

			System.out.println("Case #" + t + ": " + min);
		}
	}

}
