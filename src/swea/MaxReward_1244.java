package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxReward_1244 {
	static char[] num;
	static int E;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			num = new char[6];
			num = st.nextToken().toCharArray();
			E = Integer.parseInt(st.nextToken());
			max = 0;

			change(0, 0);
			
			System.out.println("#" + t + " " + max);
		}
	}

	private static void change(int now, int e) {
		if (e == E) {
			int result = Integer.parseInt(new String(num));
			max = Math.max(result, max);
			return;
		}

		
		for(int i = now; i < num.length - 1; i++) {
			for(int j = i + 1; j < num.length; j++) {
				swap(i, j);
				change(i, e + 1);
				swap(j, i);
			}
		}
	}
	
	private static void swap(int i, int j) {
		char temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
