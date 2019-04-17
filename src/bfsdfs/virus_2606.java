package bfsdfs;
import java.io.*;
import java.util.*;

public class virus_2606 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int V = Integer.parseInt(br.readLine());
		boolean[] checked = new boolean[N+1];
		ArrayList<Integer>[] aList = (ArrayList<Integer>[]) new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			aList[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			aList[a].add(b);
			aList[b].add(a);
		}
		
		for(int i = 0; i < checked.length; i++)
			checked[i] = false;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		checked[1] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			int front = q.remove();
			
			for(int i = 0; i < aList[front].size(); i++) {
				if(checked[aList[front].get(i)] == false) {
					q.add(aList[front].get(i));
					checked[aList[front].get(i)] = true;
					count++;
				}
				
			}
		}
		
		System.out.println(count);
	}

}
