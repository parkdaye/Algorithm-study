package programmers.kakao.intern2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Tuple {

	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

		int[] ans = solution(s);
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}

	public static int[] solution(String s) {
		List<String> sList = new ArrayList<>();
		for (int i = 1; i < s.length() - 1; i++) {
			char c = s.charAt(i);

			StringBuffer sb = new StringBuffer();
			if (c == '{') {
				i++;
				while (s.charAt(i) != '}') {
					sb.append(s.charAt(i));
					i++;
				}
				sList.add(sb.toString());
			}
		}

		sList.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length())
					return -1;
				return 1;
			}

		});

		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < sList.size(); i++) {
			int[] tuple = new int[i + 1];
			String now = sList.get(i);

			int index = 0;
			StringTokenizer st = new StringTokenizer(now, ",");
			while (st.hasMoreTokens())
				tuple[index++] = Integer.parseInt(st.nextToken());

			for (int j = 0; j < tuple.length; j++) {
				if (!ans.contains(tuple[j]))
					ans.add(tuple[j]);
			}
		}

		int[] answer = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			answer[i] = ans.get(i);
		return answer;
	}
}
