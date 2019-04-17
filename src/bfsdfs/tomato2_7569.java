package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class tomato2_7569 {

	private static int box[][][];
	private static int d[][][];
	
	private static int ax[] = {-1, 1, 0, 0, 0, 0};
	private static int ay[] = {0, 0, -1, 1, 0, 0};
	private static int az[] = {0, 0, 0, 0, -1, 1};

	private static int M;
	private static int N;
	private static int H;
	
	private static Queue<Integer> q;
			
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		q = new LinkedList<Integer>();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[N][M][H]; 
		d = new int[N][M][H]; 
		
		//init array
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				
				for(int k = 0; k < M; k++) {
					box[j][k][i] = Integer.parseInt(st.nextToken());
					d[j][k][i] = -1;
				}
			}
		}
		
		//add to queue
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(box[j][k][i] == 1 && d[j][k][i] == -1) {
						q.add(j);
						q.add(k);
						q.add(i);
						d[j][k][i] = 0;
						box[j][k][i] = 1;
					}
				}
			}
		}
		bfs();
		
		
		int max = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(max < d[j][k][i]) {
						max = d[j][k][i];
					}
					if(box[j][k][i] == 0) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			int a = q.remove(); //x
			int b = q.remove(); //y
			int c = q.remove(); //z
		
			for(int i = 0; i < 6; i++) {
				int aa = a + ax[i];
				int bb = b + ay[i];
				int cc = c + az[i];
				
				if(aa >= 0 && aa < N && bb >= 0 && bb < M && cc >= 0 && cc < H) {
					if(box[aa][bb][cc] == 0) {
						q.add(aa);
						q.add(bb);
						q.add(cc);
						d[aa][bb][cc] = d[a][b][c] + 1;
						box[aa][bb][cc] = 1;
					}
						
				}
			}
			
		}
		
	}

}
