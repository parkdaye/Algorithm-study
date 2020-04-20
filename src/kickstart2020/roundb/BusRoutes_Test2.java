package kickstart2020.roundb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BusRoutes_Test2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long D = Long.parseLong(st.nextToken());

			long[] X = new long[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				X[i] = Long.parseLong(st.nextToken());
			}

			long[] day = new long[N + 1];
			long left = 1;
			long right = D / X[1];
			long answer = 0;

			while (left <= right) {
				long mid = (left + right) / 2;

				day[1] = mid * X[1];
				for (int i = 2; i <= N; i++) {
					day[i] = (long) (Math.ceil((double) day[i - 1] / X[i]) * X[i]);
				}

				if (day[N] <= D) {
					answer = day[1];
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

			System.out.println("Case #" + t + ": " + (answer));
		}
	}

}
