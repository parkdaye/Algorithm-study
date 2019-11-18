package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simple369Game {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		

		for (int i = 1; i <= N; i++) {
			int n = i;
			int count = 0;

			while (n > 0) {
				int r = n % 10;

				if (r == 3 || r == 6 || r == 9) {
					count++;
				}

				n /= 10;
			}
			
			if(count > 0) {
				for(int j = 0; j < count; j++) {
					System.out.print("-");
				}
			} else {
				System.out.print(i);
			}
			
			System.out.print(" ");
		}

	}

}
