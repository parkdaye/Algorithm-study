package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ShortestPath_1753 {
	static ArrayList<Edge>[] graph;
	static int min = 987654321;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		graph = (ArrayList<Edge>[]) new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			Edge edge = new Edge(v, w);
			graph[u].add(edge);
		}
		
		for (int i = 1; i <= V; i++) {

			if (i == K) {
				System.out.println(0);
				continue;
			}

			dfs(K, i);

			if (min == 987654321) {
				System.out.println("INF");
				continue;
			}
			System.out.println(min);

			min = 987654321;
		}
	}
	

	public static void dfs(int s, int e) {

		if (s == e) {
			if (min > sum) min = sum;
			return;
		}

		for (int i = 0; i < graph[s].size(); i++) {
			Edge edge = graph[s].get(i);
			int v = edge.getV();
			int weight = edge.getWeight();

			sum += weight;

			if (sum > min) {
				sum -= weight;
				return;
			}
			dfs(v, e);

			sum -= weight;
		}
	}
}


class Edge {
	private int v;
	private int weight;
	
	public Edge(int v, int weight) {
		super();
		this.v = v;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getV() {
		return v;
	}
	
}