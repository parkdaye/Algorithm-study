package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String s = br.readLine();
			
			Stack<String> stack = new Stack<String>();
			
			boolean isVPS = true;
			for(int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				
				if(now == '(') {
					stack.add("(");
				} else {
					if(stack.isEmpty()) {
						isVPS = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if(!stack.isEmpty())
				isVPS = false;
			
			if(isVPS)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
