package programmers.hackday;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Hackday2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
		int k = 3;

		System.out.println(solution(id_list, k));
	}

	public static int solution(String[] id_list, int k) {
		int answer = 0;

		Map<String, Integer> count = new HashMap<>();
		for (int i = 0; i < id_list.length; i++) {
			String today = id_list[i];

			StringTokenizer st = new StringTokenizer(today);
			Set<String> set = new HashSet<>();
			while (st.hasMoreTokens()) {
				set.add(st.nextToken());
			}

			Iterator<String> it = set.iterator();

			while (it.hasNext()) {
				String id = it.next();

				if (!count.containsKey(id))
					count.put(id, 1);
				else {
					if (count.get(id) >= k)
						continue;
					count.put(id, count.get(id) + 1);
				}
			}
		}

		Object[] values = count.values().toArray();

		for (int i = 0; i < values.length; i++)
			answer += (Integer) values[i];

		return answer;
	}
}
