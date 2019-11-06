package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SetRepresentation_1717 {
	static int parent[];
	static int depth[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		depth = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			depth[i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int o = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (o == 0) {
				union(a, b);
			} else {
				int rootA = find(a);
				int rootB = find(b);

				if (rootA == rootB)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		// 이미 합쳐져 있을 경우
		if (a == b)
			return;

		// 트리의 높이가 더 낮은 트리를 높은 트리 밑에 놓음 (높은 트리가 루트)
		if (depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		parent[a] = b;

		if (depth[a] == depth[b])
			++depth[b];
	}
}
