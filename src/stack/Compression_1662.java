package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Compression_1662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		Stack<String> stack = new Stack<>();

		int temp = 0;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push((temp - 1) + "");
				stack.push(s.charAt(i - 1) + "");
				temp = 0;
				continue;
			}

			if (c == ')') {
				int k = Integer.parseInt(stack.pop());
				int front = Integer.parseInt(stack.pop());
				temp = (temp * k) + front;
				continue;
			}

			temp++;
		}

		System.out.println(temp);
	}
}
