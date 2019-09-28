package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_1260 {
	static ArrayList<Integer>[] graph;
	static boolean[] checked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		graph = (ArrayList<Integer>[]) new ArrayList[N + 1];
		checked = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph[A].add(B);
			graph[B].add(A);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		
		dfs(V);

		System.out.println();
		Arrays.fill(checked, false);

		bfs(V);
	}

	public static void dfs(int v) {
		checked[v] = true;
		System.out.print(v + " ");

		for (int i = 0; i < graph[v].size(); i++) {
			int linked = graph[v].get(i);
			if (!checked[linked]) {
				checked[linked] = true;
				dfs(linked);
			}
		}
	}

	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		checked[v] = true;
		
		while(!queue.isEmpty()) {
			int front = queue.poll();
			System.out.print(front + " ");
			
			for(int i = 0; i < graph[front].size(); i++) {
				int linked = graph[front].get(i);
				
				if (!checked[linked]) {
					checked[linked] = true;
					queue.add(linked);
				}
			}
		}
	}
}
