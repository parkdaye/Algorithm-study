package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author dayepark 문서와 해당 태그들이 주어졌을 때 가장 태그가 많은 순, 동일하면 사전순, 10건 이하의 문서를 반환하도록
 *         1 <= 문서 <= 10^5, 0 <= 태그 <= 10^5
 */
public class Line5 {

	public static void main(String[] args) {
		String[][] dataSource = { { "doc1", "t1", "t2", "t3" }, 
				{ "doc2", "t0", "t2", "t3" },
				{ "doc3", "t1", "t6", "t7" }, 
				{ "doc4", "t1", "t2", "t4" }, 
				{ "doc5", "t6", "t100", "t8" } };
		String[] tags = { "t1", "t2", "t3" };

		String[] ans = solution(dataSource, tags);

		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}

	public static String[] solution(String[][] dataSource, String[] tags) {
		String[] answer = new String[10];

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < tags.length; i++)
			map.put(tags[i], i);

		Map<String, Integer> count = new HashMap<>();
		for (int i = 0; i < dataSource.length; i++) {
			for (int j = 1; j < dataSource[i].length; j++) {
				String tag = dataSource[i][j];
				String doc = dataSource[i][0];

				if (map.containsKey(tag)) {
					if (!count.containsKey(doc))
						count.put(doc, 1);
					else
						count.put(doc, count.get(doc) + 1);
				}
			}
		}

		// count value로 정렬하고 key로 정렬, 10건만 반환
		List<String> ans = sortByValue(count);

		for (int i = 0; i < ans.size(); i++)
			answer[i] = ans.get(i);

		return answer;
	}

	public static List<String> sortByValue(final Map<String, Integer> map) {

		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		Collections.sort(list);

		Collections.sort(list, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				return ((Comparable<Object>) v2).compareTo(v1);
			}
		});

		return list;

	}
}
