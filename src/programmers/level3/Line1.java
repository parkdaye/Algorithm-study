package programmers.level3;

import java.util.Stack;

/**
 * 
 * @author dayepark
 * '([)]' '({})' 와 같이 괄호가 제대로 닫혀있는지를 판단하는 문제
 */

public class Line1 {

	public static void main(String[] args) {
		System.out.println(solution("([)]"));
	}

	public static int solution(String inputString) {
		int answer = -1;
		
		Stack<String>[] s  = (Stack<String>[]) new Stack[4];
		for (int i = 0; i < 4; i++) {
			s[i] = new Stack<String>();
		}
		
		int sum = 0;
		for(int i = 0; i < inputString.length(); i++) {
			char now = inputString.charAt(i);
			
			if(now == '(')
				s[0].add("(");
			else if(now == '{')
				s[1].add("{");
			else if(now == '[')
				s[2].add("[");
			else if(now == '<')
				s[3].add("<");
			
			
			if(now == ')') {
				if(s[0].isEmpty()) {
					sum = -1;
					break;
				}
				s[0].pop();
				sum++;
			} else if(now == '}') {
				if(s[1].isEmpty()) {
					sum = -1;
					break;
				}
				s[1].pop();
				sum++;
			} else if(now == ']') {
				if(s[2].isEmpty()) {
					sum = -1;
					break;
				}
				s[2].pop();
				sum++;
			} else if(now == '>') {
				if(s[3].isEmpty()) {
					sum = -1;
					break;
				}
				s[3].pop();
				sum++;
			}
		}
		
		for(int i = 0; i < 4; i++)
			if(s[i].size() != 0)
				sum = -1;
		
		answer = sum;
		return answer;
	}
}
