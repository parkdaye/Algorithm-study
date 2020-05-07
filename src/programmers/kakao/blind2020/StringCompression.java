package programmers.kakao.blind2020;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(solution("a"));
	}

	public static int solution(String s) {
		int answer = Integer.MAX_VALUE;

		for (int count = 1; count <= s.length(); count++) {
			int tmp = 1;
			StringBuffer sb = new StringBuffer();
			String pre = s.substring(0, Math.min(count, s.length()));
			for (int i = count; i < s.length(); i += count) {
				String now = s.substring(i, Math.min(i + count, s.length()));

				if (pre.equals(now)) {
					tmp++;
				} else {
					if (tmp > 1) {
						sb.append(tmp);
						sb.append(pre);
						tmp = 1;
					} else {
						sb.append(pre);
					}
				}

				pre = now;
			}

			if (tmp > 1)
				sb.append(tmp);
			sb.append(pre);

			answer = Math.min(answer, sb.length());
		}
		return answer;
	}
}
