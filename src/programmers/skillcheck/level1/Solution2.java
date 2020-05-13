package programmers.skillcheck.level1;

public class Solution2 {

	public static void main(String[] args) {
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3,5 };

		System.out.println(solution(5, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] num = new int[n + 1];

		for (int i = 0; i < lost.length; i++)
			num[lost[i]] -= 1;

		for (int i = 0; i < reserve.length; i++)
			num[reserve[i]] += 1;

		for (int i = 1; i <= n; i++) {
			if (num[i] == 1) {
				if (num[i - 1] == -1) {
					num[i]--;
					num[i - 1]++;
				} else if (num[i + 1] == -1) {
					num[i]--;
					num[i + 1]++;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (num[i] >= 0)
				answer++;
		}

		return answer;
	}
}
