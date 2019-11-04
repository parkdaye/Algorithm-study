package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinHeap_1927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		MinHeap heap = new MinHeap();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0)
				System.out.println(heap.delete());
			else
				heap.insert(x);
		}
	}

	public static class MinHeap {
		private ArrayList<Integer> heap;

		public MinHeap() {
			heap = new ArrayList<>();
			heap.add(0);
		}

		// 삽입
		public void insert(int v) {
			heap.add(v);

			// 가장 마지막 요소
			int p = heap.size() - 1;

			// 부모노드가 자식 노드보다 작을 때까지(최소 힙 조건을 만족할 때까지)
			while (p > 1 && heap.get(p / 2) > heap.get(p)) {
				// swap(parent, child);
				int tmp = heap.get(p / 2);
				heap.set(p / 2, heap.get(p));
				heap.set(p, tmp);

				// 부모 노드로 올라감
				p /= 2;
			}
		}

		// 삭제
		public int delete() {
			int last = heap.size() - 1;

			if (last < 1)
				return 0;

			// 루트 노드를 삭제
			int root = heap.get(1);

			// 가장 마지막 요소를 루트로 올리고 삭제
			heap.set(1, heap.get(last));
			heap.remove(last);

			int pos = 1;
			while (pos * 2 < heap.size()) {
				int min = heap.get(pos * 2);
				int minPos = pos * 2;

				// 형제 노드와 비교해서 더 작은 값을 찾음
				if ((pos * 2 + 1) < heap.size() && min > heap.get(pos * 2 + 1)) {
					min = heap.get(pos * 2 + 1);
					minPos = pos * 2 + 1;
				}

				// 최소힙 조건을 만족하면 멈춘다
				if (heap.get(pos) < min)
					break;

				// swap(parent, child);
				int tmp = heap.get(pos);
				heap.set(pos, heap.get(minPos));
				heap.set(minPos, tmp);

				// 자식 노드로 이동
				pos = minPos;
			}

			return root;
		}
	}
}
