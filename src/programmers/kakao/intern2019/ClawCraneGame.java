package programmers.kakao.intern2019;

import java.util.ArrayList;
import java.util.List;

public class ClawCraneGame {

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(solution(board, moves));

	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		List<Integer> selected = new ArrayList<>();
		for (int m = 0; m < moves.length; m++) {
			int move = moves[m] - 1;

			int i = 0;
			int select = 0;
			for (; i < board.length; i++) {
				if (board[i][move] != 0) {
					select = board[i][move];
					board[i][move] = 0;
					break;
				}
			}

			if (i == board.length) {
				continue;
			}

			selected.add(select);

			int size = selected.size();
			if (size >= 2) {
				if (selected.get(size - 1) == selected.get(size - 2)) {
					answer += 2;
					selected.remove(size - 1);
					selected.remove(size - 2);
				}
			}
		}
		return answer;
	}
}
