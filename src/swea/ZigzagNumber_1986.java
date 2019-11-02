package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZigzagNumber_1986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int sum = 0;
			for(int i = 1; i <= N; i++) {
				if(i % 2 == 0) {
					sum += -i;
				} else {
					sum += i;
				}
			}
			System.out.println("#" + (t+1) + " " + sum);
 		}
		
	}
}
