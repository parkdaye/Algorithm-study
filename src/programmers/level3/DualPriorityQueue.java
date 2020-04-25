package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class DualPriorityQueue {

	public static void main(String[] args) {
		String[] s = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		int[] answer = solution(s);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

	public static int[] solution(String[] operations) {
		int[] answer = {0, 0};

		List<Integer> q = new ArrayList<>();
		for (int i = 0; i < operations.length; i++) {
			String s = operations[i];
			StringTokenizer st = new StringTokenizer(s);

			String inst = st.nextToken();
			int n = Integer.parseInt(st.nextToken());

			if (inst.equals("I")) {
				q.add(n);
			} else {
				if (q.isEmpty())
					continue;
				else
					Collections.sort(q);

				if (n == 1) {
					q.remove(q.size() - 1);
				} else {
					q.remove(0);
				}
			}
		}

		Collections.sort(q);

		if (!q.isEmpty()) {
			answer[0] = q.get(q.size() - 1);
			answer[1] = q.get(0);
		}
		return answer;
	}
}
