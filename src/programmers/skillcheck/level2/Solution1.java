package programmers.skillcheck.level2;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

	public static void main(String[] args) {
		String[] skills = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution("CBD", skills));
	}

	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        char[] order = new char[skill.length()];
        for(int i = 0; i < skill.length(); i++) {
        	order[i] = skill.charAt(i);
        }
        
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < order.length; i++)
        	list.add(order[i]);

        for(int i = 0; i < skill_trees.length; i++) {
        	String s = skill_trees[i];
        	
        	int now = 0;
        	boolean isPossible = true;
        	for(int j = 0; j < s.length(); j++) {
        		char c = s.charAt(j);
        		
        		if(!list.contains(c))
        			continue;
        		
        		if(order[now] != c) {
        			isPossible = false;
        			break;
        		}
        		
        		now++;
        	}
        	
        	if(isPossible)
        		answer++;
        }
        
        return answer;
    }
}
