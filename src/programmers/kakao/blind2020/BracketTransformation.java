package programmers.kakao.blind2020;

import java.util.Stack;

public class BracketTransformation {

	public static void main(String[] args) {
		System.out.println(solution("()))((()"));
	}

	public static String solution(String p) {
        String answer = dfs(p);
        return answer;
    }

	private static String dfs(String p) {
		StringBuffer sb = new StringBuffer();
		
        int open = 0;
        int close = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < p.length(); i++) {
        	char c= p.charAt(i);

        	if(c == '(') {
        		open++;
        		stack.add(c);
        	}
        	
        	if(c == ')') {
        		close++;
        		if(stack.isEmpty())
        			stack.add(c);
        		else
        			stack.pop();
        	}
        	
        	if(open == close) {
        		String u = p.substring(0, i + 1);
        		String v = p.substring(i + 1, p.length());
 
        		if(stack.isEmpty()) {
        			sb.append(u);
        			sb.append(dfs(v));
        		} else {
        			sb.append("(");
        			sb.append(dfs(v));
        			sb.append(")");
        			
        			StringBuffer tmp = new StringBuffer();
        			if(u.length() >= 2) {
        				String s =u.substring(1, u.length() - 1);
        				for(int j = 0; j < s.length(); j++) {
        					if(s.charAt(j) == '(') 
        						tmp.append(")");
        					else
        						tmp.append("(");
        				}
        			}
        			sb.append(tmp.toString());
        		}
        		break;
        	}
        }
        
        return sb.toString();
	}
}
