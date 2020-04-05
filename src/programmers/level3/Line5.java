package programmers.level3;

public class Line5 {

	public static void main(String[] args) {
		String[][] dataSource = { { "doc1", "t1", "t2", "t3" }, 
				{ "doc2", "t0", "t2", "t3" } ,
				{"doc3", "t1", "t6", "t7"},
				{"doc4", "t1", "t2", "t4"},
				{"doc5", "t6", "t100", "t8"}};
		String[] tags = {};
		
		
		String[] ans = solution(dataSource, tags);
		
		for(int i = 0 ; i < ans.length; i++)
			System.out.println(ans[i]);
	}

	public static String[] solution(String[][] dataSource, String[] tags) {
        String[] answer = {};
        return answer;
    }

}
