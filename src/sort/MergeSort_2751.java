package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MergeSort_2751 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(num, 1, N);
		
		for(int i = 1; i <= N; i++) {
			System.out.println(num[i]);
		}
	}

	private static void mergeSort(int[] num, int L, int R) {
		if(L >= R) return;
		int M = (L + R) / 2;
		
		//분할
		mergeSort(num, L, M);
		mergeSort(num, M + 1, R);
		
		//정복
		int i = L;
		int j = M + 1;
		int k = L;
		
		int temp[] = new int[num.length];
		while(i <= M && j <= R) {
			if(num[i] < num[j])
				temp[k++] = num[i++];
			else
				temp[k++] = num[j++];
		}
		
		while(i <= M)
			temp[k++] = num[i++];
		while(j <= R)
			temp[k++] = num[j++];
		
		for(int t = L; t <= R; t++)
			num[t] = temp[t];
		
	}

}
