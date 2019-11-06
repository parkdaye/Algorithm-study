package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSort_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		heapSort(num);

		for (int i = 1; i <= N; i++) {
			System.out.println(num[i]);
		}
	}

	private static void heapSort(int[] num) {
		int size = num.length;

		// 힙 상태로 만듬
		for (int i = size / 2; i > 0; i--) {
			heapify(num, size, i);
		}

		//루트값(현재 가장 최대값)을 배열의 가장 뒤로 빼고 힙 상태로 만듬
		for (int i = size - 1; i > 1; i--) {
			int temp = num[1];
			num[1] = num[i];
			num[i] = temp;
			
			//size만큼만 힙상태로 만들도록 함
			heapify(num, i, 1);
		}
	}

	private static void heapify(int[] num, int size, int i) {
		int p = i;
		int l = i * 2;
		int r = i * 2 + 1;

		// 최대힙 조건에 맞지 않을 겨우 자식노드로 이동
		if (l < size && num[p] < num[l])
			p = l;

		if (r < size && num[p] < num[r])
			p = r;

		if (i != p) {
			int temp = num[i];
			num[i] = num[p];
			num[p] = temp;

			heapify(num, size, p);
		}
	}
}
