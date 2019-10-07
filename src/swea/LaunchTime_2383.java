package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LaunchTime_2383 {
	static int[][] map;
	static int min;
	static List<Location> peopleList;
	static List<Location> exitList;
	static List<Integer> distA;
	static List<Integer> distB;
	static int exitTimeA;
	static int exitTimeB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			min = Integer.MAX_VALUE;
			map = new int[N + 1][N + 1];
			peopleList = new ArrayList<Location>();
			exitList = new ArrayList<Location>();
			// 0부터 순서대로 거리 넣는 배열
			distA = new ArrayList<Integer>();
			distB = new ArrayList<Integer>();
			exitTimeA = 0;
			exitTimeB = 0;

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] != 0) {
						if (map[i][j] == 1)
							peopleList.add(new Location(i, j));
						else {
							exitList.add(new Location(i, j));
							if (exitTimeA == 0)
								exitTimeA = map[i][j];
							else
								exitTimeB = map[i][j];
						}

					}
				}
			}

			dfs(0, 0);

			System.out.println("#" + t + " " + min);
		}
	}

	public static void dfs(int count, int exitNumber) {

		if (count == peopleList.size()) { // count가 꽉 찼을 때 연산 시작
			int time = Math.max(down(distA, exitTimeA), down(distB, exitTimeB));
			if (time < min)
				min = time;

			return;
		}

		for (int i = 0; i <= 1; i++) {
			Location exit = exitList.get(i);
			Location people = peopleList.get(count);

			int distance = Math.abs(exit.getX() - people.getX()) + Math.abs(exit.getY() - people.getY());

			if (i == 0)
				distA.add(distance);
			else
				distB.add(distance);
			
			dfs(count + 1, i);

			// 되돌려놓기
			if (i == 0) 
				distA.remove((Integer) distA.size() - 1);
			else 
				distB.remove((Integer) distB.size() - 1);
			
		}
	}

	public static int down(List<Integer> dist, int exitTime) {

		if (dist.size() == 0)
			return 0;

		// 원 배열이 변경되는 것을 방지하기 위한 deep copy
		List<Integer> copy = new ArrayList<Integer>();

		copy.addAll(dist);
		Collections.sort(copy);

		// 계단 내려갔는지 체크할 배열
		int[] checked = new int[3];
		int time = 1;

		// A 계산
		while (true) {

			for (int i = 0; i < copy.size(); i++) {
				int a = copy.get(i);

				if (a == 0)
					continue; // 이미 계단에 들어갔으면 생략

				if (a <= time) {
					for (int j = 0; j < 3; j++) {
						if (checked[j] <= 0) { // 빈계단에 넣는다
							checked[j] = exitTime;
							copy.set(i, 0); // 계단에 들어간 사람은 0으로 표시

							if (i == copy.size() - 1) { // 가장 마지막 사람이면
								return time + exitTime + 1;
							}

							break; // 해당 시간은 넣었으니 빠져나감
						}
					}
				}
			}

			time++;
			for (int i = 0; i < 3; i++) {
				checked[i]--;
			}
		}
	}
}

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
