package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class DragonCurve_15685 {

	static int ax[] = { 1, 0, -1, 0 };
	static int ay[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean[][] isChecked = new boolean[101][101];

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			List<Integer> dir = new LinkedList<Integer>();
			dir.add(d);
			isChecked[x][y] = true;
			x += ax[d];
			y += ay[d];
			if (x >= 0 && x <= 100 && y >= 0 && y <= 100)
				isChecked[x][y] = true;

			for (int t = 0; t < g; t++) {
				List<Integer> copy = new LinkedList<Integer>();
				copy.addAll(dir);
				Collections.reverse(copy);

				for (int i = 0; i < copy.size(); i++) {
					int now = copy.get(i);
					switch (now) {
					case 0:
						dir.add(1);
						now = 1;
						break;
					case 1:
						dir.add(2);
						now = 2;
						break;
					case 2:
						dir.add(3);
						now = 3;
						break;
					case 3:
						dir.add(0);
						now = 0;
						break;
					}

					x += ax[now];
					y += ay[now];
					if (x >= 0 && x <= 100 && y >= 0 && y <= 100)
						isChecked[x][y] = true;
				}

			}
		}

		int count = 0;
		for (int i = 0; i <= 99; i++) {
			for (int j = 0; j <= 99; j++) {
				if (isChecked[i][j] && isChecked[i + 1][j] && isChecked[i][j + 1] && isChecked[i + 1][j + 1]) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

}
