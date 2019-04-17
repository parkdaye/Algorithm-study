package dp2;

import java.io.*;
import java.util.*;

public class mergeFile_11066 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		
		for(int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			int c[] = new int[K+1];
			int sum[] = new int[K+1];
			int d[][] = new int[K+1][K+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());	
			
			sum[0] = 0;
			for(int j = 1; j <= K; j++) {
				c[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1] + c[j];
			}
			

			for(int j = 1; j <= K; j++) {
				for(int m = 1; m <= K; m++) {
					d[j][m] = 999999999;
					
					if(j == m) // ex) d[1][1]은  0으로 초기화
						d[j][m] = 0;
				}
			}
		
			for(int to = 1; to <= K; to++) { //범위
				for(int from = to-1; from >= 1; from--) { //시작점
					for(int v = from; v < to; v++) { //나뉘는 지점
						if(d[from][to] > d[from][v] + d[v+1][to] + sum[to] - sum[from-1]) {
							d[from][to] = d[from][v] + d[v+1][to] + sum[to] - sum[from-1];
						}
					}
				}
			}
			
			System.out.println(d[1][K]);
		}
	}

}
