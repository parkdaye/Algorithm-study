package bruteforce;
import java.io.*;

public class descendingNumber_1038 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 9;
		long max = (long) 987654321 * 10;
		
		int[][] d = new int[11][10];
		long[] satisfiedMin = new long[11];
		
		if(N < 10) {
			System.out.println(N);
			System.exit(0);
		}
		
		//자리수별 갯수 초기화(인덱스로 사용할것)
		//2자리수
		for(int i = 1; i <= 9; i++)
			d[2][i] = i;
		//3~10자리수
		for(int j = 3; j <= 10; j++) { //자리수
			for(int k = j-1; k <= 9; k++) { //앞자리		
				d[j][k] = d[j-1][k-1] + d[j][k-1];
			}
		}
		
		//최소 만족수 초기화
		for(int i = 2; i <= 10; i++) {
			int temp = 1;
			while(temp <= i) {
				satisfiedMin[i] += (temp-1) * Math.pow(10, temp-1); 
				temp++;
			}
		}

			
		for(int j = 2; j <= 10; j++) { //자리수
			for(int k = j-1; k <= 9; k++) { //앞자리
				
				if(count + d[j][k] >= N) { //인덱스 찾음
					
					long pNum = (long) (k * Math.pow(10, j-1));
				
					if(pNum < satisfiedMin[j]) {
						pNum = satisfiedMin[j];
					}
					
					while(count < N) {
						long temp = pNum;
						boolean isDesc = true;
						
						for(int m = 1; m <= j-1; m++) {
							long backN = (long) temp % 10;
							temp /= 10;
							long frontN = (long) temp % 10;	
							
							if(backN >= frontN) {
								isDesc = false;
								break;
							}
						}
						
						if(isDesc) { 
							count++;
						}
						
						pNum++;	
					}
					
					if(pNum-1 > max) {
						System.out.println(-1);
						System.exit(0);
					} else {
						System.out.println(pNum-1);
						System.exit(0);
					}
				}
				
				count += d[j][k];

				if(j == 10 && k == 9) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}

	}

}
