package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MinimumSpanningTree_1197 {
	static int parent[];
	static int depth[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Edge> edgeList = new ArrayList<Edge>();
		parent = new int[V+1];
		depth = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
			depth[i] = 0;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(A, B, C));
		}
		
		Collections.sort(edgeList);
		
		int sum = 0;
		for(int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			
			int v1 = edge.getV1();
			int v2 = edge.getV2();
			
			if(find(v1) != find(v2)) {
				union(v1, v2);
				sum += edge.getCost();
			}
		}
		
		System.out.println(sum);
		
	}
	
	private static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return;

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

class Edge implements Comparable<Edge> {
	int v1;
	int v2;
	int cost;

	public Edge(int v1, int v2, int cost) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
	
	public int getV1() {
		return v1;
	}


	public int getV2() {
		return v2;
	}

	public int getCost() {
		return cost;
	}


	@Override
	public int compareTo(Edge o) {
		if (this.cost <= o.cost) {
			return -1;
		} else
			return 1;

	}

}
