package programmers.kakao.intern2019;

public class CrossingStepStones {

	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.print(solution(stones, k));
	}

	public static int solution(int[] stones, int k) {
		int mid = 0;
		int left = 0;
		int right = 200000000;

		int answer = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			boolean isPossible = true;

			int cnt = 0;
			for (int i = 0; i < stones.length; i++) {
				int value = stones[i] - mid;
				if (value < 0) {
					cnt++;
					if (cnt >= k) {
						isPossible = false;
						break;
					}
				} else {
					cnt = 0;
				}
			}

			if (isPossible) {
				answer = Math.max(answer, mid);
				left = mid + 1;
			} else
				right = mid - 1;
		}

		return answer;
	}
}
