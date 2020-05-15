package programmers.skillcheck.level2;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

	public static void main(String[] args) {
		System.out.println(solution("aa1+aa2", "AAAA12"));
	}

	public static int solution(String str1, String str2) {

		Map<String, Integer> s1 = new HashMap<>();
		Map<String, Integer> s2 = new HashMap<>();

		int size1 = makeClustring(s1, str1);
		int size2 = makeClustring(s2, str2);

		int inter = 0;
		for(String key : s1.keySet()) {
			if(s2.containsKey(key)) {
				inter += Math.min(s1.get(key), s2.get(key));
			}
		}

		int sum = size1 + size2 - inter;
		double j = 0;
		if (sum != 0)
			j = (double) inter / sum;
		else
			j = 1;

		return (int) (j * 65536);
	}

	private static int makeClustring(Map<String, Integer> map, String str) {
		int size = 0;
		
		for (int i = 0; i < str.length() - 1; i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(i + 1);

			if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
				String p1 = Character.toString(c1).toUpperCase();
				String p2 = Character.toString(c2).toUpperCase();

				String concat = p1 + p2;
				if (map.containsKey(concat))
					map.put(concat, map.get(concat) + 1);
				else
					map.put(concat, 1);
				size++;
			}
		}
		
		return size;
	}
}
