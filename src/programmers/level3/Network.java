package programmers.level3;

public class Network {

	public static void main(String[] args) {
		//int[][] com = { {1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] com = { {1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		int answer = solution(3, com);

		System.out.println(answer);
	}

	public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] checked = new boolean[n];
        for(int i = 0; i < n; i++) {
        	if(!checked[i]) {
        		dfs(i, n, checked, computers);
        		answer++;
        	}
        }
        return answer;
    }

	private static void dfs(int i, int n, boolean[] checked, int[][] computers) {
		checked[i] = true;
		
		for(int j = 0; j < n; j++) {
			if(computers[i][j] == 1 && !checked[j]) {
				dfs(j, n, checked, computers);
			}
		}
	}
}
