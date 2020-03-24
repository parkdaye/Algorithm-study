package programmers.level3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {

	public static void main(String[] args) throws IOException {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		int[] answer = solution(genres, plays);

		for (int i = 1; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}

	public static int[] solution(String[] genres, int[] plays) {

		Map<String, Integer> gnum = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			if (!gnum.containsKey(genres[i]))
				gnum.put(genres[i], plays[i]);
			else
				gnum.put(genres[i], gnum.get(genres[i]) + plays[i]);
		}

		List<String> gRank = sortByValue(gnum);
		boolean[] isChecked = new boolean[genres.length];
		List<Integer> a = new ArrayList<Integer>();

		for (int i = 0; i < gRank.size(); i++) {
			String now = gRank.get(i);

			for (int k = 0; k < 2; k++) {
				int max = 0;
				int index = 0;
				for (int j = 0; j < genres.length; j++) {
					if (now.equals(genres[j]) && !isChecked[j]) {
						if (plays[j] > max) {
							max = plays[j];
							index = j;
						}
					}
				}

				if (max != 0) {
					isChecked[index] = true;
					a.add(index);
				}
			}
		}
		
		int answer[] = new int[a.size()];
		for(int i = 0; i < a.size(); i++)
			answer[i] = a.get(i);

		return answer;
	}

	public static List<String> sortByValue(final Map<String, Integer> map) {

		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());

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
