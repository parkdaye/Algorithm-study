package programmers.kakao.intern2020;

public class kakao1 {

	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

		System.out.println(solution(num, "right"));
	}

	public static String solution(int[] numbers, String hand) {
		StringBuffer sb = new StringBuffer();

		Point left = new Point(3, 0);
		Point right = new Point(3, 2);

		for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];

			if (num == 1 || num == 4 || num == 7) {
				sb.append("L");
				left.setX(num / 3);
				left.setY(0);
			} else if (num == 3 || num == 6 || num == 9) {
				sb.append("R");
				right.setX((num / 3) - 1);
				right.setY(2);
			} else {
				int x = num / 3;
				int y = 1;

				if (num == 0)
					x = 3;

				int ldist = Math.abs(left.x - x) + Math.abs(left.y - y);
				int rdist = Math.abs(right.x - x) + Math.abs(right.y - y);
				if (ldist < rdist) {
					sb.append("L");
					left.setX(x);
					left.setY(y);
				} else if (ldist == rdist) {
					if (hand.equals("left")) {
						sb.append("L");
						left.setX(x);
						left.setY(y);
					} else {
						sb.append("R");
						right.setX(x);
						right.setY(y);
					}
				} 
				else {
					sb.append("R");
					right.setX(x);
					right.setY(y);
				}
			}

		}
		return sb.toString();
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
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
