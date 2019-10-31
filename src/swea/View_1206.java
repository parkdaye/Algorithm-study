package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class View_1206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			int B = Integer.parseInt(br.readLine());
			int height[] = new int[B + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= B; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			for (int i = 3; i <= B - 2; i++) {
				int now = height[i];

				int max = 0;
				for (int j = i - 2; j <= i + 2; j++) {
					if (j == i)
						continue;

					if (max < height[j])
						max = height[j];
				}

				if (max < now) {
					count += now - max;
				}
			}
			
			System.out.println("#" + (t +1) +  " " + count);
		}
	}

}
