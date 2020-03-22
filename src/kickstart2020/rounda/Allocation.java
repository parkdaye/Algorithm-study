package kickstart2020.rounda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Allocation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int[] A = new int[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A);

			int sum = 0;
			int i = 1;
			while(sum + A[i] <= B) {
				sum += A[i];
				i++;
				
				if(i > N)
					break;
			}
			
			System.out.println("Case #" + t + ": " + (i-1));
		}
	}

}
