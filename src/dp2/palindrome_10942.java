package dp2;
import java.io.*;
import java.util.StringTokenizer;

public class palindrome_10942 {
	private static int[] num;
	private static int d[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		d = new int[2001][2001];
		
		int N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			d[i][i] = 1;
		}
		
		//질문 받기
		int M = Integer.parseInt(br.readLine());		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(dp(a,b) == -1)
				sb.append(0);
			else
				sb.append(1);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int dp(int a, int b) {
		
		if(a >= b) {
			return 1;
		}
		
		if(d[a][b] != 0) {
			return d[a][b];
		}
		
		if(num[a] == num[b]) {
			d[a][b] = dp(a+1, b-1);
		} else {
			d[a][b] = -1;
		}
	
		return d[a][b];
	}

}
