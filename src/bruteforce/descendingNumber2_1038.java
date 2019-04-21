package bruteforce;
import java.io.*;
import java.util.*;

public class descendingNumber2_1038 {
	private static ArrayList<Long> a;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		a = new ArrayList<Long>();

		for(int i = 1; i <= 9; i++) {
			insert(1, i);
		}
		
		Collections.sort(a);
		
		if(N == 0) {
			System.out.println(0);
		}
		else if(N > a.size()) {
			System.out.println(-1);
		} else {
			System.out.println(a.get(N-1));
		}
		
	}
	
	public static void insert(int digit, long num) {
		
		a.add(num);
		
		long last = num % 10;
		for(int i = 0; i < last; i++)
			insert(digit+1, (num * 10) + i);
	}

}
