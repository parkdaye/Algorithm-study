package dp2;
import java.io.*;
import java.util.*;

public class coin1_2293 {
	private static int coin[];
	private static int d[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		coin = new int[n];
		d = new int[k+1]; 
		
		for(int i = 0; i < coin.length; i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		d[0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= k; j++)
				if(j - coin[i] >= 0) {
					d[j] += d[j - coin[i]];
				}
		}
		
		System.out.println(d[k]);
	}
	



}
