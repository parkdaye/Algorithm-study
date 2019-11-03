package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort_2750 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N - 1; i++) {
			int min = num[i];
			int minIndex = i;
			for(int j = i + 1; j <= N; j++) {
				if(min > num[j]) {
					min = num[j];
					minIndex = j;
				}
			}
			//swap(num[i], num[minIndex]);
			int temp = num[i];
			num[i] = num[minIndex];
			num[minIndex] = temp; 
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(num[i]);
		}
	}

}
