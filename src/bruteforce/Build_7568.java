package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Build_7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int x[] = new int[N + 1];
		int y[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<= N; i++) {
			int rank = 1;
			
			for(int j = 1; j <= N; j++) {
				if(x[j] > x[i] && y[j] > y[i])
					rank++;
			}
			
			System.out.print(rank + " ");
			
		}
	}

}
