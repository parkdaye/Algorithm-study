package kickstart2019.rounda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Training_Test1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			Integer[] s = new Integer[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(s, Collections.reverseOrder());

			int min = Integer.MAX_VALUE;
			for(int i = 0; i <= N - P; i++) {
				int sum = 0;
				
				for(int j = i + 1; j < i + P; j++) {
					sum += (s[i] - s[j]);
				}
				
				min = Math.min(min, sum);
			}
			
			System.out.println("Case #" + t + ": " + min);
		}
	}

}
