package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Proctor_13458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); //총감독
		int C = Integer.parseInt(st.nextToken()); //부감독
		
		long sum = 0;
		for(int i = 1; i <= N; i++) {
			//총감독관
			sum++;
			//남은 수에 부감독관 수를 더해줌
			int remains = A[i] - B;
			if(remains > 0)
				sum += Math.ceil(1.0 * remains/C);
		}
		
		System.out.println(sum);
	}

}
