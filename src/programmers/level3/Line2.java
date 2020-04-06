package programmers.level3;

/**
 * 
 * @author dayepark
 * 부정행위 지수 = 총 의심문항 + (가장긴 의심문항 수) ^ 2 최대 부정행위 지수는?
 */

public class Line2 {

	public static void main(String[] args) {
		String answer_sheet = "24551";
		String[] sheets = { "24553", "24553", "24553", "24553" };

		System.out.println(solution(answer_sheet, sheets));
	}

	public static int solution(String answer_sheet, String[] sheets) {
        int answer = -1;
        
        for(int i = 0; i < sheets.length-1; i++) {
        	for(int j = i+1; j < sheets.length; j++) {
        		
        		int susp = 0;
        		int[] isWrong = new int[answer_sheet.length()];
        		
        		for(int k = 0; k < answer_sheet.length(); k++) {
        			if(sheets[i].charAt(k) == sheets[j].charAt(k) &&
        					sheets[i].charAt(k) != answer_sheet.charAt(k)) {
        				susp++;
        				isWrong[k] = 1;
        			}
        		}
        		
        		int lon = 0;
        		for(int k = 1; k < answer_sheet.length(); k++)
        			if(isWrong[k] != 0)
        				isWrong[k] += isWrong[k-1];
        		
        		for(int k = 0; k < answer_sheet.length(); k++)
        			lon = Math.max(lon, isWrong[k]);
        		
        		answer = (int) Math.max(answer, susp + Math.pow(lon, 2));
        	}
        }
        return answer;
    }
}
