package programmers.kakao.intern2020;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class kakao2 {
	static long max = 0;

	public static void main(String[] args) {
		System.out.println(solution("50*6-3*2"));
	}

	public static long solution(String expression) {

		StringTokenizer st = new StringTokenizer(expression, "-*+");

		List<Long> num = new ArrayList<>();
		while (st.hasMoreTokens()) {
			num.add(Long.parseLong(st.nextToken()));
		}

		List<Character> op = new ArrayList<>();
		List<Character> set = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '-' || c == '*' || c == '+') {
				op.add(c);
				if (!set.contains(c))
					set.add(c);
			}
		}

		dfs(set, num, op, 0);

		return max;
	}

	private static void dfs(List<Character> set, List<Long> num, List<Character> op, int cnt) {
		if (cnt == set.size()) {
			if(op.isEmpty())
				max = Math.max(max, Math.abs(num.get(0)));
			return;
		}

		
		for (int i = 0; i < set.size(); i++) {
			char c = set.get(i);
			List<Long> numCopy = new ArrayList<>();
			List<Character> opCopy = new ArrayList<>();
			
			numCopy.addAll(num);
			opCopy.addAll(op);

			for (int j = 0; j < opCopy.size();) {
				if (opCopy.get(j) == c) {
					long op1 = numCopy.get(j);
					long op2 = numCopy.get(j + 1);

					long result = 0;
					switch (c) {
					case '*':
						result = op1 * op2;
						break;
					case '+':
						result = op1 + op2;
						break;
					case '-':
						result = op1 - op2;
						break;
					}
					numCopy.set(j, result);
					numCopy.remove(j + 1);
					opCopy.remove(j);
				} else {
					j++;
				}
			}

			dfs(set, numCopy, opCopy, cnt + 1);
		}
	}

}
