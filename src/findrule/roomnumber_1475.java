package findrule;
import java.io.*;

public class roomnumber_1475 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] set = new int[10];
		
		for(int i = 0; i < set.length; i++) {
			set[i] = 0;
		}
		
		if(N == 0) {
			System.out.println(1);
			System.exit(0);
		}
		
		for(int i = N; i > 0; i /= 10) {
			int a = i % 10;
			
			if(set[6] - set[9] == 1 && a == 6) {
				set[9]++;
			} else if(set[9] - set[6] == 1 && a== 9) {
				set[6]++;
			} else
				set[a]++;
			
		}
		
		
		int max = 0;
		for(int i = 0; i < set.length; i++)
			if(max < set[i])
				max = set[i];
		
		System.out.println(max);
	}

}
