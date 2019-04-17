package bruteforce;
import java.util.*;
import java.io.*;

public class dividesum_2231 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int i;
		for(i = 1; i < N; i++) {
			int sum = 0;
			int temp = i;
			
			while(temp > 0) {
				//eachNum.add(i % 10);
				sum += temp % 10;
				temp /= 10;
			}
			
			if(sum + i == N) {
				System.out.println(i);
				break;
			}
				
		}
		
		if(i == N)
			System.out.println(0);
	}

}
