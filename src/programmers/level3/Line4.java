package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author dayepark
 * 계정이름과 금액이 주어졌을 때, 트랜잭션(중복될수있음) 적용 후 최종 금액 구하기. 대소문자 오름차순
 */

public class Line4 {

	public static void main(String[] args) {
		String[][] snap = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
		String[][] tran = { { "1", "SAVE", "ACCOUNT2", "100" }, { "2", "WITHDRAW", "ACCOUNT1", "50" },
				{ "1", "SAVE", "ACCOUNT2", "100" }, { "4", "SAVE", "ACCOUNT3", "500" },
				{ "3", "WITHDRAW", "ACCOUNT2", "30" } };

		String[][] ans = solution(snap, tran);

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++)
				System.out.println(ans[i][j]);
		}
	}

	public static String[][] solution(String[][] snapshots, String[][] transactions) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < snapshots.length; i++) {
			String name = snapshots[i][0];
			int money = Integer.parseInt(snapshots[i][1]);
			map.put(name, money);
		}

		boolean[] isCheck = new boolean[transactions.length];
		for (int i = 0; i < transactions.length; i++) {
			int id = Integer.parseInt(transactions[i][0]);
			if (isCheck[id])
				continue;

			isCheck[id] = true;
			String inst = transactions[i][1];
			String name = transactions[i][2];
			int money = Integer.parseInt(transactions[i][3]);
			if (!map.containsKey(name)) {
				map.put(name, money);
				continue;
			}

			if (inst.equals("SAVE")) {
				map.put(name, map.get(name) + money);
			} else if (inst.equals("WITHDRAW")) {
				map.put(name, map.get(name) - money);
			}
		}

		List<String> keySet = new ArrayList(map.keySet());
		Collections.sort(keySet);

		String[][] answer = new String[keySet.size()][2];
		for (int i = 0; i < keySet.size(); i++) {
			answer[i][0] = keySet.get(i);
			answer[i][1] = map.get(keySet.get(i)).toString();
		}
		return answer;
	}
}
