package kickstart2020.roundb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BusRoutes_Test1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long D = Long.parseLong(st.nextToken());
			
			int[] X = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<= N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			
			long now = Long.MAX_VALUE;
			for(int i = N; i > 0; i--) {
				for(long j = D; j > 0; j--) {
					if((long)j % X[i] == 0 && j <= now) {
						now = j;
						break;
					}
				}
			}
			
			System.out.println("Case #" + t + ": " + (now));
		}
	}
}
