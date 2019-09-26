package bfsdfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartAndLink_14889 {
	static boolean check[];
	static int map[][];
	static int N, min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		check = new boolean[N+1];
		map = new int[N+1][N+1];
		min = 987654321;
		
		for(int i = 1; i<= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 1);
		
		System.out.println(min);
	}
	
	static void dfs(int d, int pos)
	{
	    if (d == N / 2)
	    {
	        int start, link;
	        start = link = 0;
	        for (int i = 1; i <= N; i++)
	        {
	            for (int j = 1; j <= N; j++)
	            {
	                if (check[i] && check[j]) start += map[i][j];
	                if (!check[i] && !check[j]) link += map[i][j];
	            }
	        }
	        int tmp = Math.abs(start - link);
	        if (tmp < min) min = tmp;
	        return;
	    }
	    for (int i = pos; i < N; i++)
	    {
	        check[i] = true;
	        dfs(d + 1, i + 1);
	        check[i] = false;
	    }
	}
}
