package programmers.level3;

public class TileDecorations {

	public static void main(String[] args) {
		System.out.println(solution(6));
	}

	public static long solution(int N) {
        long answer = 0;
        
        long[] length = new long[N + 1];
        length[1] = 1;
        length[2] = 1;
        for(int i = 3; i <= N; i++) {
        	length[i] = length[i - 1] + length[i - 2];
        }
        
        answer = (length[N] + length[N] + length[N-1]) * 2;
        return answer;
    }
}
