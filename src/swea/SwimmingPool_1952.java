package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwimmingPool_1952 {
	static int day, month, threeMonth, year;
	static int[] usage;
	static int[] min; //각 달의 최소치
	static int[] answer; //누적 합계

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			usage = new int[13];
			min = new int[13];
			answer = new int[13];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			threeMonth = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= 12; i++) {
				usage[i] = Integer.parseInt(st.nextToken());
				min[i] = Math.min(day * usage[i], month); //최소를 하루치 or 한달치로 초기화
			}
			
			//첫째 달을 최소값을 초기화
			answer[1] = min[1];
			answer[2] = answer[1] + min[2];
			
			for(int i = 3; i <= 12; i++) {
				answer[i] = Math.min(answer[i-1] + min[i], answer[i-3] + threeMonth);
			}
			
			if(year < answer[12]) {
				answer[12] = year;
			}
			
			System.out.println("#" + t +  " " + answer[12]);
		}
	}

}
