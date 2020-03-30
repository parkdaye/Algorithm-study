package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Paperfording {

	public static void main(String args[]) {
		int[] answer = solution(4);

		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
	}

	public static int[] solution(int n) {
		int size = 0;
		for (int i = 0; i < n; i++) {
			size += Math.pow(2, i);
		}

		int[] answer = new int[size];

		List<Integer> list = new ArrayList<Integer>();
		list.add(0);

		while (list.size() < size) {
			list.add(0);

			int now = list.size();
			for (int i = now - 2; i >= 0; i--) {
				int j = list.get(i);

				if (j == 0) {
					list.add(1);
				} else {
					list.add(0);
				}
			}
		}

		for (int i = 0; i < size; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
