package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindMode_1204 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int[] score = new int[101];

			int num = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int input = Integer.parseInt(st.nextToken());
				score[input]++;
			}

			int maxCount = 0;
			int mode = 1;
			for (int i = 1; i <= 100; i++) {
				if (maxCount <= score[i]) {
					if (mode < i) {
						maxCount = score[i];
						mode = i;
					}
				}
			}

			System.out.println("#" + num + " " + mode);
		}

	}

}
