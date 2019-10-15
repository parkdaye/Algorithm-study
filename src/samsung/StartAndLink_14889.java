package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StartAndLink_14889 {
	static int N;
	static int[][] S;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		S = new int[N + 1][N + 1];
		min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Integer> start = new ArrayList<Integer>();
		start.add(1);
		divideTeam(start, 1);
		
		System.out.println(min);
	}

	private static void divideTeam(List<Integer> start, int teamSize) {
		if (teamSize == N / 2) { //start의 팀이 꽉차면
			
			List<Integer> link = new ArrayList<Integer>();
			for(int i = 1; i <= N; i++)
				if(!start.contains(i))
					link.add(i);

			int startStats = addStats(start);
			int linkStats = addStats(link);
			
			int d = Math.abs(startStats - linkStats);
			min = d < min? d : min;
			return;
		}
		
		

		// 가장 마지막팀을 꺼내옴
		int temp = start.get(start.size() - 1);

		for (int i = temp + 1; i <= N; i++) {
			List<Integer> copy = new ArrayList<Integer>();
			for(int j = 0; j < start.size(); j++) {
				copy.add(start.get(j));
			}
			copy.add(i);
			divideTeam(copy, teamSize + 1);
		}
	}

	private static int addStats(List<Integer> team) {
		int sum = 0;
		
		for(int i = 0; i < team.size(); i++) {
			int now1 = team.get(i);
			
			for(int j = 0; j < team.size(); j++) {
				int now2 = team.get(j);
				if(now1 == now2)
					continue;
				
				sum += S[now1][now2];
			}
		}
		return sum;
	}
}
