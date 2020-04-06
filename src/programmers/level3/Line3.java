package programmers.level3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author dayepark
 * 110111101111 과 같이 road(String)가 주어짐. 1은 멀쩡한 길 0은 파괴된 길.
 * n(보수할 수 있는 길 갯수)이 주어질 때 최대 멀쩡한 길 구하기
 * 1 <= road, n <= 300000
 */

public class Line3 {
	static int max = 0;
	static List<Integer> unFixed;
	
	public static void main(String[] args) {
		System.out.println(solution("1111101111011110110101111", 2));
	}
	
	public static int solution(String road, int n) {
		unFixed = new ArrayList<>();
		
		for(int i = 0 ; i < road.length(); i++)
			if(road.charAt(i) == '0')
				unFixed.add(i);
		
		int[] roadArray = new int[road.length()];
		for(int i = 0; i < road.length(); i++)
			roadArray[i] = road.charAt(i) -'0';
		dfs(n, 0, 0, roadArray);
		int answer = max;
		return answer;
	}
	
	public static void dfs(int n, int count ,int idx, int[] road) {
		if(count == n) {
			int tmp = 0;
			int tmpMax = 0;
			for(int i = 0; i < road.length; i++) {
				if(road[i] != 0)
					tmp += 1;
				else
					tmp = 0;
				
				tmpMax = Math.max(tmpMax, tmp);
			}

			max = Math.max(max, tmpMax);
			return;
		}
		
		for (int i = idx; i < unFixed.size(); i++) {
			road[unFixed.get(i)] = 1;
			dfs(n, count + 1, i + 1, road);
			road[unFixed.get(i)] = 0;
		}
	}
}
