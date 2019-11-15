package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_2747 {
	static int N;
	static int num[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		num = new int[N + 1];

		System.out.println(fibo(N));
	}

	private static int fibo(int n) {
		if (n <= 1) {
			return n;
		} else if(num[n] != 0) {
			return num[n];
		} else
			return num[n] = fibo(n - 1) + fibo(n - 2);
	}

}
