package programmers.skillcheck.level2;

import java.util.Arrays;

public class Solution2 {

	public static void main(String[] args) {
		int[] cit = { 5, 5, 5, 5, 5 };
		System.out.println(solution(cit));
	}

	public static int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);

		int length = citations.length;
		for (int h = length; h >= 0; h--) {
			int i = length - h;

			if (h == length) {
				if (h <= citations[i]) {
					answer = h;
					break;
				}
			}

			if (h == 0) {
				if (h >= citations[i - 1]) {
					answer = h;
					break;
				}
			}

			if (h <= citations[i] && h >= citations[i - 1]) {
				answer = h;
				break;
			}
		}
		
		return answer;
	}
}
