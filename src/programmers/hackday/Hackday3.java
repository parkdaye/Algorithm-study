package programmers.hackday;

public class Hackday3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(50, 150, 20));
		//System.out.println(solution(3, 8, 4));
	}

	public static int solution(int n, int m, int k) {
		int answer = 0;

		for (int i = 1; i <= k; i++) {
			int blue = i;
			int yellow = 0;
			int slope = 1;

			int t = 1;
			for (int j = i + 1; j <= m;) {
				int temp = k;
				j = j + k;
				if (j - 1 > m)
					temp = k - (j - 1 - m);

				if (t == 1) {
					yellow += temp;
				} else if (t == -1) {
					blue += temp;
				}

				slope++;
				t *= -1;
			}

			if (slope != n)
				continue;

			if (yellow == m / 2 && blue == m / 2)
				answer++;
		}

		answer *= 2;

		if (answer != 0)
			answer = answer % 1000000007;
		return answer;
	}
}
