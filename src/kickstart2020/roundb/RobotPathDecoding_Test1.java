package kickstart2020.roundb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RobotPathDecoding_Test1 {
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

			Pair p = new Pair(1, 1);
			String result = expanded(p, bracket, prog, 0, prog.length());
			
			if(p.getX() <= 0) {
				p.setX(p.getX() + max);
			}
			
			if(p.getY() <= 0) {
				p.setY(p.getY() + max);
			}
			
			System.out.println("Case #" + t + ": " + p.getX() + " " + p.getY());
		}
	}

	public static String expanded(Pair p, Map<Integer, Integer> b, String s, int l, int r) {
		StringBuffer sb = new StringBuffer();

		for (int i = l; i < r; i++) {
			char c = s.charAt(i);

			if (c == 'N' || c == 'S' || c == 'E' || c == 'W') {
				sb.append(c);
			} else if (Character.isDigit(c)) {
				String tmp = expanded(p, b, s, i + 2, b.get(i + 1));

				int d = c - '0';
				for (int j = 0; j < d; j++)
					sb.append(tmp);
				i = b.get(i + 1);
			}
		}

		return sb.toString();
	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}