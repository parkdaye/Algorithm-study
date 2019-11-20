package findrule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Scale_2920 {

	public static void main(String[] args) throws IOException {
		int[] scale = new int[9];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= 8; i++) {
			scale[i] = Integer.parseInt(st.nextToken());
		}

		int asc = 0;
		int desc = 0;

		for (int i = 1; i <= 8; i++) {
			if (scale[i] == i) {
				asc++;
			} else if (scale[i] == 9 - i) {
				desc++;
			}
		}

		if (asc == 8) {
			System.out.println("ascending");
		} else if (desc == 8) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}

}
