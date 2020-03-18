package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ChickenDelivery_15686 {
	static int N;
	static int M;
	static int answer = Integer.MAX_VALUE;
	static int map[][];
	static List<Pair> home;
	static List<Pair> chicken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		home = new LinkedList<>();
		chicken = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					home.add(new Pair(i, j));
				else if (map[i][j] == 2)
					chicken.add(new Pair(i, j));
			}
		}

		boolean[] check = new boolean[chicken.size()];
		dfs(1, 0, check);
		
		System.out.println(answer);
	}

	public static void dfs(int count, int idx, boolean[] check) {
		if (count > M) {
			int tcd = 0;
			for (int i = 0; i < home.size(); i++) {
				Pair h = home.get(i);
				int temp = 0;
				int cd = Integer.MAX_VALUE;

				for (int j = 0; j < chicken.size(); j++) {
					if (check[j]) {
						Pair c = chicken.get(j);
						temp = Math.abs(h.getX() - c.getX()) + Math.abs(h.getY() - c.getY());
						cd = Math.min(cd, temp);
					}
				}
				tcd += cd;
			}
			
			answer = Math.min(answer, tcd);
			return;
		}

		for (int i = idx; i < chicken.size(); i++) {
			check[i] = true;
			dfs(count + 1, i + 1, check);
			check[i] = false;
		}
	}

}
