package programmers.kakao.intern2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelRoomAssignment {

	public static void main(String[] args) {
		long[] room_num = { 1, 3, 4, 1, 3, 1 };

		long[] ans = solution(10, room_num);
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}

	public static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		
		Map<Long, Long> map = new HashMap<Long, Long>();

		for (int i = 0; i < room_number.length; i++) {
			long want = room_number[i];
			
			if(!map.keySet().contains(want)) {
				answer[i] = want;
				map.put(want, want+1);
			} else {
				List<Long> list = new ArrayList<>();
				while(map.keySet().contains(want)) {
					list.add(want);
					want = map.get(want);
				}

				list.add(want);
				answer[i] = want;
				for(int j = 0; j < list.size(); j++) {
					map.put(list.get(j), want + 1);
				}
			}
		}
		return answer;
	}
}
