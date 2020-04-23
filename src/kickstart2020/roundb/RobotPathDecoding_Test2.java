package kickstart2020.roundb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RobotPathDecoding_Test2 {
	static int max = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String prog = br.readLine();

			Stack<Integer> stack = new Stack<>();
			Map<Integer, Integer> bracket = new HashMap<>();
			for (int i = 0; i < prog.length(); i++) {
				char c = prog.charAt(i);

				if (c == '(') {
					stack.add(i);
				} else if (c == ')') {
					int tmp = stack.pop();
					bracket.put(tmp, i);
				}
			}

			Pair p = expanded(bracket, prog, 0, prog.length());
			p.setX((p.getX() + 1) % max);
			p.setY((p.getY() + 1) % max);
			
			if (p.getX() <= 0) {
				p.setX(p.getX() + max);
			}

			if (p.getY() <= 0) {
				p.setY(p.getY() + max);
			}

			System.out.println("Case #" + t + ": " + p.getX() + " " + p.getY());
		}
	}

	public static Pair expanded(Map<Integer, Integer> b, String s, int l, int r) {
		Pair exp = new Pair(0, 0);

		for (int i = l; i < r; i++) {
			char c = s.charAt(i);

			if (c == 'N' || c == 'S' || c == 'E' || c == 'W') {

				switch (c) {
				case 'N':
					exp.setY(exp.getY() - 1);
					break;
				case 'S':
					exp.setY(exp.getY() + 1);
					break;
				case 'E':
					exp.setX(exp.getX() + 1);
					break;
				case 'W':
					exp.setX(exp.getX() - 1);
					break;
				}
			} else if (Character.isDigit(c)) {
				Pair tmp = expanded(b, s, i + 2, b.get(i + 1));

				int d = c - '0';
				
				exp.setX(exp.getX() + d * tmp.getX());
				exp.setY(exp.getY() + d * tmp.getY());
				i = b.get(i + 1);
			}
		}
		
		return exp;
	}
}

class Exp {
	long x;
	long y;
	String result;

	public Exp(long x, long y, String result) {
		super();
		this.x = x;
		this.y = y;
		this.result = result;
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}

	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
}