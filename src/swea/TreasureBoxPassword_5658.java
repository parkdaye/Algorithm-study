package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class TreasureBoxPassword_5658 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < T; t++) {
			List<Long> passwordSet = new ArrayList<Long>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String password = br.readLine();
			int tokenLength = N / 4;
			
			for(int i = 0; i < tokenLength; i++) {
				for(int j = 0; j < N; j += tokenLength) { //4가지 면으로 자름
					String token = password.substring(j, j + tokenLength);
					
					long sum = 0;
					for(int k = 0; k < tokenLength; k++) { //16진수 계산
						String now = token.charAt(k) + "";
						int n = Integer.valueOf(now, 16); //16진수에서 10진수로 변환
						int dec = (int) (n * Math.pow(16, tokenLength - k - 1));
						sum += dec;
						
					}
					
					if(!passwordSet.contains(sum))
						passwordSet.add(sum);					
					
				}
				
				char end = password.charAt(N-1);
				password = end + password.substring(0, N-1);
			}
			
			Collections.sort(passwordSet, Comparator.reverseOrder());
			System.out.println("#" + (t + 1) + " " + passwordSet.get(K - 1));
		}
	}

}
