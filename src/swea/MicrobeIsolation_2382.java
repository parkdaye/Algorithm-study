package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MicrobeIsolation_2382 {
	static int[] ax = { 0, -1, 1, 0, 0 };
	static int[] ay = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			List<Microbe> mList = new ArrayList<>();

			for (int k = 1; k <= K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				mList.add(new Microbe(x, y, n, d));
			}

			for (int m = 1; m <= M; m++) {

				for (int i = 0; i < mList.size(); i++) {
					Microbe mic = mList.get(i);

					if (mic.getNum() == 0)
						continue;

					int nx = mic.getX() + ax[mic.getD()];
					int ny = mic.getY() + ay[mic.getD()];

					mic.setX(nx);
					mic.setY(ny);
					if (nx == N-1 || nx == 0 || ny == N-1 || ny == 0) {
						mic.setNum(mic.getNum() / 2);
						switch (mic.getD()) {
						case 1:
							mic.setD(2);
							break;
						case 2:
							mic.setD(1);
							break;
						case 3:
							mic.setD(4);
							break;
						case 4:
							mic.setD(3);
							break;
						}
					}

					mList.set(i, mic);
				}

				boolean[] check = new boolean[mList.size()];
				for (int i = 0; i < mList.size() - 1; i++) {
					List<Integer> same = new ArrayList<>();
					Microbe mic = mList.get(i);
					if(check[i] || mic.getNum() == 0)
						continue;
					
					check[i] = true;
					same.add(i);

					for (int j = i + 1; j < mList.size(); j++) {
						Microbe temp = mList.get(j);

						if (mic.getX() == temp.getX() && mic.getY() == temp.getY()) {
							check[j] = true;
							same.add(j);
						}
					}
					
					if(same.size() <= 1)
						continue;

					int max = 0;
					int maxi = 0;
					int tempSum = 0;
					for (int s = 0; s < same.size(); s++) {
						int index = same.get(s);
						if (max < mList.get(index).getNum()) {
							max = mList.get(index).getNum();
							maxi = index;
						}
						tempSum += mList.get(index).getNum();
					}

					for (int s = 0; s < same.size(); s++) {
						int index = same.get(s);
						Microbe mics = mList.get(index);
						mics.setNum(0);
						mList.set(index, mics);
					}

					Microbe maxMic = mList.get(maxi);
					maxMic.setNum(tempSum);
					mList.set(maxi, maxMic);
				}

			}

			int sum = 0;
			for (int i = 0; i < mList.size(); i++) {
				sum += mList.get(i).getNum();
			}

			System.out.println("#" + t + " " + sum);
		}
	}

}

class Microbe {
	int x;
	int y;
	int num;
	int d;

	public Microbe(int x, int y, int num, int d) {
		super();
		this.x = x;
		this.y = y;
		this.num = num;
		this.d = d;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
}
