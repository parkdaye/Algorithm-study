package dp2;
import java.io.*;
import java.util.*;

public class jump_1890 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		long[][] d = new long[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				d[i][j] = 0;
			}
		}
		
		d[1][1] = 1;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] == 0)
					continue;
				
				if(i + map[i][j] <= N)
					d[i+map[i][j]][j] += d[i][j];
				if(j + map[i][j] <= N)
					d[i][j+map[i][j]] += d[i][j];
			}
		}
		
		System.out.println(d[N][N]);
	}

}
