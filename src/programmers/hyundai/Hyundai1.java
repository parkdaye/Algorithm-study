package programmers.hyundai;

import java.text.ParseException;
import java.util.StringTokenizer;

public class Hyundai1 {
	public static int[][] calendar = { {0, 0}, { 1, 31 }, { 2, 28 }, { 3, 31 }, { 4, 30 }, { 5, 31 }, { 6, 30 }, { 7, 31 },
			{ 8, 31 }, { 9, 30 }, { 10, 31 }, { 11, 30 }, { 12, 31 } };

	public static void main(String[] args) throws ParseException {
		String[] s = { "2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
		int[] ans = solution(s);
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}

	public static int[] solution(String[] purchase) throws ParseException {

		int date[] = new int[purchase.length];
		int delete[] = new int[purchase.length];
		int money[] = new int[purchase.length];

		for (int i = 0; i < purchase.length; i++) {
			StringTokenizer st = new StringTokenizer(purchase[i]);
			String s = st.nextToken();
			StringTokenizer dateSt = new StringTokenizer(s, "/");

			int year = Integer.parseInt(dateSt.nextToken());
			int month = Integer.parseInt(dateSt.nextToken());
			int day = Integer.parseInt(dateSt.nextToken());
			
			for(int m = 1 ; m < month; m++) {
				date[i] += calendar[m][1];
			}
			date[i] += day;
			delete[i] = date[i] + 30;
			money[i] = Integer.parseInt(st.nextToken());
		}

		int[] answer = new int[5];
		int sum = 0;
		
		for (int i = 1; i <= 365; i++) {
			for(int j = 0; j < purchase.length; j++) {
				if(date[j] == i) {
					sum += money[j];
				}
				
				if(delete[j] == i) {
					sum -= money[j];
				}
			}
			
			if(sum >= 0 && sum < 10000) {
				answer[0]++;
			} else if(sum >= 10000 && sum < 20000) {
				answer[1]++;
			} else if(sum >= 20000 && sum < 50000) {
				answer[2]++;
			} else if(sum >= 50000 && sum < 100000) {
				answer[3]++;
			} else {
				answer[4]++;
			}
		}

		return answer;
	}
}
/***
 * XX쇼핑센터는 다음과 같이 회원 등급제를 운영하고 있습니다.
 * 
 * 등급 기준 브론즈 최근 30일간 0원 이상 10,000원 미만 구매 고객 
 * 실버 최근 30일간 10,000원 이상 20,000원 미만 구매 고객 
 * 골드 최근 30일간 20,000원 이상 50,000원 미만 구매 고객 
 * 플래티넘 최근 30일간 50,000원 이상 100,000원 미만 구매 고객 
 * 다이아몬드 최근 30일간 100,000원 이상 구매 고객 
 * 등급은 브론즈 → 실버 → 골드 → 플래티넘 → 다이아몬드 순으로 높아집니다.
 * 
 * 고객의 2019년 1월 1일 ~ 2019년 12월 31일 기간 동안 구매 기록이 문자열 형태로 담긴 배열 purchase가 매개변수로
 * 주어질 때, 각 등급별 유지 기간을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * 
 * 제한사항 purchase의 길이는 1 이상 365 이하입니다. 
 * purchase의 원소는 2019/MM/DD X 형식입니다.
 * 2019/MM/DD는 2019년 MM월 DD일을 의미하며, 2019/01/01에서 2019/12/31사이입니다. 
 * 구매 기록은 날짜 순으로 정렬되어 있습니다. 같은 날짜의 구매 기록이 중복해서 주어지지 않습니다. 
 * 'X'는 구매 금액을 나타내며 1,000 이상 200,000 이하인 자연수입니다. 구매 금액은 1,000원 단위로만 주어집니다. 
 * 정답 배열은 [브론즈 기간, 실버 기간, 골드 기간, 플래티넘 기간, 다이아몬드 기간] 순서로 채워서 return 해주세요. 
 * 입출력 예 
 * purchase result ["2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"] 
 * [315, 9, 11, 20, 10] 
 * ["2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"] 
 * [245, 30, 30, 30, 30] 
 * 
 * 입출력 예 설명 입출력 예 #1
 * 
 * 2019년 1월 1일에 회원 가입한 고객의 구매 기록과 이에 따른 등급 변화입니다.
 * 
 * 날짜 구매 금액(원) 1월 1일 5,000 1월 20일 15,000 2월 9일 90,000 예를 들어 1월 30일은 1월 1일 ~ 1월
 * 30일까지 30일간 총 구매 금액이 20,000원이므로 골드 등급이며, 1월 31일은 30일간 총 구매 금액이 15,000원으로 실버
 * 등급이 됩니다.
 * 
 * 1월 1일 ~ 1월 19일은 브론즈 등급입니다.(19일) 1월 20일 ~ 1월 30일은 골드 등급입니다.(11일) 1월 31일 ~ 2월
 * 8일은 실버 등급입니다. (9일) 2월 9일 ~ 2월 18일은 다이아 등급입니다. (10일) 2월 19일 ~ 3월 10일은 플래티넘
 * 등급입니다. (20일) 3월 11일 ~ 12월 31일은 브론즈 등급입니다. (296일) 따라서 각 등급별 유지 기간은 [315일, 9일,
 * 11일, 20일, 10일]입니다.
 * 
 * 입출력 예 #2
 * 
 * 각 등급별 유지 기간은 [245일, 30일, 30일, 30일, 30일]입니다.
 */
