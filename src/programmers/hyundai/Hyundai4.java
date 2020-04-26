package programmers.hyundai;

import java.util.ArrayList;
import java.util.List;

public class Hyundai4 {
	static int[] ax = { -1, 1, 0, 0 };
	static int[] ay = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		int[][] m = { {1,1},{1,2},{1,4},{2,1},{2,2},{2,3},{3,4},{3,1},{3,2},{3,3}, {3,4},{4,4},{4,3},{5,4},{6,1} };
		String[] ans = solution(m);
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}

	public static String[] solution(int[][] macaron) {

		int map[][] = new int[7][7];
		for (int i = 0; i < macaron.length; i++) {
			int m = macaron[i][0];

			int j = 1;
			while (map[j + 1][m] == 0) {
				j++;
				if (j == 6)
					break;
			}
			map[j][m] = macaron[i][1];

			while (true) {
				boolean pop = false;
				boolean[][] checked = new boolean[7][7];
				for (int x = 1; x <= 6; x++) {
					for (int y = 1; y <= 6; y++) {
						List<Pair> list = new ArrayList<>();
						if (map[x][y] != 0 && !checked[x][y])
							dfs(map, checked, list, x, y);

						if (list.size() >= 3) {
							for (int l = 0; l < list.size(); l++) {
								Pair p = list.get(l);
								map[p.getX()][p.getY()] = 0;
							}
							pop = true;
						}
					}
				}

				if (!pop)
					break;

				for (int y = 1; y <= 6; y++) {
					for (int x = 5; x >= 1; x--) {
						int tmp = x;
						while (map[tmp + 1][y] == 0) {
							map[tmp + 1][y] = map[tmp][y];
							map[tmp][y] = 0;
							tmp++;
							if (tmp == 6)
								break;
						}
					}
				}

			}

		}
		String[] answer = new String[6];

		for (int x = 1; x <= 6; x++) {
			StringBuffer sb = new StringBuffer();
			for (int y = 1; y <= 6; y++) {
				sb.append(map[x][y]);
			}
			answer[x-1] = sb.toString();
			
		}
		return answer;
	}

	private static void dfs(int map[][], boolean[][] checked, List<Pair> p, int x, int y) {
		checked[x][y] = true;
		p.add(new Pair(x, y));

		for (int k = 0; k < 4; k++) {
			int nx = x + ax[k];
			int ny = y + ay[k];

			if (nx > 0 && nx <= 6 && ny > 0 && ny <= 6)
				if (map[nx][ny] == map[x][y] && !checked[nx][ny]) {
					dfs(map, checked, p, nx, ny);
				}
		}
	}
}

class Pair {

	int x;
	int y;

	public Pair(int x, int y) {
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

/**
 * 마카롱 게임은 6 x 6 크기 게임 보드에 위에서 아래 방향으로 마카롱을 하나씩 떨어뜨려 같은 색 마카롱이 상, 하, 좌, 우 방향으로
 * 3개 이상 연결되면 터지는 게임입니다. 마카롱은 항상 빈칸 없이 가장 아래부터 차곡차곡 쌓입니다. 또, 마카롱이 터져서 없어지면 위 칸의
 * 마카롱이 차례대로 아래 칸으로 떨어집니다. 만약, 떨어진 마카롱이 다시 3개 이상 연결된다면 연결된 마카롱도 연쇄적으로 터지며, 더 터지는
 * 마카롱이 없을 때까지 게임 보드 위의 마카롱이 아래 방향으로 떨어집니다. 단, 현재 게임보드에 3개 이상 연결된 마카롱이 여러 개라면
 * 한꺼번에 터진다고 가정합니다.
 * 
 * 아래는 게임이 진행되는 예시입니다. 처음에 게임 보드 각 칸은 전부 빈 상태입니다.
 * 
 * 1. 1번 → 2번 → 1번 → 3번 → 6번 → 3번 위치 순서로 각 색상의 마카롱을 떨어트린 후 보드 상태는 아래 그림과 같습니다.
 * 
 * macaron_11.png
 * 
 * 2. 3번 → 3번 → 3번 위치 순서로 마카롱을 떨어트리면 아래 그림과 같습니다.
 * 
 * macaron_12.png
 * 
 * 3. 2번 위치에서 분홍색 마카롱을 떨어뜨리면 아래 그림과 같이 'X' 표시된 마카롱 4개가 연결되어 없어집니다.
 * 
 * macaron_13.png
 * 
 * 4. 분홍색 마카롱이 없어진 후, 남은 마카롱이 모두 아래 방향으로 떨어집니다. 다시 'X' 표시된 보라색 마카롱 3개가 연결되어
 * 없어집니다.
 * 
 * macaron_14.png
 * 
 * 5. 남은 마카롱이 모두 아래로 떨어진 후 게임 보드 상태는 아래 그림과 같습니다.
 * 
 * maracon_15.png
 * 
 * 어떤 위치에 무슨 색 마카롱을 떨어뜨렸는지에 대한 정보를 담은 2차원 배열 macaron이 매개변수로 주어질 때, 게임이 모두 진행된 후
 * 게임 보드의 상태를 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 * 
 * 제한사항 macaron의 세로(행) 길이는 1 이상 100 이하이며, 가로(열) 길이는 2입니다. macaron의 각 행에는 마카롱을
 * 떨어뜨린 정보가 [떨어뜨린 위치, 마카롱의 색] 형태로 담겨있습니다. 마카롱을 떨어뜨린 위치는 1 이상 6 이하인 자연수입니다. 마카롱의
 * 색은 1 이상 9 이하인 자연수 형태로 표현하며, 같은 색상의 마카롱은 같은 숫자로 표현합니다. 마카롱이 보드 밖으로 나가도록 하거나,
 * 마카롱이 최대 높이까지 쌓인 줄에 다시 마카롱을 떨어뜨리는 경우는 없습니다. 정답은 길이가 6인 문자열 6개를 return 해주세요.
 * return 하는 배열의 첫 번째 원소는 게임 보드의 가장 윗 열을 나타내며, 이후 가장 아래 열까지 순서대로 넣으면 됩니다. 게임
 * 보드에서 빈칸은 0, 마카롱이 채워진 칸은 해당 마카롱의 색을 나타내는 자연수를 채우면 됩니다. 입출력 예 macaron result
 * [[1,1],[2,1],[1,2],[3,3],[6,4],[3,1],[3,3],[3,3],[3,4],[2,1]]
 * [000000,000000,000000,000000,000000,204004]
 * [[1,1],[1,2],[1,4],[2,1],[2,2],[2,3],[3,4],[3,1],[3,2],[3,3],[3,4],[4,4],[4,3],[5,4],[6,1]]
 * [000000,000000,000000,000000,000000,404001] 입출력 예 설명 입출력 예 #1
 * 
 * 문제의 예시와 같습니다.
 * 
 * 입출력 예 #2
 * 
 * 1. 5번 위치에서 4번 색상 마카롱을 떨어뜨리면 연쇄적으로 마카롱이 터지기 시작합니다.
 * 
 * macaron_101.png
 * 
 * 2. macaron_102.png
 * 
 * 3. 현재 게임 보드에서 3개 이상 연결된 마카롱이 한꺼번에 터진 후 남은 마카롱이 아래 방향으로 떨어집니다. 따라서 1번, 2번 색상
 * 마카롱(아래 그림에서 'X' 표시된 마카롱)이 한꺼번에 터진 후 남은 마카롱이 아래 방향으로 떨어집니다.
 * 
 * macaron_103.png
 * 
 * 4. 마지막으로 3번 색상 마카롱이 터지고 6번 위치에서 1번 색상 마카롱을 떨어뜨립니다.
 * 
 * macaron_105.png
 * 
 * 5. 따라서 return 하는 게임보드 상태는 다음과 같습니다.
 */