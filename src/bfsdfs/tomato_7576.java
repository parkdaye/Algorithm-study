package bfsdfs;
import java.io.*;
import java.util.*;

public class tomato_7576 {
	private static int box[][];
	private static int d[][];
	private static int ax[] = {-1, 1, 0, 0};
	private static int ay[] = {0, 0, -1, 1};
	private static int M;
	private static int N;
	private static Queue<Integer> q;
			
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		q = new LinkedList<Integer>();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M]; 
		d = new int[N][M]; 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				d[i][j] = -1;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 1 && d[i][j] == -1) {
					q.add(i);
					q.add(j);
					d[i][j] = 0;
					box[i][j] = 1;
				}
			}
		}
		
		bfs();
		
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(max < d[i][j]) {
					max = d[i][j];
				}
				if(box[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			int a = q.remove();
			int b = q.remove();
		
			for(int i = 0; i < 4; i++) {
				int aa = a + ax[i];
				int bb = b + ay[i];
				
				if(aa >= 0 && aa < N && bb >= 0 && bb < M) {
					if(box[aa][bb] == 0) {
						q.add(aa);
						q.add(bb);
						d[aa][bb] = d[a][b] + 1;
						box[aa][bb] = 1;
					}
						
				}
			}
			
		}
		
	}
}
