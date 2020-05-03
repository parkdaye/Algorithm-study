package programmers.kakao.intern2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BadUser {
	static int ans = 0;
	static List<List<Integer>> candidate;

	public static void main(String[] args) {
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };

		System.out.println(solution(user_id, banned_id));
	}

	public static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;

		candidate = new ArrayList<>();

		boolean[] checked = new boolean[user_id.length];
		dfs(user_id, banned_id, checked, 0, 0);

		answer = ans;
		return answer;
	}

	private static void dfs(String[] user_id, String[] banned_id, boolean[] checked, int uid, int bid) {
		
		if (bid == banned_id.length) {
			List<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < checked.length; i++) {
				if (checked[i])
					list.add(i);
			}
			
			Collections.sort(list);


			for (int i = 0; i < candidate.size(); i++) {
				List<Integer> temp = candidate.get(i);

				if(list.size() != temp.size())
					continue;
				
				int cnt = 0;
				for (int j = 0; j < list.size(); j++) {
					if(temp.get(j) == list.get(j))
						cnt++;
				}
				
				if(cnt == temp.size())
					return;
			}
			
			candidate.add(list);
			ans++;
			return;
		}

		for (int i = 0; i < user_id.length; i++) {
			if (!checked[i] && isBanned(user_id[i], banned_id[bid])) {
				checked[i] = true;
				dfs(user_id, banned_id, checked, i, bid + 1);
				checked[i] = false;
			}
		}

	}

	private static boolean isBanned(String uid, String bid) {
		if (uid.length() != bid.length())
			return false;

		for (int i = 0; i < bid.length(); i++) {
			char c = bid.charAt(i);
			if (c == '*')
				continue;
			if (c != uid.charAt(i))
				return false;
		}
		return true;
	}
}
