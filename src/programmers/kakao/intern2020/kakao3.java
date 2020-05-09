package programmers.kakao.intern2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kakao3 {

	public static void main(String[] args) {
		String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		int ans[] = solution(gems);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < gems.length; i++) {
        	String gem = gems[i];
        	if(!map.containsKey(gem)) {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(gem, list);
        	} else {
        		map.get(gem).add(i);
        	}
        }
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for( String key : map.keySet() ){
        	List<Integer> list = map.get(key);
        	max = Math.max(list.get(0), max);
        	min = Math.min(list.get(list.size() - 1), min);
        }
        
        int count = max - min + 1;
        if(count < map.size()) {
        	min = min - (map.size() - (count));
        }

		answer[0] = min + 1;
		answer[1] = max + 1;

        return answer;
    }
}
