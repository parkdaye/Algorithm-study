package programmers.hackday;

public class Hackday1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[][] delivery = {{5, 6, 0}, {1, 3, 1}, {1, 5, 0}, {7, 6, 0}, {3, 7, 1}, {2, 5, 0}};
		System.out.println(solution(n, delivery));
	}

	public static String solution(int n, int[][] delivery) {

		char[] ans = new char[n];

		for (int i = 0; i < n; i++)
			ans[i] = '?';

		for (int i = 0; i < delivery.length; i++) {
			if (delivery[i][2] == 1) {
				ans[delivery[i][0] - 1] = 'O';
				ans[delivery[i][1] - 1] = 'O';
			}
		}

		for (int i = 0; i < delivery.length; i++) {
			if (delivery[i][2] == 0)
				if (ans[delivery[i][0] - 1] == 'O') 
					ans[delivery[i][1] - 1] = 'X';
				else if(ans[delivery[i][1] - 1] == 'O')
					ans[delivery[i][0] - 1] = 'X';
		}
		
		String answer = new String(ans);
		return answer;
	}
}
