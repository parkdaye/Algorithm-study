package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort_2750 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			int temp = num[i];
			int j = i - 1;
			
			for (; j > 0; j--) {
				if (num[j] < temp)
					break;
				num[j + 1] = num[j];
			}
			num[j + 1] = temp;
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(num[i]);
		}
	}

}
