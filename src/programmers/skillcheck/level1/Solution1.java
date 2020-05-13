package programmers.skillcheck.level1;

import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		String[] part = { "leo", "kiki", "eden" };
		String[] comp = { "eden", "kiki" };

		System.out.println(solution(part, comp));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		int i = 0;
		for(; i < participant.length - 1; i++) {
			if(!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return participant[i];
	}
}
