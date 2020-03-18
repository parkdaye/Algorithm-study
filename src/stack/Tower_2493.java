package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tower_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int t[] = new int[N + 1];
		Stack<Tower> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {

			while (true) {
				if (stack.isEmpty()) {
					stack.add(new Tower(t[i], i));
					System.out.print(0 + " ");
					break;
				}

				Tower top = stack.peek();
				int topH = top.getH();

				if (t[i] < topH) {
 					stack.push(new Tower(t[i], i));
					System.out.print(top.getLoc() + " ");
					break;
				} else {
					stack.pop();
				}
			}

		}
	}

}

class Tower {
	int h;
	int loc;

	public Tower(int h, int loc) {
		super();
		this.h = h;
		this.loc = loc;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}
}
