package programmers.skillcheck.level2;

public class Solution4 {

	public static void main(String[] args) {
		System.out.println(solution(5));
	}

	public static int solution(int n) {
		
		int ans = 0;

		while(n >= 1) {
			if(n % 2 != 0)
				ans++;
			n /= 2;
		}
		
		return ans;
	}
}
