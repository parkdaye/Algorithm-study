package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 Priority Queue 로 한번 풀어보자

public class ShortestPath2_1753 {
	static ArrayList<Vertex>[] graph;
	static PriorityQueue<Vertex> pq;
	static int[] min;
	static final int MAX_VALUE = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		graph = (ArrayList<Vertex>[]) new ArrayList[V + 1];
		min = new int[V + 1];
		pq = new PriorityQueue<Vertex>();

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<Vertex>();
		}

		//Arrays.fill(min, MAX_VALUE);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			Vertex vertex = new Vertex(v, w);
			graph[u].add(vertex);
		}
		
		for (int i = 1; i <= V; i++) {
			if(i == K) {
				min[i] = 0;
				pq.offer(new Vertex(i, 0));
			}
			else  {
				min[i] = MAX_VALUE;
				pq.offer(new Vertex(i, MAX_VALUE));
			}
		}
		
		while(!pq.isEmpty()) {
			Vertex vertex = pq.poll();
			int v = vertex.getV();
			int w = vertex.getW();
			
			if(w == MAX_VALUE)
				break;
			
			if(min[v] < w) {
				continue; //  현재 가장 작은 거리가 계산한 거리(큐)보다 작으면 계산할 필요가 없음
			}
			
			for(int i = 0; i < graph[v].size(); i++) { //v에 연결된 정점들
				Vertex linked = graph[v].get(i);
				int lV = linked.getV();
				int lW = linked.getW();
				
				if(min[lV] > min[v] + lW) { 
					//연결된 지점으로 가는 최소값 > 현재 거리값 + (현재 -> 연결지점) 가중치값
					min[lV] = min[v] + lW;
					pq.add(new Vertex(lV, min[lV]));
				}
			}
		}
		
		
		for(int i = 1; i <= V; i++) {
			if(min[i] == MAX_VALUE) 
				System.out.println("INF");
			else
				System.out.println(min[i]);
		}
	}

}

class Vertex implements Comparable<Vertex> {
	private int v; //현재 정점
	private int w; //현재 길이
	
	public Vertex(int v, int w) {
		super();
		this.v = v;
		this.w = w;
	}
	
	
	public int getV() {
		return v;
	}

	public int getW() {
		return w;
	}
	
	@Override
	public int compareTo(Vertex target) {
		return this.w >= target.w ? 1 : - 1;
	}
	
}