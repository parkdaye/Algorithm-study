package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//범위를 넘으면 해당 말 종료, 종료된 말은 가지치기
public class DiceYutPlay_17825 {

	// 네 개의 말위치
	static int[] dices;
	static int max;
	static int[] map2 = { 10, 13, 16, 19, 25, 31, 35, 40 };
	static int[] map3 = { 20, 22, 24, 25, 31, 35, 40 };
	static int[] map4 = { 30, 28, 27, 26, 25, 31, 35, 40 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Horses[] horses = new Horses[5];
		dices = new int[10];
		max = 0;

		for (int i = 1; i <= 4; i++)
			horses[i] = new Horses(0, 1);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++)
			dices[i] = Integer.parseInt(st.nextToken());

		dfs(0, 0, horses);

		System.out.println(max);
	}

	public static void dfs(int count, int score, Horses[] horses) {

		// 말이 4번이면 종료
		if (count == 10) {
			max = Math.max(max, score);
			return;
		}
		

		for (int i = 1; i <= 4; i++) {
			int loc = horses[i].getLoc();
			int status = horses[i].getStatus();
			int dice = dices[count];

			// 이동경로를 네가지로 나눠 풀이
			int next = 0;
			switch (status) {
			// 종료를 넘은 시점
			case 0:
				continue;
			case 1:
				next = loc + 2 * dice;
				if (next == 10)
					status = 2;
				else if (next == 20)
					status = 3;
				else if (next == 30)
					status = 4;
				else if (next > 40)
					status = 0;

				break;

			case 2:
				for (int j = 0; j < map2.length; j++) {
					if (map2[j] == loc) {
						if (j + dice < map2.length)
							next = map2[j + dice];
						else
							status = 0;
						break;
					}
				}
				break;
			case 3:
				for (int j = 0; j < map3.length; j++) {
					if (map3[j] == loc) {
						if (j + dice < map3.length)
							next = map3[j + dice];
						else
							status = 0;
						break;
					}
				}
				break;
			case 4:
				for (int j = 0; j < map4.length; j++) {
					if (map4[j] == loc) {
						if (j + dice < map4.length)
							next = map4[j + dice];
						else
							status = 0;
						break;
					}
				}
				break;
			}

			boolean isMoveable = true;
			// 현재 말이 이동할 곳에 다른 말이 있으면
			for (int j = 1; j <= 4; j++) {
				if (status == 0)
					break;

				if ((next == 31 && horses[j].getLoc() == 31) || (next == 35 && horses[j].getLoc() == 35)
						|| (next == 40 && horses[j].getLoc() == 40))
					isMoveable = false;

				if (status == horses[j].status && next == horses[j].getLoc())
					isMoveable = false;
			}
			
			if(!isMoveable)
				continue;
			

			Horses[] copy = new Horses[5];
			for (int j = 1; j <= 4; j++)
				copy[j] = new Horses(horses[j].getLoc(), horses[j].getStatus());
			copy[i].setStatus(status);
			copy[i].setLoc(next);

			if (next == 31)
				next = 30;

			if(status == 0)
				dfs(count + 1, score, copy);
			else 
				dfs(count + 1, score + next, copy);
		}
	}

}

class Horses {
	int loc;
	int status;

	public Horses(int loc, int status) {
		this.loc = loc;
		this.status = status;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
