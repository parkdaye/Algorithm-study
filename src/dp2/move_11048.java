package dp2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class move_11048 {
	private static int[][] map;
	private static int[][] d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		d = new int[N+1][M+1];
	
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				d[i][j] = -1;
			}
		}
		
		System.out.println(move(N, M));
	}
	
	public static int move(int i, int j) {
		if(i == 1 && j == 1)
			return map[1][1];
		
		if(i < 1 || j < 1)
			return 0;
		
		//memoization : 이미 값이 있으면 가져옴
		if(d[i][j] >= 0)
			return d[i][j];
		
		int temp1 = move(i-1, j) + map[i][j];
		int temp2 = move(i, j-1) + map[i][j];
		
		if(temp1 > temp2)
			d[i][j] = temp1;
		else
			d[i][j] = temp2;
		
		return d[i][j];
	}

}
