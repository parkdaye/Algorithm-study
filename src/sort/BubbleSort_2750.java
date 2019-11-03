package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort_2750 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i < N; i++) {
			for(int j = 1; j <= N - i; j++) {
				if(num[j] > num[j+1]) {
					//swap(num[j], num[j+1])
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
					
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(num[i]);
		}
	}
}
