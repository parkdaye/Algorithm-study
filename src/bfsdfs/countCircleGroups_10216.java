package bfsdfs;
import java.io.*;
import java.util.*;

public class countCircleGroups_10216 {
	private static ArrayList<Integer>[] aList;
	private static boolean[] checked;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int x[] = new int[N+1];
			int y[] = new int[N+1];
			int R[] = new int[N+1]; 
			
			 aList = (ArrayList<Integer>[]) new ArrayList[N+1];
			checked = new boolean[N+1];
			
			for(int l = 1; l <= N; l++) {
				aList[l] = new ArrayList<Integer>();
				checked[l] = false;
			}
			
			for(int j = 1; j <= N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				x[j] = Integer.parseInt(st.nextToken());
				y[j] = Integer.parseInt(st.nextToken());
				R[j] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int j = 1; j <= N; j++) {
				for(int k = j+1; k <= N; k++) {
					double distance = Math.sqrt(Math.pow((x[k]-x[j]),2.0) + Math.pow((y[k]-y[j]), 2.0));
					if(distance <= R[j] + R[k]) {
						aList[j].add(k);
						aList[k].add(j);
					}
				}
			}
			
			
			int count = 0;
			for(int j = 1; j <= N; j++) {
				if(checked[j] == false) {
					dfs(j);
					count++;
				}
			}
			
			System.out.println(count);
		}
	
	}

	public static void dfs(int n) {
		//System.out.println(n);
		checked[n] = true;
		
		for(int i = 0; i < aList[n].size(); i++) {
			if(checked[aList[n].get(i)] == false)
				dfs(aList[n].get(i));
		}
	}
}
