package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimumSpanningTree2_1197 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] w = new int[V + 1][V + 1];
		int[] d = new int[V + 1];
		boolean[] visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			d[i] = Integer.MAX_VALUE;
			visited[i] = false;
			for (int j = 1; j <= V; j++) {
				w[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			w[A][B] = C;
			w[B][A] = C;
		}

		int sum = 0;
		int a = 0;
		d[1] = 0;

		while (a < V) {
			int min = Integer.MAX_VALUE;
			int u = -1;

			// 가장 작은 가중치값인 정점 u를 연결
			for (int i = 1; i <= V; i++) {
				if (!visited[i] && d[i] < min) {
					min = d[i];
					u = i;
				}
			}

			// 연결된 정점을 집합에 포함하여 d를 집합과의 최소값을 유지하도록 갱신
			
			for (int i = 1; i <= V; i++) {
				if (!visited[i] && w[u][i] != Integer.MAX_VALUE) {
					if (w[u][i] < d[i])
						d[i] = w[u][i];
				}
			}

			a++;
			sum += min;
			visited[u] = true;
		}

		System.out.println(sum);

	}

}
