package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hansu_1065 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N <= 99) {
			System.out.println(N);
			System.exit(0);
		}
		
		int count = 99;
		
		for(int i = 100; i <= N; i++) {
			int temp = i;
			boolean isHansu = true;
			
			int s = (int) Math.log10(i) + 1;
			
			int backN = temp % 10;
			temp /= 10;
			int frontN = temp % 10;
			int diff = backN - frontN;
			
			for(int j = 0; j < s-2; j++) { //compare
				backN = frontN;
				temp /= 10;
				frontN = temp % 10;
				
				if(diff != backN - frontN) {
					isHansu = false;
					break;
				}
			}
			
			if(isHansu) {
				System.out.println(s);
				System.out.println(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
