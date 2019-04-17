package dp2;
import java.io.*;
import java.util.*;

public class palindrome {
	private static int d[][];
	private static int num[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		d = new int[2001][2001];
		
		int N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 1; i <= N; i++) {
			d[i][i] = 1;
		}
		
		for(int i = 1; i <= N-1; i++) {
			if(num[i] == num[i+1])
				d[i][i+1] = 1;
		}
		
		for(int i = 3; i <= N; i++) {
			for(int j = 1; j <= N-i+1; j++) {
				if(num[j] == num[j+i-1]) {
					if(d[j+1][j+i-2] == 1) {
						d[j][i+j-1] = 1;
					}
				}
				
			}
		}
		

		
		//질문 받기
		int M = Integer.parseInt(br.readLine());		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(d[a][b]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
