package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coin2_2294 {
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
		
		//max로 초기화
		for(int i = 0; i <= k; i++) {
			d[i] = 100001;
		}
		
		d[0] = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= k; j++) {
				if(j-coin[i] >= 0) {
					if(d[j-coin[i]] + 1 < d[j]) {
						d[j] = d[j-coin[i]] + 1;
					}
				}
			}
		}
		
		if(d[k] == 100001)
			System.out.println(-1);
		else
			System.out.println(d[k]);
		
	}

}
