package findrule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class findNum_1920 {
	static int A[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			int start = 1;
			int end = N;
			
			boolean isExisted = false;
			
			while(start <= end) {
				int mid = (start + end)/2;
				
				if(target == A[mid]) {
					isExisted = true;
					break;
				} 
				else if(target > A[mid]) 
					start = mid + 1;
				else
					end = mid - 1;
			}
			
			if(isExisted)
				System.out.println(1);
			else
				System.out.println(0);
		}

	}

}
