package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort_2750 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		quickSort(num, 1, N);

		for (int i = 1; i <= N; i++) {
			System.out.println(num[i]);
		}
	}

	private static void quickSort(int[] num, int L, int R) {
		int left = L;
		int right = R;
		int pivot = num[(L + R) / 2];

		while (left <= right) {
			// 가장 왼쪽에서 오른쪽으로 이동
			while (num[left] < pivot)
				left++;

			// 가장 오른쪽에서 왼쪽으로 이동
			while (num[right] > pivot)
				right--;

			if (left <= right) {
				int temp = num[left];
				num[left] = num[right];
				num[right] = temp;
				left++;
				right--;
			}
		}

		//왼쪽
		if (L < right)
			quickSort(num, L, right);
		
		//오론쪽
		if (R > left)
			quickSort(num, left, R);

	}

}
