package kickstart2020.roundb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BikeTour {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] m = new int[N+1];
			
			for(int i = 1; i <= N; i++)
				m[i] = Integer.parseInt(st.nextToken());
			
			int peek = 0;
			for(int i = 2; i < N; i++) {
				if(m[i] > m[i-1] && m[i] > m[i+1])
					peek++;
			}
			
			System.out.println("Case #" + t + ": " + (peek));
		}
	}

}
