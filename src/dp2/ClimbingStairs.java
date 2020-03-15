package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int value[] = new int[n + 1];
		int stairs[][] = new int[n + 1][2];
		
		for(int i = 1; i <= n; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		
		stairs[1][0] = value[1]; 
		stairs[1][1] = value[1];
		
		if(n == 1) {
			System.out.println(stairs[1][0]);
			return;
		}
			
		stairs[2][0] = value[2];
		stairs[2][1] = stairs[1][0] + value[2];
		
		for(int i = 3; i <= n; i++) {
			stairs[i][0] = Math.max(stairs[i-2][0], stairs[i-2][1]) + value[i];
            stairs[i][1] = stairs[i-1][0] + value[i];
		}
	
		
		System.out.println(Math.max(stairs[n][0], stairs[n][1]));
	}

}
